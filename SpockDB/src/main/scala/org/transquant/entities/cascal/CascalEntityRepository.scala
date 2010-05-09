package org.transquant.entities.cascal

import com.shorrockin.cascal.session.{Insert, Operation}
import com.shorrockin.cascal.utils.Conversions._
import collection.mutable.ListBuffer
import java.util.UUID
import org.transquant.entities.api.commands.{SetEntityDetail, NewEntity, EntityCommand}
import com.shorrockin.cascal.model.{SuperColumn, StandardKey, Column}
import com.shorrockin.cascal.serialization.{StringSerializer, UUIDSerializer}
import org.transquant.entities.api.{ScopedDomain, ScopeModerator, EntityRepository}

/**
 * Created by IntelliJ IDEA.
 * User: ibogemann
 * Date: 02-May-2010
 * Time: 07:16:13
 * To change this template use File | Settings | File Templates.
 */

class CascalEntityRepository(val scopedDomain: ScopedDomain) extends EntityRepository {
  val colEntityEntries = "SpockData" \ "Entities"
  val colEntityDetailIndexes = "SpockData" \\ "EntityDetailIndexes"
  val colEntityDetailEntries = "SpockData" \\ "EntityDetails"


  def getCurrentDetailsForEntity(entityTypeURI: String, detailTypeURI: String, entityId: UUID): Seq[Object] = {
    val deserialise = scopedDomain.domainSerialiser.toObject(detailTypeURI)
    PoolManager.pool.borrow {
      session => {
        scopedDomain.scopeModerator.getScopeURIsToSearch(entityTypeURI, detailTypeURI).flatMap(
          scopeURI => {
            val detailUUID = getIdForEntityDetailAndScopeType(entityTypeURI, entityId, scopeURI)
            session.list(colEntityDetailEntries \ detailUUID).filter {
              scopeCol => scopedDomain.scopeModerator.filterScopes(scopeURI, scopeCol._1.value)
            }.map(
              col => deserialise(col._2.last.value)
              )
          }
          )
      }
    }
  }


  def getHistoricDetailsForEntity(entityTypeURI: String, detailTypeURI: String, entityId: UUID): Seq[Object] = {
    val deserialise = scopedDomain.domainSerialiser.toObject(detailTypeURI)
    PoolManager.pool.borrow {
      session => {
        scopedDomain.scopeModerator.getScopeURIsToSearch(entityTypeURI, detailTypeURI).flatMap(
          scopeURI => {
            val detailUUID = getIdForEntityDetailAndScopeType(entityTypeURI, entityId, scopeURI)
            session.list(colEntityDetailEntries \ detailUUID).filter {
              scopeCol => scopedDomain.scopeModerator.filterScopes(scopeURI, scopeCol._1.value)
            }.flatMap(
              superCol => superCol._2.map {
                col => deserialise(col.value)
              }
              )
          }
          )
      }
    }
  }

  def executeCommands[T >: EntityCommand](commands: List[T]) {
    val operationsBuffer = new ListBuffer[Operation]()
    for (command <- commands) {
      command match {
        case NewEntity(entityTypeURI, id) => {
          if (checkForEntity(entityTypeURI, id)) throw new RuntimeException("Entity of type: " + entityTypeURI + " and id: " + id.toString + " already exisits")
          operationsBuffer += Insert(colEntityEntries \ id \ (entityTypeURI, "True"))
        }

        case SetEntityDetail(entityTypeURI, entityId, entityDetailURI, detailId, detail) => {
          if (!checkForEntity(entityTypeURI, entityId)) throw new RuntimeException("Entity of type: " + entityTypeURI + " and id: " + entityId.toString + " does not exist")
          val serialise = scopedDomain.domainSerialiser.toByteArray 
          scopedDomain.scopeModerator.getScopesToSet(entityTypeURI, entityDetailURI).foreach(
            scopeTuple => {
              val detailUUID = getIdForEntityDetailAndScopeType(entityTypeURI, entityId, scopeTuple._1)
              scopeTuple._2.foreach(
                scope => operationsBuffer += Insert(colEntityDetailEntries \ detailUUID \ scope \ (com.shorrockin.cascal.utils.UUID(), serialise(detail)))
                )
            }
            )
        }

      }
    }
    if (operationsBuffer.length > 0) {
      PoolManager.pool.borrow {
        session =>
          session.batch(operationsBuffer)
      }
    }
  }

  private def getIdForEntityDetailAndScopeType(entityTypeURI: String, entityId: UUID, scopeURI: String): UUID = {
    PoolManager.pool.borrow {
      session =>
        val keyOption = session.get(colEntityDetailIndexes \ entityTypeURI \ scopeURI \ entityId)
        if (keyOption == None) {
          val uuid = com.shorrockin.cascal.utils.UUID()
          session.insert(colEntityDetailIndexes \ entityTypeURI \ scopeURI \ (entityId, uuid))
          uuid
        } else UUIDSerializer.fromBytes(keyOption.get.value)
    }
  }

  def checkForEntity(entityTypeURI: String, id: UUID): Boolean = {
    PoolManager.pool.borrow {
      session =>
        session.get(colEntityEntries \ id \ entityTypeURI) != None
    }
  }

}