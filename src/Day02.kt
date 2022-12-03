fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf { gameLogic(it) }
    }

    fun part2(input: List<String>): Int {
        return input.sumOf { realGame(it) }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}

fun gameLogic(round: String) : Int {
    // A for Rock, B for Paper, and C for Scissors
    // X for Rock, Y for Paper, and Z for Scissors
    // 1 2 3
    // 0 if you lost, 3 if the round was a draw, and 6 if you won
    return when(round) {
        "A X" -> 1 + 3
        "A Y" -> 2 + 6
        "A Z" -> 3 + 0

        "B X" -> 1 + 0
        "B Y" -> 2 + 3
        "B Z" -> 3 + 6

        "C X" -> 1 + 6
        "C Y" -> 2 + 0
        "C Z" -> 3 + 3

        else -> 0
    }
}

fun realGame(round: String) : Int {

    // A for Rock, B for Paper, and C for Scissors
    // X for Rock, Y for Paper, and Z for Scissors
    // 1 2 3
    // X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win.
    return when(round) {
        "A X" -> 3 + 0
        "A Y" -> 1 + 3
        "A Z" -> 2 + 6

        "B X" -> 1 + 0
        "B Y" -> 2 + 3
        "B Z" -> 3 + 6

        "C X" -> 2 + 0
        "C Y" -> 3 + 3
        "C Z" -> 1 + 6

        else -> 0
    }
}
