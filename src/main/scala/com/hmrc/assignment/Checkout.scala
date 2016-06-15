package com.hmrc.assignment

sealed trait Checkout {
  def checkout(items: List[Product]): Double
}

class SimpleCheckout extends Checkout {
  override def checkout(items: List[Product]): Double = items.foldLeft(0d)((acc, item) => acc + item.cost)
}