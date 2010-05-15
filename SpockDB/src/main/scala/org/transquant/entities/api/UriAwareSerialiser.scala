package org.transquant.entities.api.commands

/**
 * Created by IntelliJ IDEA.
 * User: ibogemann
 * Date: 09-May-2010
 * Time: 14:31:49
 * To change this template use File | Settings | File Templates.
 */

trait UriAwareSerialiser {
  def toObject(detailURI: String): Array[byte] => Object

  def toByteArray(): Object => Array[byte]
}