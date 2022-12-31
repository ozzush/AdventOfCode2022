val priorities = alphabet.mapIndexed { i, letter -> letter to i + 1}.associate { it }

fun main() {
    fun solve(input: String) = readInput(input).fold(0) { acc, elm ->
        check(elm.length % 2 == 0)
        val f = elm.take(elm.length / 2).toSet()
        val l = elm.takeLast(elm.length / 2).toSet()
        val common = f.intersect(l).toList()
        check(common.size == 1)
        acc + priorities[common[0]]!!
    }

    check(solve("day03_test") == 157)
    solve("day03").println()
}
