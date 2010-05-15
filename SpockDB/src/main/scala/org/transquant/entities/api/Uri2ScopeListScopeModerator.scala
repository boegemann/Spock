package org.transquant.entities.api


/**
 * Created by IntelliJ IDEA.
 * User: ibogemann
 * Date: 14-May-2010
 * Time: 19:46:46
 * To change this template use File | Settings | File Templates.
 */
class Uri2ScopeListScopeModerator(val scopeConfig: List[Tuple2[String, List[Object]]], val scopeFilter: (String, () => Object) => Boolean) extends ScopeModerator {
  private val scopeUris = scopeConfig.map(_._1)

  override def getScopesToSet(entityTypeURI: String, detailTypeURI: String) = scopeConfig

  override def getScopeURIsToSearch(entityTypeURI: String, detailTypeURI: String): Seq[String] = scopeUris

  override def filterScopes(scopeTypeUri: String, lazyScope: () => Object) = scopeFilter(scopeTypeUri, lazyScope)
}