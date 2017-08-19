package kata.stringcalculator

fun String.sum(): Int = if (isEmpty()) 0 else StringCalculator(this).sum()

class StringCalculator(private val input: String, private val delimiters: String = ",\n") {

    fun sum(): Int =
            if (hasCustomDelimiter())
                StringCalculator(remainingInput(), delimitersAppendedWith(customDelimiter())).sum()
            else
                input.split(delimitersRegex())
                        .map { it.toInt() }
                        .filter { it <= 1000 }
                        .map { if (it < 0) throw IllegalArgumentException() else it }
                        .sum()

    private fun hasCustomDelimiter() = input.startsWith("//")

    private fun delimitersAppendedWith(customDelimiter: Char): String {
        return ",\n$customDelimiter"
    }

    private fun remainingInput() = input.substring(4)

    private fun customDelimiter() = input[2]

    private fun delimitersRegex() = Regex("[$delimiters]")

}
