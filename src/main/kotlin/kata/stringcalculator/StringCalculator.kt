package kata.stringcalculator

import kata.check

fun String?.sum() = sumOf(this)

fun sumOf(input: String?): Int =
        when {
            input == null -> -1
            input.isBlank() -> 0
            else -> StringCalculator(input).sum()
        }

class StringCalculator(private val input: String,
                       private val delimiters: CharArray = charArrayOf(',', '\n')) {

    fun sum(): Int =
            if (hasCustomDelimiters())
                StringCalculator(inputWithoutCustomDelimiter,
                                 customDelimiters).sum()
            else
                input.split(*delimiters)
                        .map { it.toInt() }
                        .check { it >= 0 }
                        .filter { it <= 1000 }
                        .sum()

    private fun hasCustomDelimiters() = input.startsWith("//")

    private val inputWithoutCustomDelimiter = input.substringAfter('\n')

    private val customDelimiters: CharArray
        get() = charArrayOf(input.elementAt(2), '\n')

}