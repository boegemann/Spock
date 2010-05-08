package org.transquant.entities.cascal

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import org.junit.runner.RunWith

/**
 * Created by IntelliJ IDEA.
 * User: ibogemann
 * Date: 07-May-2010
 * Time: 21:38:47
 * To change this template use File | Settings | File Templates.
 */
class ModeratorSpec extends Spec with ShouldMatchers {
  describe("A CascalEntityMetaDataModerator") {
    val moderator = new CascalEntityMetaDataModerator()

    it("should contain an entityType after calling assureEntityType") {
      moderator.assureEntityType("com.wcg.asset")
      moderator.testForEntityType("com.wcg.asset") should be(true)
    }

    it("should contain an entityDetailType after calling assureEntityDetailType") {
      moderator.assureEntityDetailType("com.wcg.asset", "com.wcg.calms.vehicle")
      moderator.testForEntityDetailType("com.wcg.asset", "com.wcg.calms.vehicle") should be(true)
    }

    it("should contain a scopeType after calling assureScopeType") {
      moderator.assureScopeType("com.wcg.scope.OneForAll")
      moderator.testForScopeType("com.wcg.scope.OneForAll")  should be(true)
    }
  }
}