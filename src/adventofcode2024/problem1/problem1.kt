package adventofcode2024.problem1

import kotlin.math.abs

fun main() {
    solveA()
    solveB()
}

fun solveA() {
    val first = mutableListOf<Int>()
    val second = mutableListOf<Int>()

    input1.split("\n").forEach {
        val rowSplit = it.split("   ")
        first.add(rowSplit[0].toInt())
        second.add(rowSplit[1].toInt())
    }
    first.sort()
    second.sort()
    var totalDistance = 0
    first.forEachIndexed { index, _ ->
        totalDistance += abs(first[index] - second[index])
    }
    println(totalDistance)

}

fun solveB() {
    val first = mutableListOf<Int>()
    val second = mutableMapOf<Int, Int>()

    input1.split("\n").forEach {
        val rowSplit = it.split("   ")
        first.add(rowSplit[0].toInt())
        val sec = rowSplit[1].toInt()
        second[rowSplit[1].toInt()] = (second.get(sec) ?: 0) + sec
    }
    var totalDistance = 0
    first.forEachIndexed { index, i ->
        totalDistance += second[i] ?: 0
    }
    println(totalDistance)
}
