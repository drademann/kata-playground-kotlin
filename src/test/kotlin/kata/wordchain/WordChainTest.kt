package kata.wordchain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * # Requirements
 *
 * This feature tries to findChain a way to get from one word to another by changing only one letter per step.
 * The length of the word doesn't change and the word must be a valid and known english word and not some
 * fantasy creation.
 *
 * In example you can get from cat to dog this way:
 *
 * cat - cot - cog - dog
 *
 * _ps._ findChain a long list of words in ```src/test/resources```
 */
class WordChainTest {

    @Test
    fun givenEmptyStrings_shouldReturnEmptyArrayOfStrings() {
        val chain = Words("a", "b", "c").findChain(from = "", to = "")

        assertThat(chain).isEmpty()
    }

    @Test
    fun givenFromToWithDifferentLength_shouldReturnEmptyArray() {
        val chain = Words("a", "b", "c").findChain(from = "a", to = "bb")

        assertThat(chain).isEmpty()
    }

    @Test
    fun givenSimpleConnection_shouldReturnArrayWithFromTo() {
        val chain = Words("a", "b", "c").findChain(from = "a", to = "c")

        assertThat(chain).containsExactly("a", "c")
    }

    @Test
    fun givenNoConnectionExists_shouldReturnEmptyArray() {
        val chain = Words("a", "b", "c").findChain(from = "a", to = "x")

        assertThat(chain).isEmpty()
    }

    @Test
    fun givenVocabularyWithDifferentSizeWords_shouldReturnChain() {
        val chain = Words("a", "aa", "aaa", "aba", "ba", "ccc", "cc", "ac").findChain("aa", "cc")

        assertThat(chain).containsExactly("aa", "ac", "cc")
    }

    @Test
    fun givenMultiplePossibleChains_shouldReturnShortestRoute() {
        val chain = Words("aa", "ab", "ac", "bb", "bc", "cc").findChain("aa", "bb")

        assertThat(chain).containsExactly("aa", "ab", "bb")
    }

}

