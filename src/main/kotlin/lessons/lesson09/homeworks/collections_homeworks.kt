package ru.kotlin.lessons.lesson09.homeworks

fun main(){
    //Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
    val numbers1: Array<Int> = arrayOf(1, 2, 3, 4, 5)
//    //Создайте пустой массив строк размером 10 элементов.
    val emptyArray2: Array<String>  = Array(10) {""}
//    //Создайте массив из 5 элементов типа Double и заполните его значениями, являющимися удвоенным индексом элемента.
    val doubleArray3= DoubleArray(5) { index -> index * 2.0}
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
    fun searchSubString (array: Array<String>, search: String) {
        for (elem in array) {
            if (elem.contains(search)) {
                println("Found piece: $elem")
                return
            }
        }
    }
}

//fun case4 (arg: Int) {
//    val case4 = IntArray(5)
//    for (index in case4.indices) {
//        case4[index] = index * 3
//    }
//    println("Вот: ")
//    for (index in case4.indices) {
//        print("${case4[index]} ")
//    }
//}

fun searchSubString (array: Array<String>, search: String) {
    for (elem in array) {
        if (elem.contains(search)) {
            println("Found piece: $elem")
            return
        }
    }
}