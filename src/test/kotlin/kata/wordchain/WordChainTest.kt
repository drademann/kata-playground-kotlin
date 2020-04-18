package kata.wordchain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.be
import io.kotest.matchers.collections.beEmpty
import io.kotest.matchers.should

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
class WordChainTest : StringSpec() {
    init {
        "given empty strings should result in empty chain" {
            chain(Words("a", "b", "c"), from = "", to = "") should beEmpty()
        }
        "given from and to words with different length should result in empty chain" {
            chain(Words("a", "b", "c"), from = "a", to = "bb") should beEmpty()
        }
        "given simple connection should result in array with from/to" {
            chain(Words("a", "b", "c"), from = "a", to = "c") should be(listOf("a", "c"))
        }
        "given no connection exists should result in empty chain" {
            chain(Words("a", "b", "c"), from = "a", to = "x") should beEmpty()
        }
        "given vocabulary with different sized words should result in valid chain" {
            chain(
                Words("a", "aa", "aaa", "aba", "ba", "ccc", "cc", "ac"),
                from = "aa",
                to = "cc"
            ) should be(listOf("aa", "ac", "cc"))
        }
        "given multiple possible chains should result in shortest one" {
            chain(Words("aa", "ab", "ac", "bb", "bc", "cc"), from = "aa", to = "bb") should be(listOf("aa", "ab", "bb"))
        }
    }

    private fun chain(vocabulary: Words, from: String, to: String): List<String> =
        vocabulary.findChain(from, to).asList()
}