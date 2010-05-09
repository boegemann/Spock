package org.transquant.entities.api.commands

import java.util.UUID

/**
 * Created by IntelliJ IDEA.
 * User: ibogemann
 * Date: 01-May-2010
 * Time: 14:08:25
 * To change this template use File | Settings | File Templates.
 */

abstract class EntityCommand

case class NewEntity(entityTypeURI: String, id: UUID) extends EntityCommand

case class SetEntityDetail(val entityTypeURI: String, val entityId: UUID, val entityDetailURI: String, val detailId: UUID, detail: Object) extends EntityCommand

case class ConnectDetailToEntity(entityId: UUID, detailId: UUID, scope: Array[byte]) extends EntityCommand

case class ReplaceDetailForEntity(entityId: UUID, scopeId:UUID, newDetailId: UUID, newDetail: Array[byte]) extends EntityCommand

case class ReplaceDetailConnectionForEntity(entityId: UUID, scopeId:UUID, newDetailId: UUID) extends EntityCommand
