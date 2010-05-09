package org.transquant.entities.cascal

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import org.transquant.entities.scope.moderators.AllVisibleScopeModerator
import com.shorrockin.cascal.utils.UUID
import com.shorrockin.cascal.serialization.StringSerializer
import org.transquant.entities.api.commands.{SetEntityDetail, NewEntity}
import com.shorrockin.cascal.utils.Conversions._
import org.transquant.entities.api.{ScopedDomain, SimpleMapBasedDomainSerialiser}

/**
 * Created by IntelliJ IDEA.
 * User: ibogemann
 * Date: 08-May-2010
 * Time: 09:14:41
 * To change this template use File | Settings | File Templates.
 */

class RepositorySpec extends Spec with ShouldMatchers {
  describe("A CascalEntityRepository") {
    val scopeModerator = new AllVisibleScopeModerator();
    val domainSerialiser = new StringOnlyDomainSerialiser;
    val repository = new CascalEntityRepository(ScopedDomain(scopeModerator, domainSerialiser))
    val key = UUID();
    val detailKey = UUID();

    it("should add entities to the Repository as a result of executing NewEntity commands ") {
      repository.executeCommands(List(NewEntity("com.wcg.asset", key)))
      repository.checkForEntity("com.wcg.asset", key) should be(true)
    }

    it("checkForEntity should not not return false positives") {
      repository.checkForEntity("com.wcg.asset", UUID()) should be(false)
    }

    it("should return the last detail entered for an entity when getCurrentDetailsForEntity is called") {
      repository.executeCommands(List(SetEntityDetail("com.wcg.asset", key, "com.wcg.calms.vehicle", detailKey, "Detail")))
      repository.executeCommands(List(SetEntityDetail("com.wcg.asset", key, "com.wcg.calms.vehicle", detailKey, "Detail2")))
      repository.executeCommands(List(SetEntityDetail("com.wcg.asset", key, "com.wcg.calms.vehicle", detailKey, "Detail3")))
      repository.executeCommands(List(SetEntityDetail("com.wcg.asset", key, "com.wcg.calms.vehicle", detailKey,"Detail4")))
      repository.executeCommands(List(SetEntityDetail("com.wcg.asset", key, "com.wcg.calms.vehicle", detailKey, "Detail5")))

      repository.getCurrentDetailsForEntity("com.wcg.asset", "com.wcg.calms.vehicle", key).foreach {
        baDetail => baDetail should be("Detail5")
      }

    }

    it("should return the all details entered for an entity when getHistoricDetailsForEntity is called") {

      repository.getHistoricDetailsForEntity("com.wcg.asset", "com.wcg.calms.vehicle", key).size should be(5)

    }


  }
}