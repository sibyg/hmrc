package com.hmrc.assignment

import org.scalatest.FunSuite

class DiscountTest extends FunSuite {

  trait TestData {
    val emptyBasket = Nil
    val noOffersBasket = List(Apple, Orange, Orange)
    val appleOffersBasket = List(Apple, Apple, Orange, Apple)
    val orangeOffersBasket = List(Orange, Orange, Orange, Apple)
    val appleAndOrangeOffersBasket = appleOffersBasket union orangeOffersBasket

    def totalCost(basket: List[Product]) = {
      basket.foldLeft(0d)((acc, product) => acc + product.cost)
    }

    def number(product: Product, basket: List[Product]) = basket.count(_ == product)
  }

  test("offer based discount : empty basket") {
    new TestData {
      assert(OfferBasedDiscount.discount(emptyBasket) === 0)
    }
  }

  test("offer based discount : no offers") {
    new TestData {
      assert(OfferBasedDiscount.discount(noOffersBasket) === 0)
    }
  }

  test("offer based discount: only apple offer") {
    new TestData {
      assert(OfferBasedDiscount.discount(appleOffersBasket) === BuyOneGetOneOffer.discount(Apple.cost, number(Apple, appleOffersBasket)))
    }
  }

  test("offer based discount: only orange offer") {
    new TestData {
      assert(OfferBasedDiscount.discount(orangeOffersBasket) === ThreeForTwoOffer.discount(Orange.cost, number(Orange, orangeOffersBasket)))
    }
  }

  test("offer based discount: mixed : apple and orange offers") {
    new TestData {
      assert(OfferBasedDiscount.discount(appleAndOrangeOffersBasket) ===
        BuyOneGetOneOffer.discount(Apple.cost, number(Apple, appleAndOrangeOffersBasket)) +
          ThreeForTwoOffer.discount(Orange.cost, number(Orange, appleAndOrangeOffersBasket)))
    }
  }
}
