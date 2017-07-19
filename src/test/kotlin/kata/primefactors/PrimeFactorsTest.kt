package kata.primefactors

import org.junit.Test
import kotlin.test.assertEquals

/**
 * # Requirements
 *
 * * For an integer value n the generator should return all prime factors as an ordered list.
 */
class PrimeFactorsTest {

    @Test
    fun one() {
        assertEquals(expected = emptyList(), actual = primeFactorsOf(1))
    }

    @Test
    fun two() {
        assertEquals(listOf(2), primeFactorsOf(2))
    }

    @Test
    fun three() {
        assertEquals(listOf(3), primeFactorsOf(3))
    }

    @Test
    fun four() {
        assertEquals(listOf(2, 2), primeFactorsOf(4))
    }

    @Test
    fun five() {
        assertEquals(listOf(5), primeFactorsOf(5))
    }

    @Test
    fun six() {
        assertEquals(listOf(2, 3), primeFactorsOf(6))
    }

    @Test
    fun eight() {
        assertEquals(listOf(2, 2, 2), primeFactorsOf(8))
    }

    @Test
    fun nine() {
        assertEquals(listOf(3, 3), primeFactorsOf(9))
    }

}
