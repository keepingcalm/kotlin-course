package ru.kotlin.lessons.lesson22

fun main() {
//    throw Exception("Сообщение об ошибке")
//    throw Error ("ошибка типа")
//    OutOfMemoryError()
//    StackOverflowError()
//    Exception()

//    val exception = Exception("Сообщение об ошибке")
//    throw exception

    try {
//      null as String
        arrayOf("1")[2]
        println("dfsfs")
        return
        // Код, который может выбросить исключение
    } catch (e: IndexOutOfBoundsException) {
        println(e.message)
        // Обработка конкретного типа исключения
    } catch (e: Exception) {
        // Обработка всех остальных исключений
        println(e)
        throw e
    } finally {
        println("выполнится в любом случае")
        // Блок, который выполняется всегда, независимо от наличия исключения
    }

//    val obj: Int? = null
//    obj!! // null pointer exception
//    val list1 = listOf(1,2,3,4,5)
//    println(list1[5]) // java.lang.ArrayIndexOutOfBoundsException

//    val obj1: Any = 45
//    obj1 as String // class java.lang.Integer cannot be cast to class java.lang.String

    val string1 = "23.h"
    string1.toFloatOrNull() // безопасный способ без ошибки orNull

//    addMoney(-100) // java.lang.IllegalArgumentException: money zczasfds

//    val file = File("/adssada/adsadad")
//    file.readText() //  java.io.FileNotFoundException

//    val list2 = mutableListOf<Float>() // java.lang.OutOfMemoryError: Java heap space
//    while (true) {
//        list2.add(Math.PI.toFloat())
//    }

    try {
        val list11 = listOf(1,2,3,45,6,7)
        println(list11[20])
    } catch (e: ArrayIndexOutOfBoundsException) {
        throw MyExceptions(e.message)
    }
}

fun addMoney(money: Int) {
    check(money > 0) {
        "money zczasfds"
    }
}

fun placeOrder(orderDetails: String) {
    if (orderDetails.isBlank()) {
        throw OrderException("Детали заказа не указаны.")
    }
    // Логика оформления заказа
    println("Заказ оформлен: $orderDetails")
}

class OrderException(message: String) : RuntimeException(message)

class CustomException : RuntimeException {
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable) : super(message, cause)
    constructor(cause: Throwable) : super(cause)
}

class MyExceptions(message: String?) : RuntimeException(message) {

}



