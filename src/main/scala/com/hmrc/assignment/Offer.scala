package com.hmrc.assignment

sealed trait Offer[Product] {
  def discount(cost: Double, n: Int): Double
}

object BuyOneGetOneOffer extends Offer[Product] {
  override def discount(cost: Double, n: Int): Double = n / 2 * cost
}

object ThreeForTwoOffer extends Offer[Product] {
  override def discount(cost: Double, n: Int): Double = n / 3 * cost
}