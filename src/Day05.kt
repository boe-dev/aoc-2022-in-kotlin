
fun main() {
    fun part1(input: List<String>): String {
        val matrix = input.filter { !it.contains("move") && it.isNotEmpty() }.toMutableList()
        val stacks = matrix[matrix.lastIndex].substring(matrix[matrix.lastIndex].lastIndex).toInt()
        matrix.removeLast()

        val test = Array(stacks) { mutableListOf<String>() }
        matrix.forEach {element ->
            test.forEachIndexed { index, _ ->
                val startIndex = index * 4
                val endIndex = startIndex + 3
                if (endIndex <= element.length) {
                    val addString = element
                        .subSequence(startIndex, endIndex)
                        .trim()
                        .removePrefix("[")
                        .removeSuffix("]")
                    if (addString.isNotBlank()) {
                        test[index].add(addString.toString())
                    }
                }
            }
        }

        test.forEach {
            println(it)
        }

        val moving = input.filter { it.contains("move") }
        moving.forEach {
            val fromBegin = it.indexOf("from")
            val move = it.substring(4, fromBegin).trim().toInt()
            val toBegin = it.indexOf("to")
            val from = it.substring(fromBegin + 4, toBegin).trim().toInt()
            val to = it.substring(toBegin + 2, it.length).trim().toInt()

//            for (i in 1..move) {
//                val item = test[from-1].removeAt(0)
//                test[to-1].add(0, item)
//            }

            println("move $move")
            for (i in (move -1)downTo 0) {
                println(i)
                val item = test[from-1].removeAt(i)
                test[to-1].add(0, item)
            }
        }

        var result = ""
        test.map { it[0] }.forEach {
            result += it
        }

        return result
    }


    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    println(part1(testInput))
    check(part1(testInput) == "MCD")

    val input = readInput("Day05")
    println(part1(input))
//    println(part2(input))
}
