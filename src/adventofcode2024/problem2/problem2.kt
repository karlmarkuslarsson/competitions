package adventofcode2024.problem2

import kotlin.math.abs

fun main() {
    solveA()
    solveB()
}

fun solveA() {
    var safe = 0
    input2.split("\n").forEach {

        if (checkCorrect(it.split(" ").map { it.toInt() })) {
            safe++
        }
    }
    println(safe)


}

fun solveB() {
    var safe = 0
    input2.split("\n").forEach {

        val reportNumbers = it.split(" ").map { it.toInt() }
        var isSafe = checkCorrect(reportNumbers)
        var index = 0
        if (isSafe) {
            safe++
        } else {
            while (index < reportNumbers.size) {
                isSafe =
                    checkCorrect(reportNumbers.filterIndexed { i, _ -> index != i })
                if (isSafe) {
                    break
                }
                index++
            }
            if(isSafe) {
                safe++
            }
        }
    }
    println(safe)
}

fun checkCorrect(report: List<Int>): Boolean {
    var isSafe = true
    var increasing = true
    var last = 0
    report.forEachIndexed { index, s ->
        if (index > 1) {
            if (increasing) {
                if (s - last > 3 || s - last <= 0) {
                    isSafe = false
                }
            } else {
                if (last - s > 3 || last - s <= 0) {
                    isSafe = false
                }
            }
        } else if (index == 1) {
            if (s - last == 0) {
                isSafe = false
            } else {
                increasing = s - last > 0

            }
            if (abs(last - s) > 3) {
                isSafe = false
            }
        }
        last = s
    }
    return isSafe
}
