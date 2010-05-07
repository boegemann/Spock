package org.transquant.entities.cascal

import org.transquant.entities.api.EntityMetaDataModerator
import com.shorrockin.cascal.session._
import com.shorrockin.cascal.utils.Conversions._

/**
 * Created by IntelliJ IDEA.
 * User: ibogemann
 * Date: 01-May-2010
 * Time: 07:55:19
 * To change this template use File | Settings | File Templates.
 */

class CascalEntityMetaDataModerator extends EntityMetaDataModerator {
  val colFamilyEntityDefinitions = "SpockMetaData" \ "EntityDefinitions"
  val colFamilyEntityDetailDefinitions = "SpockMetaData" \\ "EntityDetailDefinitions"
  val colFamilyScopeDefinitions = "SpockMetaData" \ "ScopeDefinitions"


  def assureEntityDetailType(entityTypeURI: String, entityDetailTypeURI: String) {
    PoolManager.pool.borrow {
      session =>
        assureEntityType(entityTypeURI);
        if (!testForEntityDetailType(entityTypeURI, entityDetailTypeURI))
          session.insert(colFamilyEntityDetailDefinitions \ entityTypeURI \ entityDetailTypeURI \ ("uri", entityTypeURI))
    }
  }

  def createNewEntityDetailType(entityTypeURI: String, entityDetailTypeURI: String) {
    PoolManager.pool.borrow {
      session =>
        if (!testForEntityType(entityTypeURI))
          throw new RuntimeException("Cant create Entity Detail: '" + entityDetailTypeURI + "' Entity with uri: '" + entityTypeURI + "' does not exist!")
        if (testForEntityDetailType(entityTypeURI, entityDetailTypeURI))
          throw new RuntimeException("Entity Detail: '" + entityDetailTypeURI + "' for Entity with uri: '" + entityTypeURI + "' already exists!")
        session.insert(colFamilyEntityDetailDefinitions \ entityTypeURI \ entityDetailTypeURI \ ("uri", entityTypeURI))
    }
  }

   def createNewScopeType(scopeTypeURI: String) {
    PoolManager.pool.borrow {
      session =>
        if (testForScopeType(scopeTypeURI))
          throw new RuntimeException("Scxope with uri: '" + scopeTypeURI + "' already exists!")
        session.insert(colFamilyScopeDefinitions \ scopeTypeURI \ ("uri", scopeTypeURI))
    }
  }

    def assureScopeType(scopeTypeURI: String) {
    PoolManager.pool.borrow {
      session =>
        if (!testForScopeType(scopeTypeURI))
          session.insert(colFamilyScopeDefinitions \ scopeTypeURI \ ("uri", scopeTypeURI))
    }
  }

    def testForScopeType(scopeTypeURI: String): Boolean = {
    PoolManager.pool.borrow {
      session =>
        session.count(colFamilyScopeDefinitions \ scopeTypeURI) == 1
    }
  }

  def createNewEntityType(entityTypeURI: String) {
    PoolManager.pool.borrow {
      session =>
        if (testForEntityType(entityTypeURI))
          throw new RuntimeException("Entity with uri: '" + entityTypeURI + "' already exists!")
        session.insert(colFamilyEntityDefinitions \ entityTypeURI \ ("uri", entityTypeURI))
    }
  }

  def assureEntityType(entityTypeURI: String) {
    PoolManager.pool.borrow {
      session =>
        if (!testForEntityType(entityTypeURI))
          session.insert(colFamilyEntityDefinitions \ entityTypeURI \ ("uri", entityTypeURI))
    }
  }

  def testForEntityType(entityTypeURI: String): Boolean = {
    PoolManager.pool.borrow {
      session =>
        session.count(colFamilyEntityDefinitions \ entityTypeURI) == 1
    }
  }

  def testForEntityDetailType(entityTypeURI: String, entityDetailTypeURI: String): Boolean = {
    PoolManager.pool.borrow {
      session =>
        session.count(colFamilyEntityDetailDefinitions \ entityTypeURI \ entityDetailTypeURI) > 0
    }
  }
}