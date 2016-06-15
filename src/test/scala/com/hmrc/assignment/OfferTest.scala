package com.hmrc.assignment

import org.scalatest.FunSuite

class OfferTest extends FunSuite {

  trait TestData {
    val random = scala.util.Random
    val bound = 1000
    val cost = random.nextInt(bound)
    val evenCount = random.nextInt(bound) * 2
    val oddCount = evenCount + 1
    val multipleOfThreeCount = random.nextInt(bound) * 3
    val nonMultipleOfThreeCount = multipleOfThreeCount + 1
  }

  test("buyonegetone: event products") {
    new TestData {
      assert(BuyOneGetOneOffer.discount(cost, evenCount) === evenCount / 2 * cost)
    }
  }

  test("buyonegetone: odd products") {
    new TestData {
      assert(BuyOneGetOneOffer.discount(cost, oddCount) === oddCount / 2 * cost)
    }
  }

  test("threefortwo: multiple of 3 products") {
    new TestData {
      assert(ThreeForTwoOffer.discount(cost, multipleOfThreeCount) === multipleOfThreeCount / 3 * cost)
    }
  }
  test("threefortwo: non - multiple of 3 products") {
    new TestData {
      assert(ThreeForTwoOffer.discount(cost, nonMultipleOfThreeCount) == nonMultipleOfThreeCount / 3 * cost)
    }
  }
}
