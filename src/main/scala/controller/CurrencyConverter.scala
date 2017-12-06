package controller

import scala.collection.JavaConverters._

import javax.ejb.Stateless
import javax.persistence.{EntityManager, PersistenceContext}
import javax.transaction.Transactional
import model.{Currency, ExchangeRate}

@Stateless
@Transactional
class CurrencyConverter {
  @PersistenceContext
  private var entityManager: EntityManager = _

  def currencies: Seq[Currency] =
    entityManager
      .createQuery("from Currency", classOf[Currency])
      .getResultList
      .asScala
      .toSeq

  def convert(amount: Double, from: Long, to: Long): Option[Double] =
    if (from == to) {
      Some(amount)
    } else {
      val rate = entityManager
        .createQuery(
          "from ExchangeRate rate where rate.from.id = ? and rate.to.id = ?",
          classOf[ExchangeRate])
        .setParameter(0, from)
        .setParameter(1, to)
        .getResultList
        .asScala
        .headOption
      rate.map(rate => amount / rate.ratio)
    }
}
