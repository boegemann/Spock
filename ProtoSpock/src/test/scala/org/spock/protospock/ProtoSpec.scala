package org.spock.protospock

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import test.Test._
import test.Test
import com.shorrockin.cascal.utils.UUID
import org.transquant.entities.cascal.{StringOnlyDomainSerialiser, CascalEntityRepository, CascalEntityMetaDataModerator}
import org.transquant.entities.scope.moderators.AllVisibleScopeModerator
import org.transquant.entities.api.commands.{NewEntity, SetEntityDetail}
import org.transquant.entities.api.{Uri2ScopeListScopeModerator, MapBasedUriAwareSerialiser, ScopedDomain}

/**
 * Created by IntelliJ IDEA.
 * User: ibogemann
 * Date: 08-May-2010
 * Time: 13:36:40
 * To change this template use File | Settings | File Templates.
 */

class ProtoSpec extends Spec with ShouldMatchers {
  def personSerialiser(o: Object) = o.asInstanceOf[Person].toByteArray()

  def personDeserialiser(arr: Array[byte]) = Person.parseFrom(arr)

  def systemRoleCompanyScopeSerialiser(o: Object) = o.asInstanceOf[SystemRoleCompanyScope].toByteArray()

  def systemRoleCompanyScopeDeserialiser(arr: Array[byte]) = SystemRoleCompanyScope.parseFrom(arr)

  def filterWcgScopes(scopeTypeUri: String, lazyScope: () => Object): Boolean = {
    lazyScope().asInstanceOf[SystemRoleCompanyScope].getCompany.equals("wcg")
  }

  def systemScopeFilterBuilder(system: String): (String, () => Object) => Boolean = {
    (scopeTypeUri: String, lazyScope: () => Object) => {
      lazyScope().asInstanceOf[SystemRoleCompanyScope].getSystem.equals(system)
    }
  }

  def companyScopeFilterBuilder(company: String): (String, () => Object) => Boolean = {
    (scopeTypeUri: String, lazyScope: () => Object) => {
      lazyScope().asInstanceOf[SystemRoleCompanyScope].getCompany.equals(company)
    }
  }

  describe("A Prototype entity") {


    val domainSerialiser = new MapBasedUriAwareSerialiser(Map("org.transquant.test.bp" -> personDeserialiser), Map(classOf[Person] -> personSerialiser));
    val scopeSerialiser = new MapBasedUriAwareSerialiser(Map("org.transquant.testscope" -> systemRoleCompanyScopeDeserialiser), Map(classOf[SystemRoleCompanyScope] -> systemRoleCompanyScopeSerialiser));


    val comp1Scope = SystemRoleCompanyScope.newBuilder().setSystem("test").setCompany("Miccrosoft").build();
    val comp2Scope = SystemRoleCompanyScope.newBuilder().setSystem("test").setCompany("Apple").build();
    val systemScope = SystemRoleCompanyScope.newBuilder().setSystem("test").setCompany("Sun").build();

    val systemScopeModerator = new Uri2ScopeListScopeModerator(List(Tuple("org.transquant.testscope", List(systemScope))), systemScopeFilterBuilder("test"));
    val comp1ScopeModerator = new Uri2ScopeListScopeModerator(List(Tuple("org.transquant.testscope", List(comp1Scope))), companyScopeFilterBuilder("Miccrosoft"));
    val comp2ScopeModerator = new Uri2ScopeListScopeModerator(List(Tuple("org.transquant.testscope", List(comp2Scope))), companyScopeFilterBuilder("Apple"));

    val systemUserRepository = new CascalEntityRepository(ScopedDomain(systemScopeModerator, domainSerialiser, scopeSerialiser))
    val comp1UserRepository = new CascalEntityRepository(ScopedDomain(comp1ScopeModerator, domainSerialiser, scopeSerialiser))
    val comp2UserRepository = new CascalEntityRepository(ScopedDomain(comp2ScopeModerator, domainSerialiser, scopeSerialiser))

    val key = UUID();
    val detailKey = UUID();
    systemUserRepository.executeCommands(List(NewEntity("org.transquant.bp", key)))

    it("can be serialised and retrieved from SpockDB") {

      val person: Person = Person.newBuilder()
              .setId(UUID().toString)
              .setFirstName("Fred")
              .setSurname("Bloggs")
              .build()

      systemUserRepository.executeCommands(List(SetEntityDetail("org.transquant.bp", key, "org.transquant.test.bp", detailKey, person)))

      val currentDetails = systemUserRepository.getCurrentDetailsForEntity("org.transquant.bp", "org.transquant.test.bp", key);
      currentDetails.length should be(1)
      currentDetails.foreach {
        bp => bp.asInstanceOf[Person].getFirstName should be("Fred")
      }
    }


    it("can be saved in a scope restricted fashion") {
      val personC1: Person = Person.newBuilder()
              .setId(UUID().toString)
              .setFirstName("Fred")
              .setSurname("Microsoft")
              .build()

      val personC2: Person = Person.newBuilder()
              .setId(UUID().toString)
              .setFirstName("Fred")
              .setSurname("Apple")
              .build()


      comp1UserRepository.executeCommands(List(SetEntityDetail("org.transquant.bp", key, "org.transquant.test.bp", detailKey, personC1)))
      comp2UserRepository.executeCommands(List(SetEntityDetail("org.transquant.bp", key, "org.transquant.test.bp", detailKey, personC2)))

      val currentDetails = systemUserRepository.getCurrentDetailsForEntity("org.transquant.bp", "org.transquant.test.bp", key);
      currentDetails.length should be(3)
      currentDetails.foreach {
        bp => bp.asInstanceOf[Person].getFirstName should be("Fred")
      }


      val currentDetails1 = comp1UserRepository.getCurrentDetailsForEntity("org.transquant.bp", "org.transquant.test.bp", key);
      currentDetails1.length should be(1)
      currentDetails1.foreach {
        bp => bp.asInstanceOf[Person].getSurname should be("Microsoft")
      }

      val currentDetails2 = comp2UserRepository.getCurrentDetailsForEntity("org.transquant.bp", "org.transquant.test.bp", key);
      currentDetails2.length should be(1)
      currentDetails2.foreach {
        bp => bp.asInstanceOf[Person].getSurname should be("Apple")
      }
    }


  }

}