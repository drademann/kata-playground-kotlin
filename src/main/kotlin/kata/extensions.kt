package kata

fun <T> Iterable<T>.check(forException: () -> Exception = ::IllegalArgumentException, check: (T) -> Boolean): Iterable<T> {
    if (!all(check)) throw forException.invoke()
    return this
}

fun <T> Sequence<T>.check(forException: () -> Exception = ::IllegalArgumentException, check: (T) -> Boolean): Sequence<T> {
    return object : Sequence<T> {
        override fun iterator(): Iterator<T> = object : Iterator<T> {
            val iterator = this@check.iterator()

            override fun next(): T =
                    iterator.next().apply {
                        if (!check(this)) throw forException.invoke()
                    }

            override fun hasNext(): Boolean = iterator.hasNext()

        }
    }
}