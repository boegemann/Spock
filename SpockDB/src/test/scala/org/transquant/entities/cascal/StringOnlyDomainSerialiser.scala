package org.transquant.entities.cascal

import org.transquant.entities.api.commands.UriAwareSerialiser
import com.shorrockin.cascal.serialization.StringSerializer
import com.shorrockin.cascal.utils.Conversions._

/**
 * Created by IntelliJ IDEA.
 * User: ibogemann
 * Date: 09-May-2010
 * Time: 18:25:01
 * To change this template use File | Settings | File Templates.
 */

class StringOnlyDomainSerialiser extends UriAwareSerialiser {
  def toObject(detailURI: String): Array[byte] => Object = {
    byteArray: Array[byte] =>
      StringSerializer.toString(byteArray)

  }

  def toByteArray(): Object => Array[byte] = {
    o: Object =>  StringSerializer.toBytes(o.asInstanceOf[String])
  }
}