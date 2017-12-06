package view

import javax.ejb.EJB
import javax.enterprise.context.SessionScoped
import javax.transaction.Transactional
import scala.beans.BeanProperty
import scala.collection.JavaConverters._

import javax.enterprise.context.RequestScoped
import javax.inject.{Inject, Named}
import controller.CurrencyConverter

@Named
@RequestScoped
@Transactional
class ViewBacking {
  @EJB
  private var currencyConverter: CurrencyConverter = _

  var submitted: Boolean = false

  @BeanProperty
  var sourceCurrency: Long = 0

  @BeanProperty
  var targetCurrency: Long = 0

  @BeanProperty
  var sourceAmount: Double = 1

  def formSubmitted(): Unit =
    submitted = true

  def targetAmount: Option[Either[String, Double]] =
    if (submitted) {
      Some(
        currencyConverter
          .convert(sourceAmount, sourceCurrency, targetCurrency)
          .toRight("No exchange rate between these currencies"))
    } else {
      None
    }

  def getTargetAmount = targetAmount.get.right.get
  def isTargetCalculated = targetAmount.map(_.isRight).getOrElse(false)

  def getTargetError = targetAmount.get.left.get
  def isTargetFailed = targetAmount.map(_.isLeft).getOrElse(false)

  def getCurrencies = currencyConverter.currencies.asJava
}
