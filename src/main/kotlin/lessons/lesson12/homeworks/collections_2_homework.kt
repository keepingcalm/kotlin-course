package ru.kotlin.lessons.lesson12.homeworks

import ru.kotlin.homework.PI
import ru.kotlin.homework.isOpen

fun main () {
//Задачи на приведение коллекции к значению
//1 Проверить, что размер коллекции больше 5 элементов.
    val homework = listOf(-1, 5, 7, 19, 23, 8, 444, 88, 33)
    if (homework.size > 5 ) {
        println("yes")
    }

//2 Проверить, что коллекция пустая
    homework.isEmpty()

//3 Проверить, что коллекция не пустая
    homework.isNotEmpty()

//4 Взять элемент по индексу или создать значение если индекса не существует
    val res4= homework.getOrElse(6) {3}
    println(res4)

//5 Собрать коллекцию в строку
    val res5 = homework.joinToString(separator = ", ")
    println(res5)

//6 Посчитать сумму всех значений
    val res6 = homework.sum()
    println(res6)

//7 Посчитать среднее
    val res7 = homework.average()
    println(res7)

//8 Взять максимальное число
    val res8 = homework.max()
    println(res8)

//9 Взять минимальное число
    val res9 = homework.min()
    println(res9)

//10 Взять первое число или null
    val res10 = homework.firstOrNull()
    println(res10)

//11 Проверить что коллекция содержит элемент
    val res11 = homework.contains(-1)
    println(res11)

    //Задачи на обработку коллекций
// 12 Отфильтровать коллекцию по диапазону 18-30
    val res12 = homework.filter { it in 18..30 }
    println(res12)

// 13 Выбрать числа, которые не делятся на 2 и 3 одновременно
    val res13 = homework.filter { it % 2 != 0 || it % 3 !=0 }
    println(res13)

// 14 Очистить текстовую коллекцию от null элементов
    val homeworkText = listOf<String?>("ldsad", null, "sdsdsd", "eportpeot", "l19", "l19", null, "asdad", "444", "88", "33xsada")
    val res14 = homeworkText.filterNotNull()
    println(res14)

// 15 Преобразовать текстовую коллекцию в коллекцию длин слов
    val res15 = homeworkText.map { it?.length ?: "nothing to count" }
    println(res15)

// 16 Преобразовать текстовую коллекцию в мапу, где ключи - перевёрнутые слова, а значения - длина слов
    val res16 = homeworkText.map { it -> it?.reversed() to it?.length }
    println(res16)

// 17 Отсортировать список в алфавитном порядке
    val res17 = homeworkText.sortedBy{it}
    println(res17)

// 18 Взять первые 3 элемента списка
    val res18 = homeworkText.take(3)
    println(res18)

// 19 Распечатать квадраты элементов списка
    val res19 = homework.associateWith { it*it }
    println(res19)

// 20 Группировать список по первой букве слов
    val res20 = homeworkText.groupBy { it?.first() }
    println(res20)

// 21 Очистить список от дублей
    val res21 = homeworkText.distinct()
    println(res21)

//22 Отсортировать список по убыванию
    val res22 = homework.sortedDescending()
    println(res22)

//23 Взять последние 3 элемента спискаf
    val res23 = homework.takeLast(3)
    println(res23)

}

//24. Характеристика числовой коллекции
//    Напиши функцию, которая принимает коллекцию чисел и возвращает строку с характеристикой коллекции используя конструкцию when
//    Если коллекция пустая - “Пусто”
//    Если количество элементов меньше пяти - “Короткая”
//    Если коллекция начинается с 0 - “Стартовая”
//    Если сумма всех чисел больше 10000 - “Массивная”
//    Если среднее значение равно 10 - “Сбалансированная”
//    Если длина строки образованная склеиванием коллекции в строку равна 20 - “Клейкая”
//    Если максимальное число меньше -10 - “Отрицательная”
//    Если минимальное число больше 1000 - “Положительная”
//    Если содержит одновременно числа 3 и 14 - “Пи***тая”
//    Иначе - “Уникальная”

fun ex24(arg24: List<Int>) {
    when {
        arg24.isEmpty() -> println("Пусто")
        arg24.size < 5 -> println("Короткая")
        arg24.firstOrNull() == 0 -> println("Стартовая")
        arg24.sum() > 10000 -> println("Массивная")
        arg24.average().toInt() == 10 -> println("Сбалансированная")
        arg24.joinToString("").length == 20 -> println("Клейкая")
        arg24.max() < -10 -> println("Отрицательная")
        arg24.min() > 1000 -> println("Положительная")
        arg24.contains(3) && arg24.contains(14) -> println("Пи***тая")
        else -> println("Уникальная")
    }
}