package kata.primefactors

import io.kotlintest.be
import io.kotlintest.matchers.beEmpty
import io.kotlintest.should
import io.kotlintest.specs.StringSpec

class PrimeFactorsTest : StringSpec() {
    init {
        "should return no primefactors for 1" {
            primeFactorsOf(1) should beEmpty()
        }
        "prime factors of 2 should be an array containing exactly 2" {
            primeFactorsOf(2) should be(listOf(2))
        }
        "prime factors of 3 should be an array containing exactly 3" {
            primeFactorsOf(3) should be(listOf(3))
        }
        "prime factors of 4 should be an array containing [2, 2]" {
            primeFactorsOf(4) should be(listOf(2, 2))
        }
        "prime factors of 6 should be an array containing [2, 3]" {
            primeFactorsOf(6) should be(listOf(2, 3))
        }
        "prime factors of 8 should be an array containing [2, 2, 2]" {
            primeFactorsOf(8) should be(listOf(2, 2, 2))
        }
        "prime factors of 9 should be an array containing [3, 3]" {
            primeFactorsOf(9) should be(listOf(3, 3))
        }
    }
}