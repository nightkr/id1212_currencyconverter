package model

import javax.persistence.{ Entity, GeneratedValue, Id }
import scala.beans.BeanProperty

@Entity
class Currency {
  @BeanProperty @Id @GeneratedValue
  var id: Long = _

  @BeanProperty
  var name: String = _
}
