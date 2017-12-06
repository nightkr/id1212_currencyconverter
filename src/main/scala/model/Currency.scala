package model

import javax.persistence.{Entity, GeneratedValue, Id}
import scala.beans.BeanProperty

@Entity
class Currency {
  @BeanProperty @Id @GeneratedValue
  var id: Long = _

  @BeanProperty
  var name: String = _

  override def equals(other: Any): Boolean = other match {
    case currency: Currency =>
      id == currency.id && name == currency.name
    case _ => false
  }

  override def hashCode: Int = id.toInt + name.hashCode() * 13
}
