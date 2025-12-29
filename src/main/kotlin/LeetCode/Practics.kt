package ru.kotlin.LeetCode

import kotlin.math.absoluteValue

class Solution {
    fun countDigits(num: Int): Int {
        val digits = num.absoluteValue.toString().map { it.digitToInt() }
        var result: Int = 0
        for (i in digits.indices) {
            if (num % digits[i] == 0) {
                result += 1
            }
        }
        return result
    }
}

class Solution1 {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()


        val keypad = mapOf(
            '2' to "abc",
            '3' to "def",
            '4' to "ghi",
            '5' to "jkl",
            '6' to "mno",
            '7' to "pqrs",
            '8' to "tuv",
            '9' to "wxyz"
        )
        val result = mutableListOf<String>()

        fun backtrack(index: Int, current: StringBuilder) {
            if (index == digits.length) {
                result.add(current.toString())
                return
            }

            val letters = keypad[digits[index]] ?: return

            for (letter in letters) {
                current.append(letter)
                backtrack(index + 1, current)
                current.deleteCharAt(current.lastIndex)
            }
        }
        backtrack(0, StringBuilder())
        return result
    }
}

fun main() {
    val solution = Solution().countDigits(1248)
    println(solution)

    val solution1 = Solution1().letterCombinations("29")
    println(solution1)

}