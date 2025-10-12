package ru.kotlin.lessons.lesson11.homeworks

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
fun a5 (a5: String?): Int? {
    return a5?.length
}
//6 Не принимает аргументов и возвращает nullable вещественное число.
fun a6 (): Double? {
    return 5.66
}

//7 Принимает nullable список целых чисел, не возвращает значения и доступна только в текущем файле.
private fun a7 (a7: List<Int>?): Unit {

}
//8 Принимает целое число и возвращает nullable строку.
fun a8 (a8: Int): String? {
    return "sss"
}
//9 Не принимает аргументов и возвращает список nullable строк.
fun a9(): List<String?> {
    return listOf("sdsd", "asad", null)
}
//10 Принимает nullable строку и nullable целое число и возвращает nullable булево значение.
fun a10 (a10: String?, a11: Int?): Boolean? {
    return false
}
