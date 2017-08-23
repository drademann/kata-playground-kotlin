package kata.stringcalculator

import kata.check

fun String.sum() = sumOf(this)

fun sumOf(input: String?) = when {
    input == null -> -1
    input.isEmpty() -> 0
    else -> StringCalculator(input).sum()
}

private class StringCalculator(
        val input: String,
        val delimiters: CharArray = charArrayOf(',', '\n')) {

    fun sum(): Int =
            if (hasCustomDelimiter())
                StringCalculator(inputWithoutCustomDelimiter, delimiters.plus(customDelimiter)).sum()
            else
                input.split(*delimiters)
                        .map { it.toInt() }
                        .filter { it <= 1000 }
                        .check { it >= 0 }
                        .sum()

    private fun hasCustomDelimiter() = input.startsWith("//")

    private val inputWithoutCustomDelimiter: String
        get() = input.substringAfter("\n")

    private val customDelimiter: Char
        get() = input[2]

}