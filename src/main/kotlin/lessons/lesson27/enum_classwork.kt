package ru.kotlin.lessons.lesson27

import ru.kotlin.lessons.lesson27.Seasons.*

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

    fun f() {}
}

fun main() {
    NumsObject.ONE
    Nums.ONE

    DayOfWeek.SATURDAY.isWeekend
    DayOfWeek.SATURDAY.dayNumber
    DayOfWeek.SATURDAY.printDayType()
    println(DayOfWeek.entries)
    //DayOfWeek.entries.forEach // filter

    println(DayOfWeek.getDay(4))

    WINTER.seasonInfo()
    HomeTech.WASHING_MACHINE.action()
    HomeTech.KETTLE.action()
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

    companion object {
        fun getDay(dayNumber: Int): DayOfWeek {
            return entries.firstOrNull { it.dayNumber == dayNumber }
                ?: throw IllegalArgumentException("Нет дня недели с номером $dayNumber")
        }
    }


    fun printDayType() {
        if (isWeekend) println("$name is a weekend")
        else println("$name is a weekday")
    }
}

enum class CoffeeType(
    val cost: Double,
    val coffeeBase: String,
    val recommendedSugar: Int,
    val hasMilk: Boolean = false
) {
    ESPRESSO(2.50, "Espresso", 0),
    LATTE(3.00, "Latte", 2, true),
    CAPPUCCINO(2.75, "Cappuccino", 1, true),
    AMERICANO(2.25, "Americano", 0);

    fun description() =
        "The $coffeeBase ${if (hasMilk) "with" else "without"} milk costs \$$cost and is best with $recommendedSugar spoons of sugar."
}

enum class Seasons(val firstMonthNumber: Int, val isVariableDuration: Boolean) {
    WINTER(12, true),
    SPRING(3, false),
    SUMMER(6, false),
    AUTUMN(9, false),
    ;

    companion object {
        fun getSeason(firstmonth: Int): Seasons {
            return entries.firstOrNull { it.firstMonthNumber == firstmonth } ?: throw IllegalArgumentException(
                "Wrong arg: $firstmonth"
            )
        }
    }

    fun seasonInfo() {
        println(firstMonthNumber)
        println(isVariableDuration)
        println(name)
    }

}

fun temperature(season: Seasons) {
    when (season) {
        WINTER -> "холодно"
        SPRING -> "теплеет"
        SUMMER -> "тепло"
        AUTUMN -> "холодает"
    }.also { println(it) }
}

interface HasValue {
    val value: String
}

interface HasAction {
    fun action()
}

enum class HomeTech(override val value: String) : HasValue, HasAction {
    VACUUM("пылесос") {
        override fun action() {
            println("Make noise")
        }
    },
    WASHING_MACHINE("стиральная машина") {
        override fun action() {
            println("Make spin")
        }
    },
    FRIDGE("холодильник") {
        override fun action() {
            println("Make cold")
        }
    },
    KETTLE("чайник"),
    ;

    override fun action() {
        println("Is Working")
    }
}

class Tech(override val value: String) : HasValue {}