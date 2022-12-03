fun main() {
    fun part1(input: List<String>): Int {

        //first solution:
//        val items = mutableListOf<Int>()
//        input.forEach {
//            val rucksack = it.chunked(it.length / 2)
//            items.add(rucksack.equalChar())
//        }

        //fix
        return input
            .map { it.chunked(it.length / 2) }
            .flatMap { (first, second) -> first.toSet() intersect second.toSet() }
            .sumOf { it.priority }
    }

    fun part2(input: List<String>): Int {
        //first solution
//        val items = mutableListOf<Int>()
//        for (i in input.indices step 3) {
//            items.add(input.badge(i))
//        }
//        return items.sum()

        //fix
        return input.chunked(3) {
            val (first, second, third) = it
            val keyCard = first.toSet() intersect second.toSet() intersect third.toSet()
            keyCard.single().priority
        }.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}

//fix
val Char.priority
    get(): Int {
    return if (this.isUpperCase()) {
        this - 'A' + 27
    } else {
        this - 'a' + 1
    }
}
//first solution
//private fun Char.toPro(): Int {
//    return if (this.code <= 90) {
//        this.code - 38
//    } else {
//        this.code - 96
//    }
//}
//
//private fun List<String>.equalChar() : Int {
//    val leftChar = this[0].toCharArray()
//    leftChar.forEach {
//        if (this[1].contains(it)) return it.toPro()
//    }
//    return 0
//}
//
//private fun List<String>.badge(pos: Int) : Int {
//    this[pos].toCharArray().forEach {
//        if(this[pos+1].contains(it) && this[pos+2].contains(it)) {
//            return it.toPro()
//        }
//    }
//    return 0
//}
