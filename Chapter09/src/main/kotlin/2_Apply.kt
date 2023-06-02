fun main() {
    val `007` = JamesBond().apply {
        name = "Sean Connery"
        movie = "Dr. No"
    }

    println(`007`.name)
    println(`007`.movie)
}

class JamesBond {
    lateinit var name: String
    lateinit var movie: String
    lateinit var alsoStarring: String
}