fun main() {
    fun part1(input: List<Int>): Int {
        return input.windowed(2).count { (x, y) -> x < y }
    }

    fun part2(input: List<Int>): Int {
        return input.windowed(3).windowed(2).count { (x, y) -> x.sum() < y.sum() }
    }

    val input = readInputAsInts("Day01")
    println(part1(input))
    println(part2(input))
}
