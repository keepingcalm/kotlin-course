package ru.kotlin.lessons.lesson23

// Обычное объявление функции
fun increment(a: Int): Int {
    return a + 1
}

fun main() {
    // Анонимная функция, присвоенная переменной
    val increment1 = fun(a: Int): Int {
        return a + 1
    }

    // Лямбда выражение с явно указанным типом
    val increment2: (Int) -> Int = { f ->
        f + 1
    }

    println(increment(2))
    println(increment1(2))
    println(increment2(2))
}