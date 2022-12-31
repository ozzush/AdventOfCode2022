fun main() {
    fun solve(input: String): Int? {
        val map = mutableMapOf<Char, Int>()
        input.forEachIndexed { i, char ->
            map.putIfAbsent(char, 0)
            map[char] = map[char]!! + 1
            if (i >= 14) {
                map[input[i - 14]] = map[input[i - 14]]!! - 1
                map.remove(input[i - 14], 0)
            }
            if (map.size == 14) return i + 1
        }
        return null
    }

    val test = solve("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")
    check(test == 26)
    val inp = readInput("day06")[0]
    solve(inp).println()
}
