package ru.kotlin.lessons.lesson21.homeworks

//Задача 1
//
//Напишите функцию analyzeDataType, принимающую параметр типа Any. Функция должна определить тип аргумента и вывести соответствующее сообщение:
//
//Для строки: "Это строка: [значение]".
//Для любого числа: "Это число: [значение]".
//Для списка: "Это список, количество элементов: [количество]".
//Для словаря: "Это словарь, количество пар: [количество]".
//Для остальных типов: "Неизвестный тип данных".
//Используйте оператор is для проверки типов.

fun analyzeDataType(input: Any) {
    when (input) {
        is String -> println("Cтрока: $input")
        is Number -> println("Число: $input")
        is List<*> -> println("Список, количество элементов: ${input.size}")
        is Map<*, *> -> println("Словарь, количество пар: ${input.size}")
        else -> println("Неизвестный тип данных")
    }
}

//Задача 2
//
//Создайте функцию safeCastToList, принимающую параметр типа Any и возвращающую размер списка,
//если аргумент можно безопасно привести к типу List. В случае неудачного приведения функция должна возвращать -1.
//Используйте as? для безопасного приведения типа.

fun safeCastToList(input: Any): Int {
    val list = input as? List<*> ?: return -1
    return list.size
}

//Задача 3
//
//Создайте функцию getStringLengthOrZero, которая принимает параметр типа Any?
//и возвращает длину строки, если аргумент можно привести к типу String.
//В случае, если аргумент равен null или не является строкой, функция должна возвращать 0.

fun getStringLengthOrZero(input: Any?): Int {
    return if (input is String) input.length else 0
}

//Задача 4
//
//Создайте функцию-расширение класса Any toSquare. Функция гарантированно вызывается у числа
//(в виде числа или строки, например 4 или 4.2 или “4.2”) и должна вернуть квадрат этого числа.
//Если придёт число, его нужно возвести в квадрат,
//если придёт строка, то его нужно преобразовать в число через функцию toDouble() и возвести в квадрат.

fun Any.toSquare(): Double {
    return when (this) {
        is Number -> this.toDouble() * this.toDouble()
        is String -> this.toDouble() * this.toDouble()
        else -> throw IllegalArgumentException("toSquare() можно вызвать только у чисел и строк-чисел")
    }
}

//Задача 5
//
//Напишите функцию sumIntOrDoubleValues, которая принимает список элементов типа Any и возвращает сумму всех целочисленных (Int)
//и вещественных (Double) значений в списке. Все остальные типы должны быть проигнорированы.

fun sumIntOrDoubleValues(list: List<Any>): Double {
    var sum = 0.0
    for (item in list) {
        when (item) {
            is Int -> sum += item
            is Double -> sum += item
        }
    }
    return sum
}

//Задача 6
//
//Создайте функцию tryCastToListAndPrint, которая принимает параметр типа Any и пытается привести его к типу List<*>.
//Если приведение успешно, функция должна напечатать все строки из списка, если элемент не является строкой то вывести предупреждение об этом.
//Если приведение неудачно, должно быть выведено сообщение об ошибке, не прерывая выполнение программы.

fun tryCastToListAndPrint(input: Any) {
    val list = input as? List<*>
    if (list == null) {
        println("Ошибка: переданный аргумент не является списком")
        return
    }

    for (item in list) {
        if (item is String) {
            println(item)
        } else {
            println("Предупреждение: элемент '$item' не является строкой")
        }
    }
}

fun main() {
    analyzeDataType("Привет")
    analyzeDataType(42)
    analyzeDataType(listOf(1,2,3))
    analyzeDataType(mapOf("a" to 1))
    analyzeDataType(3.14)

    println(safeCastToList(listOf(1,2,3)))
    println(safeCastToList("не список"))

    println(getStringLengthOrZero("hello"))
    println(getStringLengthOrZero(123))
    println(getStringLengthOrZero(null))

    println(4.toSquare())
    println("4.2".toSquare())

    println(sumIntOrDoubleValues(listOf(1, 2.5, "строка", 8)))

    tryCastToListAndPrint(listOf("Оля", "кот", 12232324, "тест"))
    tryCastToListAndPrint("не список")
}
