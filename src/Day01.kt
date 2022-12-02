import java.lang.System.lineSeparator

fun main() {
    fun part1(input: List<String>) = calorieCounting(input)

    fun part2(input: List<String>) = calorieCounting(input, 3)

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}

fun calorieCounting(input: List<String>, top: Int = 1): Int {

    val data = input
        .joinToString(lineSeparator())
        .split(lineSeparator() + lineSeparator())
        .map { values -> values
            .lines()
            .sumOf { it.toInt() }
        }

    return data
        .sortedDescending()
        .take(top)
        .sum()
}
