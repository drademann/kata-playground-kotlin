package kata.primefactors

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * # Requirements
 *
 * * For an integer value n the generator should return all prime factors as an ordered list.
 */
class PrimeFactorsTest {

    @Test
    fun one() {
        assertThat(primeFactorsOf(1)).isEmpty()
    }

    @Test
    fun two() {
        assertThat(primeFactorsOf(2)).containsExactly(2)
    }

    @Test
    fun three() {
        assertThat(primeFactorsOf(3)).containsExactly(3)
    }

    @Test
    fun four() {
        assertThat(primeFactorsOf(4)).containsExactly(2, 2)
    }

    @Test
    fun five() {
        assertThat(primeFactorsOf(5)).containsExactly(5)
    }

    @Test
    fun six() {
        assertThat(primeFactorsOf(6)).containsExactly(2, 3)
    }

    @Test
    fun eight() {
        assertThat(primeFactorsOf(8)).containsExactly(2, 2, 2)
    }

    @Test
    fun nine() {
        assertThat(primeFactorsOf(9)).containsExactly(3, 3)
    }

}
