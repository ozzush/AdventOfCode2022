fun main() {
    fun solve(input: String) = readInput(input).fold(0) { acc, elm ->
        val pairs = elm.split(",", "-").map { it.toInt() }
        if (pairs[1] >= pairs[2] && pairs[0] <= pairs[3] ||
            pairs[2] >= pairs[1] && pairs[3] <= pairs[0]) acc + 1
        else acc
    }

    check(solve("day04_test") == 4)
    solve("day04").println()
}
