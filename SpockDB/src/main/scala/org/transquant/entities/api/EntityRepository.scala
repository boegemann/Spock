package org.transquant.entities.api

import commands.EntityCommand
import java.util.UUID

/**
 * Created by IntelliJ IDEA.
 * User: ibogemann
 * Date: 02-May-2010
 * Time: 07:08:26
 * To change this template use File | Settings | File Templates.
 */

trait EntityRepository {
  def executeCommands[T >: EntityCommand](commands: List[T])

  def checkForEntity(entityTypeURI:String , id:UUID): Boolean

  def getCurrentDetailsForEntity(entityTypeURI:String, detailTypeURI:String, entityId:UUID):Seq[Array[byte]]
}
