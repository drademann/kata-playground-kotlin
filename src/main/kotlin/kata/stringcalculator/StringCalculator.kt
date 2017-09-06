package kata.stringcalculator

fun String?.sum(): Int = if (this == null) -1 else sumOf(this)

fun sumOf(input: String?) = when {
    input == null -> -1
    input.isEmpty() -> 0
    else -> StringCalculator(input).sum()
}

private class StringCalculator(private val input: String,
                               private val delimiters: CharArray = charArrayOf(',', '\n')) {

    fun sum(): Int =
            if (hasCustomDelimiter())
                StringCalculator(inputWithoutCustomDelimiter, delimiters.plus(customDelimiter)).sum()
            else
                input.split(*delimiters).asSequence()
                        .map { it.toInt() }
                        .check { it >= 0 }
                        .filter { it <= 1000 }
                        .sum()

    private fun hasCustomDelimiter() = input.startsWith("//")

    private inline val inputWithoutCustomDelimiter
        get() = input.substringAfter('\n')

    private inline val customDelimiter
        get() = input[2]

}

fun <T> Iterable<T>.check(forException: () -> Exception = ::IllegalArgumentException, check: (T) -> Boolean): Iterable<T> {
    if (!all(check)) throw forException.invoke()
    return this
}

fun <T> Sequence<T>.check(forException: () -> Exception = ::IllegalArgumentException, check: (T) -> Boolean): Sequence<T> {
    return object : Sequence<T> {
        override fun iterator(): Iterator<T> = object : Iterator<T> {
            val iterator = this@check.iterator()

            override fun next(): T =
                    iterator.next().apply {
                        if (!check(this)) throw forException.invoke()
                    }

            override fun hasNext(): Boolean = iterator.hasNext()

        }
    }
}
