package ru.kotlin.lessons.lesson23

class OrderProcessor(val deliveryAddress: String)

fun test1() {
    println("Hello there!")
}

val test2 = fun() {
    println("Hello there!")
}

val test3: () -> Unit = { println("Hello there!") }

val test4 = { println("Hello there!") }

fun test5(string: String): Int {
    return string.length
}

val test6 = fun(string: String): Int {
    return string.length
}

val test7: (String) -> Int = { it.length }

val test8 = { string: String -> string.length }

fun String.test9(arg1: Int, char: Char): Boolean {
    return length < arg1 && contains(char)
}

val test10 = fun String.(arg1: Int, char: Char): Boolean {
    return length < arg1 && contains(char)
}

val test11: String.(Int, Char) -> Boolean = { arg1, char -> length < arg1 && contains(char) }

fun <U> U.test12(arg2:U) {
    println(arg2)
}

// для дженериков нельзя использовать лямбда выражения и анонимные функции
//val test13 = fun <U> U.(arg2:U) {
//    println(arg2)
//}

fun OrderProcessor.calculateDeliveryTime(productId: Int): String {
    val deliveryTimeDays = when (productId) {
        in 1..100 -> 3
        else -> 5
    }
    return "Ожидаемая дата доставки: через $deliveryTimeDays дня(ей) по адресу $deliveryAddress."
}

fun findIndex(text: String, word: String, ignoreCase: Boolean = false): Int {
    return text.indexOf(word, 0, ignoreCase)
}

fun String.qwe(d: Int) {
}

// Обычное объявление функции
fun increment(a: Int): Int {
    return a + 1
}

fun main() {
    "ssafsdfs".test9(4, 'l')
    test3()

    val calculateDeliveryTime1 = fun OrderProcessor.(productId: Int): String {
        val deliveryTimeDays = when (productId) {
            in 1..100 -> 3
            else -> 5
        }
        return "Ожидаемая дата доставки: через $deliveryTimeDays дня(ей) по адресу $deliveryAddress."
    }

    val calculateDeliveryTime: OrderProcessor.(Int) -> String = {
        val deliveryTimeDays = when (it) {
            in 1..100 -> 3
            else -> 5
        }
        "Ожидаемая дата доставки: через $deliveryTimeDays дня(ей) по адресу $deliveryAddress."
    }

    val op = OrderProcessor("my address")
    calculateDeliveryTime(op, 34)
// или
    op.calculateDeliveryTime(34)
    val t = { a: String ->
        a.isEmpty()
    }
    listOf<String>().find(t)

    // Анонимная функция, присвоенная переменной
    val increment1 = fun(a: Int): Int {
        return a + 1
    }

    // Лямбда выражение с явно указанным типом
    val increment2: (f: Int) -> Int = { f ->
        f + 1
    }

    val increment3: (f: Int) -> Int = {
        println(it)
        it + 1
    }
    val result = increment3(8)

    val increment4 = { a: Int ->
        println(a)
        //a.toString()
        a + 1
    }
    // в анонимных функциях значение по умолчанию задавать нельзя
    val findIndex1 = fun(text: String, word: String, ignoreCase: Boolean): Int {
        return text.indexOf(word, 0, ignoreCase)
    }

    val findIndex2: (String, String, Boolean) -> Int = { text, word, ignoreCase ->
        text.indexOf(word, 0, ignoreCase)
    }

    val findIndex = { text: String, word: String, ignoreCase: Boolean ->
        text.indexOf(word, 0, ignoreCase)
    }

    "asas".qwe(8)

    println(increment(2))
    println(increment1(2))
    println(increment2(2))
}

