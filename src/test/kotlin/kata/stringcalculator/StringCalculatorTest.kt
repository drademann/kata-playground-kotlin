package kata.stringcalculator

/**
 * # Requirements
 *
 * Providing an empty string when calculating
 * then the result is 0.
 *
 * 1. Providing a single number when calculating
 *    then the result is the number as integer.
 *
 * 2. Providing two comma separated numbers when calculating
 *    then the result is the sum of the numbers.
 *
 * 3. Providing an unknown amount of comma separated numbers when calculating
 *    then the result is the sum of all numbers.
 *
 * 4. Providing an input string contains a line break instead of comma as delimiter when calculating
 *    then the result is the sum of all numbers.
 *
 * 5. Providing a delimiter is optionally defined on the first line like ```//;``` when calculating
 *    then the result is the sum of all numbers. (e.g. ```//;\n1;2``` should return 3)
 *
 * 6. Providing a negative number when calculating
 *    then throws an exception "negatives not allowed" - and the negative(s) that was passed.
 *
 * 7. Providing numbers bigger than 1000 when calculating
 *    then such numbers should be ignored in the calculation.
 *
 * 8. Providing null
 *    then the result is -1
 *
 * 9. Calculating method should be part of the String API, even for ```null``` Strings.
 *
 * ## Additional Requirements
 *
 * Use the following advanced requirements if you finish the previous steps lightning fast:
 *
 * a. Providing delimiters of any length (```//[delimiter]\n```) when calculating
 *    then the result is the sum of the numbers. (e.g. ```//[xx]\n1xx2xx3``` should return 6)
 *
 * b. Providing multiple delimiters (```//[delim1][delim2]\n```) when calculating
 *    then the result is the sum of the numbers. (e.g. ```//[x][y]\n1x2y3``` should return 6)
 *
 * c. Providing multiple delimiters with variable length when calculating
 *     then the result is the sum of the numbers.
 */
class StringCalculatorTest {
/*
    @Test
    fun givenEmptyString_shouldReturnZero() {
        assertThat(sumOf("")).isEqualTo(0)
    }

    @Test
    fun givenSingleNumber_shouldReturnNumberAsInt() {
        assertThat(sumOf("1")).isEqualTo(1)
    }

    @Test
    fun givenTwoCommaSeparatedNumbers_shouldReturnTheirSum() {
        assertThat(sumOf("1,2")).isEqualTo(3)
    }

    @Test
    fun givenManyCommaSeparatedNumbers_shouldReturnTheirSum() {
        assertThat(sumOf("1\n5,3,1")).isEqualTo(10)
    }

    @Test
    fun givenCustomDelimiter_shouldUseItToSeparateNumbers() {
        assertThat(sumOf("//;\n1;2;3")).isEqualTo(6)
    }

    @Test
    fun givenNegativeNumber_shouldRaiseException() {
        try {
            sumOf("1,-2,3")
            fail("should raise exception instead of getting here")
        } catch (exception: IllegalArgumentException) {
            // success
        }
    }

    @Test
    fun givenNumbersGreater1000_shouldIgnoreThose() {
        assertThat(sumOf("1,1000,2,1001,3")).isEqualTo(1006)
    }

    @Test
    fun givenString_shouldAllowCalculatingItsSum() {
        assertThat("1,2,3".sum()).isEqualTo(6)
    }

    @Test
    fun givenNull_shouldReturnMinusOne() {
        assertThat(sumOf(null)).isEqualTo(-1)
        assertThat(null.sum()).isEqualTo(-1)
    }
*/
}