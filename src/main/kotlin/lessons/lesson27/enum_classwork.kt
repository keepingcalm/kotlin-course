package ru.kotlin.lessons.lesson27

object NumsObject {
    const val ONE = "ONE"
    const val TWO = "TWO"
    const val THREE = "THREE"
}

enum class Nums {
    ONE,
    TWO,
    THREE,
    FOUR,
    ;
    fun f(){}
}

fun main() {
    NumsObject.ONE
    Nums.ONE

    DayOfWeek.SATURDAY.isWeekend
}

fun printNum(num: Nums) {
    when (num) {
        Nums.ONE -> println(1)
        Nums.TWO -> TODO()
        Nums.THREE -> TODO()
        else -> println()
    }
}

enum class DayOfWeek(val dayNumber: Int, val isWeekend: Boolean) {
    MONDAY(1, false),
    TUESDAY(2, false),
    WEDNESDAY(3, false),
    THURSDAY(4, false),
    FRIDAY(5, false),
    SATURDAY(6, true),
    SUNDAY(7, true);

    fun printDayType() {
        if(isWeekend) println("$name is a weekend")
        else println("$name is a weekday")
    }
}