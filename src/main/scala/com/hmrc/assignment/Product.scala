package com.hmrc.assignment

sealed trait Product {
  def cost: Double

  def description: String
}

object Apple extends Product {
  override def cost = 0.60

  override def description = "Apple"
}

object Orange extends Product {
  override def cost = 0.25

  override def description = "Orange"
}