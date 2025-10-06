package ru.kotlin.lessons.lesson09.homeworks

fun main(){
    //Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
//    val numbers1: Array<Int> = arrayOf(1, 2, 3, 4, 5)
//    //Создайте пустой массив строк размером 10 элементов.
//    val emptyArray2: Array<String>  = Array(10) {""}
//    //Создайте массив из 5 элементов типа Double и заполните его значениями, являющимися удвоенным индексом элемента.
//    val doubleArray3= DoubleArray(5) { index -> index * 2.0}
//    //Создайте массив из 5 элементов типа Int. Используйте цикл, чтобы присвоить каждому элементу значение, равное его индексу, умноженному на 3.
//    val case4 = IntArray(5)
//    for (index in case4.indices) {
//        case4[index] = index * 3
//    }
//    println(case4)
    case4(arg = 0..4)
}

fun case4 (arg: Int) {
    val case4 = IntArray(5)
    for (index in case4.indices) {
        case4[index] = index * 3
    }
    println(case4[index])
}