package com.hmrc.assignment

sealed trait Discount {
  def discount(items: List[Product]): Double
}

object OfferBasedDiscount extends Discount {
  def discount(items: List[Product]): Double = {
    val (apples, oranges) = items.partition(_ == Apple)
    val appleDiscount: Double = BuyOneGetOneOffer.discount(Apple.cost, apples.size)
    val orangeDiscount: Double = ThreeForTwoOffer.discount(Orange.cost, oranges.size)
    appleDiscount + orangeDiscount
  }
}