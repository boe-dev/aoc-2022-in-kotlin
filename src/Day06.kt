import java.io.File

fun main() {
    fun part1(input: String): Int {
        println(input)

        var lastDouble = 0
        val dataArray = input.toCharArray()
        dataArray.forEachIndexed { index, c ->
            if (index < (input.length -3)) {
                if (c == dataArray[index + 1] || c == dataArray[index + 2] || c == dataArray[index + 3]) {
                    if ((index + 1) - lastDouble > 4) {
                        return lastDouble + 4
                    } else {
                        lastDouble = index + 1
                    }
                }
            }
        }
        return lastDouble + 4
    }

    fun part2(input: String, pos: Int): Int {
        return input.windowed(pos).indexOfFirst { it.toSet().size == pos } + pos
    }

    // test if implementation meets criteria from the description, like:
    val testInput = File("src", "Day06_test.txt").readText()
    check(part1(testInput) == 7)
    check(part2(testInput, 14) == 19)

    val input = File("src", "Day06.txt").readText()
    println(part1(input))
    println(part2(input, 14))
}
