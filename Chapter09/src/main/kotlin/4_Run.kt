import java.util.*

/**
 * Can't see this being used very often
 */
fun main() {
    val lowerCaseName = JamesBond().run {
        name = "ROGER MOORE"
        movie = "THE MAN WITH THE GOLDEN GUN"
        name.lowercase() // <= Not JamesBond type
    }

    println(lowerCaseName)
}