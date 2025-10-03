package ru.kotlin.lessons.lesson09

fun main() {
    val numbers: Array<Int> = arrayOf(1, 2, 3, 4, 5)
    val doubles: DoubleArray = doubleArrayOf(1.1, 2.2, 3.3)
    val emptyArray = Array(5) { "" }
    val emptyNullableArray = arrayOfNulls<Int>(5)
    val readOnlyList: List<String> = listOf("a", "b", "c")
    val mutableList: MutableList<String> = mutableListOf("a", "b", "c")

    numbers[0] = 10  //присваивание значения индексу ячейки
    mutableList.add("d")
    mutableList.removeAt(0)
    mutableList.remove("c")
    mutableList.add(1, "c")
    mutableList[0] = "e"
    println(mutableList[2])

    val numbersSet: Set<Int> = setOf(1, 2, 3, 4, 5)
    val mutableNumbersSet: MutableSet<Int> = mutableSetOf(1, 2, 3, 4, 5)
    val emptySet: Set<Int> = emptySet()
    val emptyMutableSet: MutableSet<Int> = mutableSetOf()

    val set = setOf("K", "o", "t", "l", "i", "n")
    for (letter in set) {
        println("| $letter|")
    }

    val list = listOf(32, 44, 1, 55)
    for (index in list.indices) {
        if (index == list.lastIndex) {
            println(list[index] + list[0])
        } else {
            println(list[index] + list[index + 1])
        }
    }

    val a1: Array<Int> = Array(10) { 0 }

    for (i in a1.indices) {
        a1[i] = (i + 1) * 10
    }

    val a2: Array<Int> = Array(10) { 0 }
    for (i in a2.indices) {
        a2[i] = a1[i]
    }

    val a3: List<Int> = listOf(1, 2, 3)
    val a4: Array<String> = arrayOf("sfs", "safsa", "asf")

    val a5 = mutableListOf<Float>()
    a5.add(8.23F)
    a5.add(1.22F)

    for (element in a5.) {
        println(element)
    }

    val a6 = listOf("asda","adsad","aswww")

    val a7: Set<Int> = setOf()

    val a8 = mutableSetOf<String>("weewe", "sdsds")
    a8.add("ssewlrkkw")
    a8.remove("sdsds")

    val a9 = setOf<Int>(1, 4, 6)
    val a10 = setOf<Int>(1, 4, 5)
    val a11 = mutableSetOf<Int>()

    for (element in a9) {
        a11.add(element)
    }
    for (element in a10) {
        a11.add(element)
    }

    val a12 = mutableSetOf<Int>()
    for (element in a9) {
        for (el in a10) {
            if (element == el) {
                a12.add(element)
            }
        }
    }
}

fun fun1(list: List<String>) {
    val str = "smth"
    for (elements in list) {
        if (elements == str) {
            println("True")
            return
        }
    }
    println("False")
}