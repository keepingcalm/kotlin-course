package ru.kotlin.lessons.lesson23


class OrderProcessor(val deliveryAddress: String)

fun calculateDeliveryTime(productId: Int): String {
    val deliveryTimeDays = when (productId) {
        in 1..100 -> 3
        else -> 5
    }
    return "Ожидаемая дата доставки: через $deliveryTimeDays дня(ей) по адресу $deliveryAddress."
}


// Обычное объявление функции
fun increment(a: Int): Int {
    return a + 1
}

fun main() {
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
    val t = {a: String ->
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

fun findIndex(text: String, word: String, ignoreCase: Boolean = false): Int {
    return text.indexOf(word, 0, ignoreCase)
}

fun String.qwe(d: Int) {
}

