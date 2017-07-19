package kata.stringcalculator

fun sumOf(string: String): Int {
    if (string.isEmpty()) return 0
    return StringCalculator(Regex("[,\n]")).sumOf(string)
}

class StringCalculator(val delimiters: Regex) {

    fun sumOf(string: String): Int {
        if (string.startsWith("//")) {
            return customSplitted(string[2], string.substring(4))
        }
        return splitted(string)
    }

    private fun customSplitted(additionalDelimiter: Char, tail: String): Int {
        return StringCalculator(Regex("[,\n%s]".format(additionalDelimiter))).sumOf(tail)
    }

    private fun splitted(string: String): Int {
        val integers = string.split(delimiters).map { it.toInt() }.filter { it <= 1000 }
        if (integers.any { it < 0 }) throw IllegalArgumentException("numbers must be positive")
        return integers.sum()
    }

}
