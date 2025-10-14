package ru.kotlin.lessons.lesson12

fun main() {

    val numbers = listOf(-1, 2, -3, 4, -5, 8, 264) // .forEach { } и можно выполняемый код

    val positive = mutableListOf<Int>()

    for (i in numbers) {
        val isPositive = i > 0
        if (isPositive) {
            positive.add(i)
        }
    }

    numbers.forEach {
        // it - спец переменная в котлин для хранения значения коллекции из текущей итерации
        val isPositive = it > 0
        if (isPositive) {
            positive.add(it)
        }
    }

    val list = listOf(8, 56, 23, 87, 12, 18, 11)
    val filtered1 = filter(list)
    println(filtered1)

    val filtered2 = list.filter {
        it in 7..17
    }
    println(filtered2)

    val positivesFiltered = numbers.filter {  it > 0  }

    val notPositivesNumbers = numbers.filterNot { it < 0  }
    println(notPositivesNumbers) // вывод -1 -3 -5

    val nullableList = listOf(1, null, 2, null, 3)
    val nonNullList = nullableList.filterNotNull()
    println(nonNullList) // вывод 1 2 3

    list[list.lastIndex]

    list.first { it > 0 } // элемент по индексу 0
    list.last { it > 0 }

    val setOfNumbers = setOf(3, 4, 5, -5, 14)
    val firstElement = setOfNumbers.first()
    val lastElement = setOfNumbers.last()
    var t = 3 // альтернативный способ получить 1 элемент, но слишком много кода
    for (i in setOfNumbers) {
        t = i
        break
    }

    val firstPositive = numbers.firstOrNull { it > 0 }
    println(firstPositive) // вывод 2
    val nullable = numbers.firstOrNull { it > 1000}
    println(nullable) // вывод null
    val elementOfElse = numbers.getOrElse(10) { -1 }
    println(elementOfElse) // вывод -1

 }

fun filter(collection1: List<Int>): List<Int> {
    val result1 = mutableListOf<Int>()
    for (i in collection1) {
        if (i in 7..17) result1.add(i)
    }
    return result1
}