fun main() {
    fun solve(input: String) = readInput(input).chunked(3).fold(0) { acc, elm ->
        val common = elm[0].toSet().intersect(elm[1].toSet()).intersect(elm[2].toSet()).toList()
        check(common.size == 1)
        acc + priorities[common[0]]!!
    }

    check(solve("day03_test") == 70)
    solve("day03").println()
}
