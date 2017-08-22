package kata

fun <T> Iterable<T>.check(forException: () -> Exception = ::IllegalArgumentException, check: (T) -> Boolean): Iterable<T> {
    if (!all(check)) throw forException.invoke()
    return this
}