package com.hmrc.assignment

sealed trait Checkout {
  def checkout(items: List[Product]): Double
}

class SimpleCheckout extends Checkout {
  override def checkout(items: List[Product]): Double = items.foldLeft(0d)((acc, item) => acc + item.cost)
}

class DiscountBasedCheckout(discounts: List[Discount]) extends SimpleCheckout {
  override def checkout(items: List[Product]): Double = super.checkout(items) - discounts.foldLeft(0d)((acc, discount) => acc + discount.discount(items))
}