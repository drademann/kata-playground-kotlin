package kata.stringcalculator

import kata.check

fun String.sum(): Int =
        if (isEmpty())
            0
        else
            StringCalculator(this).sum()

private class StringCalculator(val input: String, val delimiters: CharArray = charArrayOf(',', '\n')) {

    fun sum(): Int =
            if (hasCustomDelimiter)
                StringCalculator(inputWithoutCustomDelimiter, delimiters.plus(customDelimiter)).sum()
            else
                input.split(*delimiters)
                        .map { it.trim().toInt() }
                        .check { it >= 0 }
                        .filter { it <= 1000 }
                        .sum()

    private val hasCustomDelimiter: Boolean
        get() = input.startsWith("//")

    private val customDelimiter: Char
        get() = input[2]

    private val inputWithoutCustomDelimiter: String
        get() = input.substringAfter("\n")

}

