package view

import javax.annotation.PostConstruct
import javax.ejb.EJB
import javax.enterprise.context.SessionScoped
import javax.transaction.Transactional
import scala.beans.BeanProperty
import scala.collection.JavaConverters._

import javax.enterprise.context.RequestScoped
import javax.inject.{Inject, Named}
import controller.CurrencyConverter

@Named
@SessionScoped
@Transactional
class ViewBacking extends Serializable {
  @EJB
  private var currencyConverter: CurrencyConverter = _

  var sourceCurrency: Long = -1

  def getSourceCurrency = sourceCurrency

  def setSourceCurrency(id: Long): Unit = {
    sourceCurrency = id
    Option(getTargetCurrencies.get(0)).foreach(curr => targetCurrency = curr.id)
  }

  @BeanProperty
  var targetCurrency: Long = -1

  @BeanProperty
  var sourceAmount: Double = 1

  @PostConstruct
  def init(): Unit = {
    if (sourceCurrency == -1) {
      Option(getSourceCurrencies.get(0)).foreach(curr =>
        sourceCurrency = curr.id)
    }
    if (targetCurrency == -1) {
      Option(getTargetCurrencies.get(0)).foreach(curr =>
        targetCurrency = curr.id)
    }
  }

  def targetAmount: Either[String, Double] =
    currencyConverter
      .convert(sourceAmount, sourceCurrency, targetCurrency)
      .toRight("No exchange rate between these currencies")

  def getTargetAmount = targetAmount.right.get
  def isTargetCalculated = targetAmount.isRight

  def getTargetError = targetAmount.left.get
  def isTargetFailed = targetAmount.isLeft

  def getSourceCurrencies = currencyConverter.sourceCurrencies.asJava
  def getTargetCurrencies =
    currencyConverter.targetCurrencies(sourceCurrency).asJava
}
