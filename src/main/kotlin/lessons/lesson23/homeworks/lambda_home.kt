package ru.kotlin.lessons.lesson23.homeworks

//Создай функцию, которая принимает список чисел и возвращает среднее арифметическое всех чётных чисел этого списка. С помощью require проверь, что список не пустой.
//Создай аналогичную анонимную функцию.
//Создай аналогичное лямбда выражение с указанием типа.
//Создай лямбда выражение без указания типа.
//Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных (в том числе пустого).

fun averageOfEven(numbers: List<Int>): Double {
    require(numbers.isNotEmpty()) { "Список не должен быть пустым" }

    val evens = numbers.filter { it % 2 == 0 }
    return evens.average()
}

//anonim

val averageOfEvenAnonymous = fun(numbers: List<Int>): Double {
    require(numbers.isNotEmpty()) { "Список не должен быть пустым" }

    val evens = numbers.filter { it % 2 == 0 }
    return evens.average()
}

// lambda with type
val averageOfEvenLambdaTyped: (List<Int>) -> Double = { numbers ->
    require(numbers.isNotEmpty()) { "Список не должен быть пустым" }

    val evens = numbers.filter { it % 2 == 0 }
    evens.average()
}

// lambda without type

val averageOfEvenLambda = { numbers: List<Int> ->
    require(numbers.isNotEmpty()) { "Список не должен быть пустым" }

    numbers.filter { it % 2 == 0 }.average()
}

//Создай функцию, которая принимает большое число и возвращает сумму цифр этого числа. Сделай проверку, что входящее число больше нуля. Подсказка: для парсинга символа в число можно использовать функцию digitToInt()
//Создай аналогичную анонимную функцию.
//Создай аналогичное лямбда выражение с указанием типа.
//Создай лямбда выражение без указания типа.
//Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.

fun sumOfDigits(num: Long): Int {
    require(num > 0) { "Число должно быть больше нуля" }

    return num.toString().sumOf { it.digitToInt() }
}

// anonim

val sumOfDigitsAnonymous = fun(num: Long): Int {
    require(num > 0) { "Число должно быть больше нуля" }

    return num.toString().sumOf { it.digitToInt() }
}

// lambda with type

val sumOfDigitsLambdaTyped: (Long) -> Int = { num ->
    require(num > 0) { "Число должно быть больше нуля" }

    num.toString().sumOf { it.digitToInt() }
}

// lambda without type

val sumOfDigitsLambda = { num: Long ->
    require(num > 0) { "Число должно быть больше нуля" }

    num.toString().sumOf { it.digitToInt() }
}

//Создай функцию-расширение списка чисел, которая будет возвращать множество дубликатов чисел (встречающихся в списке более одного раза).
//Создай аналогичную анонимную функцию.
//Создай аналогичное лямбда выражение с указанием типа.
//Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.

fun List<Int>.duplicates(): Set<Int> =
    this.groupingBy { it }.eachCount().filter { it.value > 1 }.keys

// anonim

val duplicatesAnonymous = fun(list: List<Int>): Set<Int> {
    return list.groupingBy { it }.eachCount().filter { it.value > 1 }.keys
}

// lambda with type

val duplicatesLambdaTyped: (List<Int>) -> Set<Int> = { list ->
    list.groupingBy { it }.eachCount().filter { it.value > 1 }.keys
}



fun main() {
    // 1
    println(averageOfEven(listOf(2, 4, 6)))              // 4.0
    println(averageOfEvenLambdaTyped(listOf(1, 2, 3)))   // 2.0
    println(averageOfEvenAnonymous(listOf(10, 11, 12)))  // 11.0

    try {
        println(averageOfEvenLambda(emptyList()))
    } catch (e: IllegalArgumentException) {
        println(e.message) // ожидаем ошибку
    }

    // 2
    println(sumOfDigits(12345))               // 15
    println(sumOfDigitsLambdaTyped(9999))     // 36
    println(sumOfDigitsAnonymous(1000001))    // 2

    try {
        println(sumOfDigitsLambda(0))
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    // 3
    println(listOf(1, 2, 2, 3, 3, 3).duplicates())        // [2, 3]
    println(duplicatesLambdaTyped(listOf(5, 5, 5, 1)))    // [5]
    println(duplicatesAnonymous(listOf(1, 2, 3)))         // []


}