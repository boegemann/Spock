package org.transquant.entities.api

import commands.UriAwareSerialiser

/**
 * Created by IntelliJ IDEA.
 * User: ibogemann
 * Date: 09-May-2010
 * Time: 15:41:41
 * To change this template use File | Settings | File Templates.
 */
class MapBasedUriAwareSerialiser(val detailUri2Deserialiser: Map[String, Array[byte] => Object], val class2Serialiser: Map[Class[_], Object => Array[byte]]) extends UriAwareSerialiser {
  def toObject(detailURI: String): Array[byte] => Object = {
    arr => {
      var f1 = detailUri2Deserialiser.get(detailURI).get
      f1(arr)
    }
  }

  def toByteArray(): Object => Array[byte] = {
    entity => {
      class2Serialiser.get(entity.getClass).get(entity)
    }
  }
}


