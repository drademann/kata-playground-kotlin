package kata.stringcalculator

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.fail

/**
 * # Requirements
 *
 * Providing an empty string when calculating
 * then the result is 0.
 *
 * 1. Providing a single number when calculating
 * then the result is the number as integer.
 *
 * 2. Providing two comma separated numbers when calculating
 * then the result is the sum of the numbers.
 *
 * 3. Providing an unknown amount of comma separated numbers when calculating
 * then the result is the sum of all numbers.
 *
 * 4. Providing an input string contains a line break instead of comma as delimiter when calculating
 * then the result is the sum of all numbers.
 *
 * 5. Providing a delimiter is optionally defined on the first line like ```//;``` when calculating
 * then the result is the sum of all numbers. (e.g. ```//;\n1;2``` should return 3)
 *
 * 6. Providing a negative number when calculating
 * then throws an exception "negatives not allowed" - and the negative(s) that was passed.
 *
 * 7. Providing numbers bigger than 1000 when calculating
 * then such numbers should be ignored in the calculation.
 *
 * ## Additional Requirements
 *
 * Use the following advanced requirements if you finish the previous steps
 * in less than 30 minutes.
 *
 * 8. Providing delimiters of any length (```//[delimiter]\n```) when calculating
 * then the result is the sum of the numbers. (e.g. ```//[xx]\n1xx2xx3``` should return 6)
 *
 * 9. Providing multiple delimiters (```//[delim1][delim2]\n```) when calculating
 * then the result is the sum of the numbers. (e.g. ```//[x][y]\n1x2y3``` should return 6)
 *
 * 10. Providing multiple delimiters with variable length when calculating
 * then the result is the sum of the numbers.
 */
class StringCalculatorTest {

    @Test
    fun givenEmptyString_shouldReturnZero() {
        assertEquals(0, sumOf(""))
    }

    @Test
    fun givenSingleNumber_shouldReturnNumberAsInt() {
        assertEquals(1, sumOf("1"))
    }

    @Test
    fun givenTwoCommaSeparatedNumbers_shouldReturnTheirSum() {
        assertEquals(3, sumOf("1,2"))
    }

    @Test
    fun givenManyCommaSeparatedNumbers_shouldReturnTheirSum() {
        assertEquals(10, sumOf("1\n5,3,1"))
    }

    @Test
    fun givenCustomDelimiter_shouldUseItToSeparateNumbers() {
        assertEquals(6, sumOf("//;\n1;2;3"))
    }

    @Test
    fun givenNegativeNumber_shouldRaiseException() {
        try {
            sumOf("1,-2,3")
            fail("should raise exception instead of getting here")
        } catch(exception: IllegalArgumentException) {
            // success
        }
    }

    @Test
    fun givenNumbersGreater1000_shouldIgnoreThose() {
        assertEquals(6, sumOf("1,1002,2,2003,3"))
    }

}