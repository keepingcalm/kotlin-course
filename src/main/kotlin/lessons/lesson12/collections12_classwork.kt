package ru.kotlin.lessons.lesson12

import ru.kotlin.lessons.lesson11.homeworks.processList

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

    val incrementNumbers = numbers.map { it + 1 }
    println(incrementNumbers) // вывод [0, 3, -2, 5, -4, 9, 265]

    val incrementNumbers1 = numbers.map { it.toString() + "test oooo"}
    println(incrementNumbers1) // выведет [-1test oooo, 2test oooo, -3test oooo, 4test oooo, -5test oooo, 8test oooo, 264test oooo]

    val incrementNumbers2 = numbers.map { it > 0 }
    println(incrementNumbers2) // Вывод [false, true, false, true, false, true, true]

    val numberSquareMap: Map<Int, Int> = numbers.associate { it to it * it }
    println(numberSquareMap) // вывод {-1=1, 2=4, -3=9, 4=16, -5=25, 8=64, 264=69696}

    val multipleList = listOf(
        listOf(1, 2, 3),
        listOf(4, 5, 6)
    )

    val flattenList = multipleList.flatten()
    println(flattenList) // склеивает 2 списка в списках в один общий

    val flattenListAfterMapping = multipleList.flatMap { list ->
        list.map { it * 2 }
    }
    println(flattenListAfterMapping)

    val joinToString = numbers.joinToString(separator = " : ") { "${it * 2}" }
    println(joinToString) // output -2 : 4 : -6 : 8 : -10 : 16 : 528

    val sortedNumbers = numbers.sorted()
    println(sortedNumbers) // output [-5, -3, -1, 2, 4, 8, 264]

    val sortedNumbers1 = numbers.sortedDescending()
    println(sortedNumbers1) // output [264, 8, 4, 2, -1, -3, -5]

    println(numbers.size)
    if (numbers.isNotEmpty()) {
        println("коллекция не пуста")
    } else {
        println("в коллекции ${numbers.size} значений")
    }

    val sumOfNumbers = numbers.sum()
    println(sumOfNumbers) // 269

    val averageofNumbers = numbers.average()
    println(averageofNumbers) // output 38.42857142857143

    val maxNumber = numbers.maxOrNull()
    println(maxNumber) // 264
    val minNumber = numbers.minOrNull()
    println(minNumber) // -5

    val groupedBySign: Map<String, List<Int>> = numbers.groupBy { if (it > 0) "Positive" else "Negative" }
    println(groupedBySign) // output {Negative=[-1, -3, -5], Positive=[2, 4, 8, 264]}

    val distinctNumbers = listOf(1, 3, 3, 4, 5, 6, 7, 8, 8).distinct()
    println(distinctNumbers) // output [1, 3, 4, 5, 6, 7, 8]

    println(numbers.take(4)) // вывод первых 4х значений [-1, 2, -3, 4]

    println(numbers.takeLast(3)) // вывод из 3х последних значений [-5, 8, 264]

    println(numbers.drop(3)) // отдаст все кроме первых трех элементов [4, -5, 8, 264]

    val ex = listOf(1, 2, 4, 5, -6)
    if (ex.size > 5) {
    }
    if (ex.isNotEmpty()) {
    }

    val ex1 = ex.getOrElse(88) {5} // взять элемент с индексом 88, а если его нет - взять элемент из 5 индекса
    println(ex1)

    val ex2 = ex.joinToString("& ")
    println(ex2)

    val sum = ex.sum()
    println(sum)

    val ex3 = ex.firstOrNull() { it < 0 }
    println(ex3)

    val ex4 = ex.contains(6)
    println(ex4)

    val ex5 = ex.filter { it in 18.. 30 }
    println(ex5)

    val ex6 = ex.filter { it != null } // OR val ex61 = ex.filterNotNull()
    println(ex6)

    val ex7: List<String> = listOf("sdsfdsf", "vcvcv", "syuyyu")


}


fun filter(collection1: List<Int>): List<Int> {
    val result1 = mutableListOf<Int>()
    for (i in collection1) {
        if (i in 7..17) result1.add(i)
    }
    return result1
}