package ru.kotlin.lessons.lesson09.homeworks

import ru.kotlin.homework.PI

fun main() {

//    Работа с массивами Array

    //Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
    val numbers1: Array<Int> = arrayOf(1, 2, 3, 4, 5)
//    //Создайте пустой массив строк размером 10 элементов.
    val emptyArray2: Array<String> = Array(10) { "" }
//    //Создайте массив из 5 элементов типа Double и заполните его значениями, являющимися удвоенным индексом элемента.
    val doubleArray3 = DoubleArray(5) { index -> index * 2.0 }
//    //Создайте массив из 5 элементов типа Int. Используйте цикл, чтобы присвоить каждому элементу значение, равное его индексу, умноженному на 3.
    val case4 = IntArray(5)
    for (index in case4.indices) {
        case4[index] = index * 3
    }
    //Создайте массив из 3 nullable строк. Инициализируйте его одним null значением и двумя строками.
    val nullable5: Array<String?> = arrayOf(null, "aaa", "adsas")
    //Создайте массив целых чисел и скопируйте его в новый массив в цикле.
    val array6: Array<Int> = arrayOf(1, 4, 6, 7)
    val newArray: Array<Int> = arrayOf()
    for (i in array6.indices) {
        newArray[i] = array6[i]
    }
    //Создайте два массива целых чисел одинаковой длины. Создайте третий массив, вычев значения одного из другого. Распечатайте полученные значения.
    val array7: Array<Int> = arrayOf(1, 6, 7, 8, 3, 7)
    val arrayTwo: Array<Int> = arrayOf(100, 6, 2, 3, 7, 5)
    val arrayThree = IntArray(arrayTwo.size)
    for (i in array7.indices) {
        arrayThree[i] = array7[i] - arrayTwo[i]
    }
    //Создайте массив целых чисел. Найдите индекс элемента со значением 5. Если значения 5 нет в массиве, печатаем -1. Реши задачу через цикл while.
    val array8: Array<Int> = arrayOf(1, 5, 2, 6, 4, 6)
    var index = 0
    var foundInd = -1
    while (index < array8.size) {
        if (array8[index] == 5) {
            foundInd = index
            break
        }
        index++
    }
    println(foundInd)
    //Создайте массив целых чисел. Используйте цикл для перебора массива и вывода каждого элемента в консоль. Напротив каждого элемента должно быть написано “чётное” или “нечётное”.
    val array9: Array<Int> = arrayOf(1, 2, 3, 4, 5, 6, 7)
    for (numb in array9) {
        if (numb % 2 == 0) {
            println("$numb - even number")
        } else {
            println("$numb - odd number")
        }
    }
    //Создай функцию, которая принимает массив строк и строку для поиска. Функция должна находить в массиве элемент, в котором принятая строка является подстрокой (метод contains()). Распечатай найденный элемент.
    val array: Array<String> = arrayOf()
    fun searchSubString(array: Array<String>, search: String) {
        for (elem in array) {
            if (elem.contains(search)) {
                println("Found piece: $elem")
                return
            }
        }
    }

//Работа со списками List

    //Создайте пустой неизменяемый список целых чисел.
    val list1: List<Int> = listOf()

    //Создайте неизменяемый список строк, содержащий три элемента (например, "Hello", "World", "Kotlin").
    val list2: List<String> = listOf("hello", "world", "kotlin")

    //Создайте изменяемый список целых чисел и инициализируйте его значениями от 1 до 5.
    val list3: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)

    //Имея изменяемый список целых чисел, добавьте в него новые элементы (например, 6, 7, 8).
    val list4: MutableList<Int> = mutableListOf(1, 2, 4, 5)
    list4.add(6)
    list4.add(7)
    list4.add(8)
    //Имея изменяемый список строк, удалите из него определенный элемент (например, "World").
    val list5: MutableList<String> = mutableListOf("World", "adsda")
    list5.remove("World")

    //Создайте список целых чисел и используйте цикл для вывода каждого элемента на экран.
    val list6: List<Int> = listOf(1, 2, 4, 4, 5)
    for (i in list6) {
        println(i)
    }

    //Создайте список строк и получите из него второй элемент, используя его индекс.
    val list7: List<String> = listOf("dkfjk", "slfkslfd", "sflkjsdfk", "woeiwo")
    println(list7[1])

    //Имея изменяемый список чисел, измените значение элемента на определенной позиции (например, замените элемент с индексом 2 на новое значение).
    val list8: MutableList<Int> = mutableListOf<Int>(1, 2, 3, 4, 5, 67)
    list8[2] = 33

    //Создайте два списка строк и объедините их в один новый список, содержащий элементы обоих списков. Реши задачу с помощью циклов.
    val list9: List<String> = listOf("skdfkjd", "adlks", "sldksld")
    val list92: List<String> = listOf("22skdfkjd", "22adlks", "22sldksld")
    val sumOfList = mutableListOf<String>()
    for (i in list9) {
        sumOfList.add(i)
    }
    for (i in list92) {
        sumOfList.add(i)
    }
    println(sumOfList)

    //Создайте список целых чисел и найдите в нем минимальный и максимальный элементы используя цикл.
    val list10: List<Int> = listOf(1, 4, 5, 7, 8, 99)
    var min = list10[0]
    var max = list10[0]
    for (i in list10) {
        if (i < min) {
            min = i
        }
        if (i > max) {
            max = i
        }
    }
    println("Min element: $min + Max element: $max")

    //Имея список целых чисел, создайте новый список, содержащий только четные числа из исходного списка используя цикл.
    val list11: List<Int> = listOf(1, 2, 4, 5, 7, 8, 9, 10, 13, 14)
    val list112: MutableList<Int> = mutableListOf()
    for (i in list11) {
        if (i % 2 == 0) {
            list112.add(i)
        }
    }
    println(list112)

// Работа с Множествами Set

    //Создайте пустое неизменяемое множество целых чисел.
    val set1: Set<Int> = emptySet()

    //Создайте неизменяемое множество целых чисел, содержащее три различных элемента (например, 1, 2, 3).
    val set2: Set<Int> = setOf(1, 2, 3)

    //Создайте изменяемое множество строк и инициализируйте его несколькими значениями (например, "Kotlin", "Java", "Scala").
    val set3: MutableSet<String> = mutableSetOf("Kotlin", "Java", "Scala")

    //Имея изменяемое множество строк, добавьте в него новые элементы (например, "Swift", "Go").
    val set4: MutableSet<String> = mutableSetOf()
    set4.add("Swift")
    set4.add("Go")

    // Имея изменяемое множество целых чисел, удалите из него определенный элемент (например, 2).
    val set5: MutableSet<Int> = mutableSetOf(1, 2, 4, 5, 6, 7)
    set5.remove(2)

    //Создайте множество целых чисел и используйте цикл для вывода каждого элемента на экран.
    val set6: Set<Int> = setOf(1, 2, 3, 4, 5, 6, 7)
    for (i in set6) {
        println(i)
    }

    //Создай функцию, которая принимает множество строк (set) и строку и проверяет, есть ли в множестве указанная строка. Нужно вернуть булево значение true если строка есть. Реши задачу через цикл.
    fun set7(set: Set<String>, words: String): Boolean {
        for (i in set) {
            if (i == words) {
                return true
            }
        }
        return false
    }

    //Создайте множество строк и конвертируйте его в изменяемый список строк с использованием цикла.
    val setStrings: Set<String> = setOf("cow", "cat", "dog")
    val list999: MutableList<String> = mutableListOf()
    for (i in setStrings) {
        list999.add(i)
    }
    println(list999)
}



