fun main() {
    readInput("day01")
        .fold(mutableListOf(0)) { acc, elm -> acc.apply { if (elm.isEmpty())  add(0) else this[lastIndex] += elm.toInt() }}
        .sortedDescending()
        .take(3)
        .sum()
        .println()
}
