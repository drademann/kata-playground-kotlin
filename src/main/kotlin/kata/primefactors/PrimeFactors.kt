package kata.primefactors

fun primeFactorsOf(n: Int): List<Int> {
    var r = n
    var factors = emptyList<Int>()
    var c = 2
    while (r > 1) {
        while (r % c == 0) {
            factors += c
            r /= c
        }
        c++
    }
    return factors
}
