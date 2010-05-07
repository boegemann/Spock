package org.transquant.entities.api

import org.transquant.entities.cascal.PoolManager

/**
 * Created by IntelliJ IDEA.
 * User: ibogemann
 * Date: 01-May-2010
 * Time: 07:54:19
 * To change this template use File | Settings | File Templates.
 */

trait EntityMetaDataModerator {
  def testForEntityType(entityTypeURI: String): Boolean

  def assureEntityType(entityTypeURI: String)

  def createNewEntityType(entityTypeURI: String)


  def testForEntityDetailType(entityTypeURI: String, entityDetailTypeURI: String): Boolean

  def assureEntityDetailType(entityTypeURI: String, entityDetailTypeURI: String)

  def createNewEntityDetailType(entityTypeURI: String, entityDetailTypeURI: String)
  

  def createNewScopeType(scopeTypeURI: String)

  def assureScopeType(scopeTypeURI: String)

  def testForScopeType(scopeTypeURI: String): Boolean
}