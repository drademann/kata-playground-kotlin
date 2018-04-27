package kata.stringcalculator

import io.kotlintest.be
import io.kotlintest.should
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec

class StringCalculatorTest : StringSpec() {
    init {
        "given an empty String then the result should be 0" {
            sumOf("") should be(0)
        }
        "given a string with a single number should return the number as integer" {
            sumOf("1") should be(1)
        }
        "given comma-separated numbers in a string should return their sum" {
            sumOf("1,2,3") should be(6)
        }
        "should accept line-breaks as delimiter" {
            sumOf("1,2\n3") should be(6)
        }
        "should accept custom delimiters" {
            sumOf("//;\n1;2;3") should be(6)
        }
        "should throw exception given a negative number" {
            shouldThrow<IllegalArgumentException> {
                sumOf("1,-2,3")
            }
        }
        "should ignore numbers greater than 1000" {
            sumOf("1,1000,2,1001,3") should be(1006)
        }
        "Strings should allow getting the sum directly" {
            "1,2,3".sum() should be(6)
        }
        "given null should result in -1 as sum" {
            sumOf(null) should be(-1)
            null.sum() should be(-1)
        }
    }
}