fun main() {
    val lowerCase = with(JamesBond()) {
        name = "Pierce Brosnan"

        println(this.name)
        name.lowercase()
    }
    println(lowerCase)
}