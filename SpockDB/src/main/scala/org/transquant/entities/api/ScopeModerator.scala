package org.transquant.entities.api

/**
 * Created by IntelliJ IDEA.
 * User: ibogemann
 * Date: 03-May-2010
 * Time: 08:48:51
 * To change this template use File | Settings | File Templates.
 */

trait ScopeModerator {
  def getScopesToSet(entityTypeURI: String, detailTypeURI: String): Seq[Tuple2[String, Seq[Array[byte]]]]

  def getScopeURIsToSearch(entityTypeURI: String, detailTypeURI: String): Seq[String]

  def filterScopes(scopeTypeUri:String,scope:Array[byte]):Boolean

  def getScopesToGet(entityTypeURI: String, detailTypeURI: String): Seq[Tuple2[String, Seq[Array[byte]]]]
}