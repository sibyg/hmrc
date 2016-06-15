package com.hmrc.assignment

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CheckoutTest extends FunSuite {

  trait TestSets {
    val emptyBasket = Nil
    val simpleBasket = List(Apple, Apple, Orange, Apple)
    val simpleCheckout = new SimpleCheckout
    val discountBasedCheckout = new DiscountBasedCheckout(List(OfferBasedDiscount))

    def totalCost(basket: List[Product]) = {
      basket.foldLeft(0d)((acc, product) => acc + product.cost)
    }
  }

  test("checkout: on empty basket") {
    new TestSets {
      assert(simpleCheckout.checkout(Nil) === 0)
    }
  }

  test("checkout: on simple basket") {
    new TestSets {
      assert(simpleCheckout.checkout(simpleBasket) === totalCost(simpleBasket))
    }
  }

  test("discount based checkout") {
    new TestSets {
      assert(discountBasedCheckout.checkout(simpleBasket) === totalCost(simpleBasket) - OfferBasedDiscount.discount(simpleBasket))
    }
  }
}
