package ru.kotlin.lessons.lesson08

fun main1() {
    val justString = "this is string"

    val firstName = "Olga"
    val lastName = "Dor"
    val fullName = firstName + " " + lastName // "Olga Dor"
    println(fullName)
    val age = 37
    val greeting = "He${age}llo! My name is $firstName and I'm $age old"
    println(greeting)

    val origString = "Kotln is fun"
    val subString = origString.substring(7) // "is fun"
    val subString2 = origString.substring(3, 6) // "lin"

    val replaceString = origString.replace("i", "I") // "KotlIn Is  fun"
    println(replaceString)
    val words = origString.split(" ") // ["Kotlin","is","fun"]
    println(words)

    val length = "Hello Kotlin".length
    println(length)

    // индексы считаются с нуля - подсчет количества с единицы

    val upper = "hello".uppercase() // "HELLO"
    val lower = "HELLO".lowercase() // "hello"

    val trimmed = "  hello  ".trim() // "hello"

    val starts = " Kotlin".trim().startsWith("Kot", true) // true

    val ends = "Kotlin".endsWith("lin", true) // true

    val contains1: Boolean = "Hello".contains("ell") // true
    val contains2: Boolean = "Hello".contains("L", true) // true

    val s: String? = null
    val empty = s?.isNullOrEmpty() // true
    val blank = s.isNullOrBlank() // true

    val repeat = "ab".repeat(3) // "ababab"

    val letter = origString[5] // 'n'

    val indexOfChar1: Int = "Kotlin".indexOf('t') //3
    val indexOfChar2: Int = "Kotlin".indexOf("li") // 3
    val indexOfWord = "Kotlin is the best of".indexOf("best") // 3

    val backReverse = "niltoK".reversed()

    val multiLineString = """
        first line
        second line
        third line
    """.trimIndent() // трим индент очищает пробелы, выбирая наименьший пробел из существующих
    println(multiLineString.format())
}

fun main() {
    example1("Ошибка в системе вызвала панику")
    //example1("для завершения проекта важно")
}

fun example1(arg: String) {
    val result = when {
        arg.startsWith("Ошибка") -> arg.replace(
            "Ошибка",
            "Небольшое недоразумение"
        )
        arg.endsWith("важно") -> "$arg ...но не критично"
    else -> arg
    }
    println(result)
}