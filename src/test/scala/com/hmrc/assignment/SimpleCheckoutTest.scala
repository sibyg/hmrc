package com.hmrc.assignment

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SimpleCheckoutTest extends FunSuite {

  trait TestSets {
    val emptyBasket = Nil
    val simpleBasket = List(Apple, Apple, Orange, Apple)
    val simpleCheckout = new SimpleCheckout
  }

  test("checkout: on empty basket") {
    new TestSets {
      assert(simpleCheckout.checkout(Nil) === 0)
    }
  }

  test("checkout: on simple basket") {
    new TestSets {
      assert(simpleCheckout.checkout(simpleBasket) === Apple.cost * 3 + Orange.cost)
    }
  }
}
