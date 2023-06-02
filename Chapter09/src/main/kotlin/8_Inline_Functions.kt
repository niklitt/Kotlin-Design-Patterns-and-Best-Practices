fun main() {
    logBeforeAfter {
        "Inlining"
    }
}

/**
 * Is this ever actually used in prod code??
 */
inline fun logBeforeAfter(block: () -> String) {
    println("Before")
    println(block())
    println("After")
}