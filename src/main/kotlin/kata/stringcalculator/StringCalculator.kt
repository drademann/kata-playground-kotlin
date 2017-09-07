package kata.stringcalculator

import kata.check

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
