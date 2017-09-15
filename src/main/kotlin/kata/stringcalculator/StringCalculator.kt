package kata.stringcalculator

import kata.check

fun String?.sum(): Int = sumOf(this)

fun sumOf(input: String?) = when {
    input == null -> -1
    input.isEmpty() -> 0
    else -> StringCalculator(input).sum()
}

private class StringCalculator(private val input: String,
                               private val delimiters: CharArray = charArrayOf(',', '\n')) {

    fun sum(): Int =
            if (hasCustomDelimiter())
                StringCalculator(inputWithoutCustomDelimiter, delimiters + customDelimiter).sum()
            else
                input.split(*delimiters).asSequence()
                        .map { it.toInt() }
                        .check { it >= 0 }
                        .filter { it <= 1000 }
                        .sum()

    private fun hasCustomDelimiter() = input.startsWith("//")

    private val inputWithoutCustomDelimiter get() = input.substringAfter('\n')
    private val customDelimiter get() = input[2]

}
