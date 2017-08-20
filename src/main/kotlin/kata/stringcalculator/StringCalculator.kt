package kata.stringcalculator

fun String.sum(): Int = if (isEmpty()) 0 else StringCalculator(this).sum()

class StringCalculator(private val input: String, private val delimiters: CharArray = charArrayOf(',', '\n')) {

    fun sum(): Int =
            if (hasCustomDelimiter())
                StringCalculator(remainingInput(), charArrayOf(customDelimiter(), *delimiters)).sum()
            else
                input.split(*delimiters)
                        .map { it.toInt() }
                        .filter { it <= 1000 }
                        .check { it >= 0 }
                        .sum()

    private fun hasCustomDelimiter() = input.startsWith("//")

    private fun customDelimiter() = input[2]

    private fun remainingInput() = input.substring(4)

}

fun <T> Iterable<T>.check(forException: () -> Exception = ::IllegalArgumentException, check: (T) -> Boolean): Iterable<T> {
    for (element in iterator()) if (!check(element)) throw forException.invoke()
    return this
}