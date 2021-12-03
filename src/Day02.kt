fun main() {
    fun part1(input: List<SubmarineCommand>): Int {
        val (horizontal, vertical) = input.partition { it.direction == Direction.FORWARD }

        return horizontal.fold(0) { acc, x -> acc.plus(x.units) } *
                vertical.fold(0) { acc, y -> if (y.direction == Direction.UP) acc.minus(y.units) else acc.plus(y.units) }
    }

    fun part2(input: List<SubmarineCommand>): Int {
        return input.fold(AimResult()) { acc, x ->
            when (x.direction) {
                Direction.DOWN -> { acc.apply { aim += x.units } }
                Direction.UP -> { acc.apply { aim -= x.units } }
                Direction.FORWARD -> {
                    acc.apply {
                        horizontal += x.units
                        vertical += (aim * x.units)
                    }
                }
            }
        }.let { it.horizontal * it.vertical }
    }

    val input = readInput("Day02").mapToSubmarineCommands()

    println(part1(input))
    println(part2(input))
}

fun List<String>.mapToSubmarineCommands() = this.map { line ->
    line.split(" ").let {
        SubmarineCommand(Direction.valueOf(it[0].uppercase()), it[1].toInt())
    }
}

data class SubmarineCommand(
    val direction: Direction,
    val units: Int,
)

data class AimResult(
    var aim: Int = 0,
    var horizontal: Int = 0,
    var vertical: Int = 0,
)

enum class Direction {
    FORWARD,
    DOWN,
    UP
}
