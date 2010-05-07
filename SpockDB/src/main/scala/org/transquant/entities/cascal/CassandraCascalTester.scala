package org.transquant.entities.cascal


import com.shorrockin.cascal.utils.Conversions._
import com.shorrockin.cascal.session._
import com.shorrockin.cascal.utils.UUID
import com.shorrockin.cascal.serialization.StringSerializer
import org.transquant.entities.api.commands.{SetEntityDetail, NewEntity}
import org.transquant.entities.scope.moderators.AllVisibleScopeModerator


object CassandraCascalTester extends Application {
  val moderator = new CascalEntityMetaDataModerator()
  moderator.assureEntityType("com.wcg.asset")
  println(moderator.testForEntityType("com.wcg.asset"))
  moderator.assureEntityDetailType("com.wcg.asset", "com.wcg.calms.vehicle")
  println(moderator.testForEntityDetailType("com.wcg.asset", "com.wcg.calms.vehicle"))

  moderator.assureScopeType("com.wcg.scope.OneForAll")
  println(moderator.testForScopeType("com.wcg.scope.OneForAll"))



  val repository = new CascalEntityRepository(new AllVisibleScopeModerator())
  val key = UUID();
  repository.executeCommands(List(NewEntity("com.wcg.asset", key)))
  println(repository.checkForEntity("com.wcg.asset", UUID()))
  println(repository.checkForEntity("com.wcg.asset", key))
  val detailKey = UUID();
  repository.executeCommands(List(SetEntityDetail("com.wcg.asset", key, "com.wcg.calms.vehicle", detailKey, StringSerializer.toBytes("Detail"))))
  repository.executeCommands(List(SetEntityDetail("com.wcg.asset", key, "com.wcg.calms.vehicle", detailKey, StringSerializer.toBytes("Detail2"))))
  repository.executeCommands(List(SetEntityDetail("com.wcg.asset", key, "com.wcg.calms.vehicle", detailKey, StringSerializer.toBytes("Detail3"))))
  repository.executeCommands(List(SetEntityDetail("com.wcg.asset", key, "com.wcg.calms.vehicle", detailKey, StringSerializer.toBytes("Detail4"))))
  repository.executeCommands(List(SetEntityDetail("com.wcg.asset", key, "com.wcg.calms.vehicle", detailKey, StringSerializer.toBytes("Detail5"))))

  repository.getCurrentDetailsForEntity("com.wcg.asset", "com.wcg.calms.vehicle", key).foreach {
    baDetail => println(StringSerializer.toString(baDetail))
  }

  repository.getHistoricDetailsForEntity("com.wcg.asset", "com.wcg.calms.vehicle", key).foreach {
    baDetail => println(StringSerializer.toString(baDetail))
  }


}