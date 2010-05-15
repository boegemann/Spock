package org.transquant.entities.api

import commands.UriAwareSerialiser

/**
 * Created by IntelliJ IDEA.
 * User: ibogemann
 * Date: 09-May-2010
 * Time: 16:11:11
 * To change this template use File | Settings | File Templates.
 */
case class ScopedDomain (val scopeModerator:ScopeModerator, val domainSerialiser:UriAwareSerialiser, val scopeSerialiser:UriAwareSerialiser)