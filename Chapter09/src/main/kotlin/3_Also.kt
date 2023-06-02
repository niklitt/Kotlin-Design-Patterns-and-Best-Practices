fun main() {
    val l = (1..100).toList()

    l.also { println(it) }
        .filter { it % 2 == 0 }
        // Prints, but doesn't mutate the collection
        .also { println(it) }
        .map { it * it }
        .also { println(it) }
}