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
                        .map { if (it < 0) throw IllegalArgumentException() else it }
                        .sum()

    private fun hasCustomDelimiter() = input.startsWith("//")

    private fun customDelimiter() = input[2]

    private fun remainingInput() = input.substring(4)

}
