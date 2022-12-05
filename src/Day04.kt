fun main() {
    fun part1(input: List<String>): Int {
        var couter = 0
        val list = mutableListOf<List<String>>()
        input.forEach {
            val test = it.split(",").map { it.split("-") }.flatten()
            list.add(test)
        }
        list.forEach{
            // [11, 67, 6, 10]
            if ((it[0].toInt() <= it[2].toInt() && it[1].toInt() >= it[3].toInt()) ||
                (it[2].toInt() <= it[0].toInt() && it[3].toInt() >= it[1].toInt())) {
                couter++
            }
        }
        return couter
    }

    fun part2(input: List<String>): Int {
        var couter = 0
        val list = mutableListOf<List<String>>()
        input.forEach {
            val test = it.split(",").map { it.split("-") }.flatten()
            list.add(test)
        }
        list.forEach{
            if ((it[0].toInt() <= it[2].toInt() && it[1].toInt() >= it[3].toInt()) ||
                (it[2].toInt() <= it[0].toInt() && it[3].toInt() >= it[1].toInt()) ||
                (it[0].toInt() >= it[2].toInt() && it[0].toInt() <= it[3].toInt()) ||
                (it[2].toInt() >= it[0].toInt() && it[2].toInt() <= it[1].toInt())
                ) {
                println(it)
                couter++
            }
        }
        return couter
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
