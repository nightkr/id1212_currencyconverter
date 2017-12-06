package model

import scala.beans.BeanProperty

import javax.persistence.{Entity, GeneratedValue, Id, ManyToOne}

@Entity
class ExchangeRate {
  @BeanProperty @Id @GeneratedValue
  var id: Long = _

  @BeanProperty @ManyToOne
  var from: Currency = _

  @BeanProperty @ManyToOne
  var to: Currency = _

  @BeanProperty
  var price: Double = _
}
