
//     [P]                 [Q]     [T]
// [F] [N]             [P] [L]     [M]
// [H] [T] [H]         [M] [H]     [Z]
// [M] [C] [P]     [Q] [R] [C]     [J]
// [T] [J] [M] [F] [L] [G] [R]     [Q]
// [V] [G] [D] [V] [G] [D] [N] [W] [L]
// [L] [Q] [S] [B] [H] [B] [M] [L] [D]
// [D] [H] [R] [L] [N] [W] [G] [C] [R]
//  1   2   3   4   5   6   7   8   9

val state = listOf("FHMTVLD", "PNTCJGQH", "HPMDSR", "FVBL", "QLGHN", "PMRGDBW", "QLHCRNMG", "WLC", "TMZJQLDR")
    .map { it.toList() }.toMutableList()

val testState = listOf("NZ", "DCM", "P")
    .map { it.toList() }.toMutableList()

fun main() {
    fun solve(input: String, init: MutableList<List<Char>>) = readInput(input).fold(init) { acc, elm ->
        val numbers = Regex("[0-9]+").findAll(elm)
            .map(MatchResult::value)
            .toList()
            .map { it.toInt() }
        acc[numbers[2] - 1] = (acc[numbers[1] - 1].take(numbers[0]) + acc[numbers[2] - 1])
        acc[numbers[1] - 1] = acc[numbers[1] - 1].takeLast(acc[numbers[1] - 1].size - numbers[0])
//        println(acc)
        acc
    }.map { it[0] }.joinToString("")

    val test = solve("day05_test", testState)
    check(test == "MCD")
    solve("day05", state).println()
}
