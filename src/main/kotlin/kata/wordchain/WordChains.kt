package kata.wordchain

class Words(private vararg val vocabulary: String) {

    fun findChain(from: String, to: String) = find(from, to).asArray()

    private fun find(from: String, to: String) =
            if (unableToChain(from, to))
                NoChain
            else
                search(Chain(from), to)

    private fun unableToChain(from: String, to: String) =
            from.isEmpty() || to.isEmpty()
                    || differentLength(from, to)
                    || unknown(from) || unknown(to)

    private fun differentLength(from: String, to: String) = from.length != to.length
    private fun unknown(word: String) = !vocabulary.contains(word)

    private fun search(chain: Chain, to: String): Chain {
        val candidates = vocabulary
                .filter { it.length == to.length }
                .filter { differentCharsIn(it, chain.last) == 1 }
                .filterNot { chain.contains(it) }
        val chains = mutableListOf<Chain>()
        for (candidate in candidates) {
            if (candidate == to) {
                val possibleChain = chain.plus(candidate)
                if (possibleChain.isNotEmpty())
                    chains.add(possibleChain)
            }
            chains.add(search(chain.plus(candidate), to))
        }
        return chains
                .filter { it.isNotEmpty() }
                .minBy { it.length }
                ?: NoChain
    }

    private fun differentCharsIn(s1: String, s2: String) = s1.mapIndexed { index, c -> if (c == s2[index]) 0 else 1 }.sum()

}

private class Chain(private val elements: List<String>) {

    constructor(startElement: String) : this(listOf(startElement))
    constructor() : this(emptyList())

    fun asArray(): Array<String> = elements.toTypedArray()

    fun contains(element: String) = elements.contains(element)

    fun isNotEmpty() = elements.isNotEmpty()

    fun plus(element: String): Chain = Chain(elements.plus(element))

    val length: Int
        get() = elements.size

    val last: String
        get() = elements.last()

}

private val NoChain = Chain()