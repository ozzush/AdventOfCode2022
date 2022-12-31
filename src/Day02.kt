fun main() {
    fun winPoints(elf: Char, you: Char): Int {
        val outcomePoints = mapOf('X' to 0, 'Y' to 3, 'Z' to 6)[you]!!
        val win = mapOf('A' to 'B', 'B' to 'C', 'C' to 'A')
        val lose = mapOf('A' to 'C', 'B' to 'A', 'C' to 'B')
        val points = mapOf('A' to 1, 'B' to 2, 'C' to 3)
        return outcomePoints + when (you) {
            'X' -> points[lose[elf]]
            'Y' -> points[elf]
            'Z' -> points[win[elf]]
            else -> null
        }!!
    }

    check(readInput("day02_test").fold(0) { acc, elm -> acc + winPoints(elm[0], elm[2]) } == 12)
    readInput("day02").fold(0) { acc, elm -> acc + winPoints(elm[0], elm[2]) }.println()
}
