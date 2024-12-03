package adventofcode2024.problem3

import java.math.BigInteger

fun main() {
    solveA()
    solveB()
}

fun solveA() {
    var sum = BigInteger.ZERO
    val allMul = input3test.split("mul(")
    allMul.forEach {
        val split = it.split(",")
        try {
            val firstStr = split[0]
            if (firstStr.length in 1..3 && firstStr[0] != '0') {
                val first = firstStr.toLong()
                val secondStr = split[1].split(")")[0]
                if (secondStr.length in 1..3 && secondStr[0] != '0') {
                    val second = secondStr.toLong()
                    sum += (BigInteger.valueOf(first).multiply(BigInteger.valueOf(second)))
                }
            }
        } catch (e: Exception) {

        }
    }
    println(sum)
}

fun solveB() {
}
