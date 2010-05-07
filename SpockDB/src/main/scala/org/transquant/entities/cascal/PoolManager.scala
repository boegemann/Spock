package org.transquant.entities.cascal

import com.shorrockin.cascal.session._

/**
 * Created by IntelliJ IDEA.
 * User: ibogemann
 * Date: 01-May-2010
 * Time: 07:57:06
 * To change this template use File | Settings | File Templates.
 */

object PoolManager {
  val hosts = Host("localhost", 9160, 250) :: Nil
  val params = new PoolParams(10, ExhaustionPolicy.Fail, 500L, 6, 2)
  val pool = new SessionPool(hosts, params, Consistency.One)

 
}