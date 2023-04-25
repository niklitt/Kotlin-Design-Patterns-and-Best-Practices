data class User(val username: String, private val password: String) {
    fun hidePassword() = "*".repeat(password.length)
}

fun main() {
    val user = User("litt", "K0tl!n")
    println(user.username)
    println(user.hidePassword())
}