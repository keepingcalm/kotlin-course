package ru.kotlin.lessons.lesson24.homeworks

// 1 Создай функцию, которая:
//принимает булево значение
//принимает функцию, принимающую строку и ничего не возвращающую
//возвращает целое число

fun home1(flag: Boolean, action: (String) -> Unit): Int {
    if (flag) {
        action("Флаг был true")
        return 1
    } else {
        action("Флаг был false")
        return 0
    }
}

// 2 Создай функцию расширения целого числа, которая:
//принимает функцию расширения целого числа, принимающую строку и возвращающую список строк
//возвращает список строк

fun Int.home2(fn: Int.(String) -> List<String>): List<String> {
    return this.fn(this.toString())
}

// 3 Создай функцию с двумя дженериками расширяющую первый дженерик, которая:
//принимает функцию расширяющую первый дженерик, ничего не принимает и возвращает второй дженерик
//возвращает второй дженерик

fun <T, R> T.home3(fn: T.() -> R): R {
    return this.fn()
}

// 4 Создай функцию, которая:
//принимает строку
//возвращает функцию, которая ничего не принимает и возвращает строку

fun home4(text: String): () -> String {
    return { text }
}

// 5 Создай функцию расширяющую дженерик, которая:
//ничего не принимает
//возвращает функцию, принимающую строку и возвращающую дженерик

fun <T> T.home5(): (String) -> T {
    return { this }
}

// 6 Напиши функцию colorizeWords которая печатает слова из длинного предложения разбитого по пробелу разным цветом.
// Правило подбора цвета для каждого слова нужно передавать в виде функции, которая принимает слово и возвращает это же слово но уже "в цвете" через функцию colorize.
//Функция colorizeWords должна расширять строку и эту же строку и обрабатывать.

object Colors {
    const val RESET = "\u001B[0m"
    const val RED = "\u001B[31m"
    const val GREEN = "\u001B[32m"
    const val YELLOW = "\u001B[33m"
    const val BLUE = "\u001B[34m"
    const val PURPLE = "\u001B[35m"
    const val CYAN = "\u001B[36m"
    const val WHITE = "\u001B[37m"
}

fun String.colorize(color: String): String {
    return "$color$this${Colors.RESET}"
}

fun String.colorizeWords(transform: (String) -> String) {
    this.split(" ").forEach { word ->
        print(transform(word) + " ")
    }
    println()
}

fun main() {
    val result1 = home1(false) { message ->
        println("Сообщение: $message")
    }

    println("Результат: $result1")

    val result2 = 42.home2 { str ->
        listOf("Я число: $this", "А вот строка: $str")
    }

    println(result2)

    val number = 10

    val result3 = number.home3 {
        this * 5   // возвращаем R, здесь R = Int
    }

    println(result3) // 50

    val result4 = home4(text = "test")
    println(result4())

    val result5 = 42.home5()
    println(result5("anything"))   // 42

}
