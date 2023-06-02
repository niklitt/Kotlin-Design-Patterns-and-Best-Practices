fun main() {
    doCoolStuff(Batman())
    doCoolStuff(Superman())
    doCoolStuff(Nate())
}

fun doCoolStuff(s: Superhero) {
    when (s) {
        is Superman -> s.fly()
        is Batman -> s.callRobin()
        else -> println("Unknown superhero")
    }
}

interface Superhero
class Batman : Superhero {
    fun callRobin() {
        println("To the Bat-pole, Robin!")
    }
}

class Superman : Superhero {
    fun fly() {
        println("Up, up and away!")
    }
}

class Nate : Superhero {
    fun spitFacts() {
        println("I'm a dummy")
    }
}