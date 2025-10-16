package ru.kotlin.lessons.lesson12.homeworks

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
    val homeworkText = listOf<String?>("ldsad", null, "sdsdsd", "eportpeot", "19", null, "asdad", "444", "88", "33xsada")
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
// 20 Группировать список по первой букве слов
// 21 Очистить список от дублей
//22 Отсортировать список по убыванию
//23 Взять последние 3 элемента списка

}