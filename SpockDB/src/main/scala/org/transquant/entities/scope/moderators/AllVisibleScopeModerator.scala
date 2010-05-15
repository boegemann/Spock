package org.transquant.entities.scope.moderators

import org.transquant.entities.api.ScopeModerator
import com.shorrockin.cascal.serialization.StringSerializer

/**
 * Created by IntelliJ IDEA.
 * User: ibogemann
 * Date: 03-May-2010
 * Time: 19:36:24
 * To change this template use File | Settings | File Templates.
 */

class AllVisibleScopeModerator extends ScopeModerator {
  def getScopesToSet(entityTypeURI: String, detailTypeURI: String) = List(Tuple("com.wcg.singlescopeforall", List("All")))

  def getScopesToGet(entityTypeURI: String, detailTypeURI: String) = List(Tuple("com.wcg.singlescopeforall", List(("All"))))

  def getScopeURIsToSearch(entityTypeURI: String, detailTypeURI: String): Seq[String]  = List("com.wcg.singlescopeforall")

  def filterScopes(scopeTypeUri: String, scope: () => Object):Boolean = {
    true
  }
}