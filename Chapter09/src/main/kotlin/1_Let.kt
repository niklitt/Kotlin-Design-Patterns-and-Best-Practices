fun main() {
    val clintEastwoodQuotes = mapOf(
        "The Good, The Bad, The Ugly" to "Every gun makes its own tune.",
        "A Fistful Of Dollars" to "My mistake: four coffins."
    )
    val quote = clintEastwoodQuotes["The Good, The Bad, The Ugly"]

    if (quote != null) {
        println("1: $quote")
    }

    // There is a movie with that name, so let will execute the block
    clintEastwoodQuotes["A Fistful Of Dollars"]?.let {
        println("2: $it")
    }

    // Nothing will be printed, since there's no such movie
    clintEastwoodQuotes["Unforgiven"]?.let {
        println("3: $it")
    }

    // Nothing will be printed, since there's no such movie
    clintEastwoodQuotes["Unforgiven"].let {
        println("4: $it")
    }
}