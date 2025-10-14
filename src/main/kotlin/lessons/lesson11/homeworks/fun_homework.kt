package ru.kotlin.lessons.lesson11.homeworks

import ru.kotlin.homework.status
import java.io.StringReader

//Задачи на сигнатуру метода
//1 Не принимает аргументов и не возвращает значения.
fun a1 () {

}
//2 Принимает два целых числа и возвращает их сумму.
fun a2 (a: Int, a2: Int): Int {
    return a + a2
}
//3 Принимает строку и ничего не возвращает.
fun a3 (a3: String) {

}
//4 Принимает список целых чисел и возвращает среднее значение типа Double.
fun a4 (a4: List<Int>): Double {
    return a4.average()
}
//5 Принимает nullable строку и возвращает её длину в виде nullable целого числа и доступна только в текущем файле.
private fun a5 (a5: String?): Int? {
    return a5?.length
}
//6 Не принимает аргументов и возвращает nullable вещественное число.
fun a6 (): Double? {
    return null
}

//7 Принимает nullable список целых чисел, не возвращает значения и доступна только в текущем файле.
private fun a7 (a7: List<Int>?): Unit {

}
//8 Принимает целое число и возвращает nullable строку.
fun a8 (a8: Int): String? {
    return null
}
//9 Не принимает аргументов и возвращает список nullable строк.
fun a9(): List<String?> {
    return listOf("test", "asad", null)
}
//10 Принимает nullable строку и nullable целое число и возвращает nullable булево значение.
fun a10 (a10: String?, a11: Int?): Boolean? {
    return false
}

// Задачи на написание кода
//1 Напишите функцию multiplyByTwo, которая принимает целое число и возвращает его, умноженное на 2.
fun multiplyByTwo (x1: Int): Int {
    return x1 * 2
}

//2 Создайте функцию isEven, которая принимает целое число и возвращает true, если число чётное, и false в противном случае.
fun isEven (x2: Int): Boolean {
    return if (x2 % 2 == 0) {
     true
    } else return false
}
//3 Напишите функцию printNumbersUntil, которая принимает целое число n и выводит на экран числа от 1 до n. Если число n меньше 1, функция должна прекратить выполнение с помощью return без вывода сообщений.
fun printNumbersUntil (x3: Int) {
    if (x3 < 1) return
    for (i in 1..x3) {
        println(i)
    }
}

//4 Создайте функцию findFirstNegative, которая принимает список целых чисел и возвращает первое отрицательное число в списке. Если отрицательных чисел нет, функция должна вернуть null.
fun findFirstNegative (x4: List<Int>): Int? {
    for (num in x4) {
        if (num < 0 ) return num
    }
    return null
}
//5 Напишите функцию processList, которая принимает список строк. Функция должна проходить по списку и выводить каждую строку. Если встречается null значение, функция должна прекратить выполнение с помощью return без возврата значения.
fun processList (x5: List<String?>) {
    for (string in x5) {
        println(string)
        if (string == null) return
    }

}