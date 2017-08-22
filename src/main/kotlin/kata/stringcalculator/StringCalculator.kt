package kata.stringcalculator

fun String.sum(): Int =
        if (isEmpty())
            0
        else
            StringCalculator(this).sum()

private class StringCalculator(val input: String, val delimiters: CharArray = charArrayOf(',', '\n')) {

    fun sum(): Int =
            if (input.startsWith("//"))
                StringCalculator(inputWithoutCustomDelimiter, delimiters.plus(customDelimiter)).sum()
            else
                input.split(*delimiters)
                        .map { it.toInt() }
                        .check { it >= 0 }
                        .filter { it <= 1000 }
                        .sum()

    private val customDelimiter: Char
        get() = input[2]

    private val inputWithoutCustomDelimiter: String
        get() = input.substringAfter("\n")

}

fun <T> Iterable<T>.check(forException: () -> Exception = ::IllegalArgumentException, check: (T) -> Boolean): Iterable<T> {
    this.filterNot { check.invoke(it) }
            .forEach { throw forException.invoke() }
    return this
}