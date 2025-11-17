package ru.kotlin.lessons.lesson20.homeworks

import kotlin.math.absoluteValue

// 1 Определите функцию-расширение для массива чисел,
// которая не принимает аргументов и возвращает пару из чисел - первое и последнее.
// Если массив был пуст то вернуть пару из null значений.

fun Array<Int>.firstAndLast(): Pair<Int?, Int?> {
    if (this.isEmpty()) return Pair(null, null)
    return Pair(this.first(), this.last())
}

//2 Создайте функцию-расширение для изменяемого списка элементов:
//с дженериком T ограниченным интерфейсом Comparable<T>
//которая принимает булево значение
//возвращает этот же список только в виде неизменяемого
//сам изменяемый список при этом должен стать отсортированным по возрастанию, если в функцию передано true и по убыванию, если false (используем функции sort() и sortDescending()

fun <T : Comparable<T>> MutableList<T>.sortedImmutable(asc: Boolean): List<T> {
    if (asc) this.sort() else this.sortDescending()
    return this.toList() // immutable
}

// 3 Создайте функцию-расширение для nullable словаря с дженериком:
//Ключ является дженериком
//Значение является списком из дженериков
//Принимает целое число
//Возвращает nullable словарь из ключей изначального словаря приведённых к строке через toString()
//Значений из nullable дженерика, взятых из изначального ключа-списка по индексу из аргумента, если такого индекса нет - значением будет null

fun <K, V> Map<K, List<V>>?.extractAt(index: Int): Map<String, V?>? {
    if (this == null) return null

    return this.mapValues { (_, list) ->
        list.getOrNull(index)
    }.mapKeys { (k, _) ->
        k.toString()
    }
}

// 4 Реализуйте метод расширения within для класса Number, который проверяет, что текущее число отклоняется от эталонного
// не более допустимого значения. Метод принимает два параметра: other — число для сравнения и deviation — максимально допустимое отклонение.
// Метод должен возвращать true, если разница между текущим числом и числом для сравнения не превышает заданное отклонение. Протестируйте функцию на разных типах чисел.
// Для получения отклонения, у разницы чисел нужно вызвать свойство absoluteValue.


fun Number.within(other: Number, deviation: Number): Boolean {
    return (this.toDouble() - other.toDouble()).absoluteValue <= deviation.toDouble()
}


// 5 Реализуйте для класса String два метода расширения: encrypt и decrypt. 
// Метод encrypt должен сдвигать каждый символ исходной строки на заданное число позиций вперед по таблице Unicode, 
// а метод decrypt — на то же число позиций назад. Оба метода принимают один параметр base типа Int, 
// который определяет величину сдвига. Протестируйте вашу реализацию, убедившись, что после шифрования 
// и последующей расшифровки строка возвращается к исходному состоянию.
//Сдвиг по таблице Unicode реализуется простым прибавлением или вычитанием размера сдвига к char символу.

fun String.encrypt(base: Int): String =
    this.map { (it.code + base).toChar() }.joinToString("")

fun String.decrypt(base: Int): String =
    this.map { (it.code - base).toChar() }.joinToString("")

// 6 Многие уже знают любимую игру в Твиттере - собирание разных слов из букв через ответы (но мы то знаем что слово только одно, но не будем его называть).
// Напиши метод расширения строки, который будет принимать список имён пользователей
// и выводить в консоли исходную строку побуквенно в верхнем регистре в столбик: имя автора и букву под ним.

fun String.tweetStyle(users: List<String>) {
    this.uppercase().forEachIndexed { i, char ->
        val user = users.getOrNull(i % users.size) // на случай, если букв больше
        println("$user\n$char\n")
    }
}




fun main() {
    //1
    val arr = arrayOf(10, 20, 30)
    println(arr.firstAndLast()) // (10, 30)
    val empty = arrayOf<Int>()
    println(empty.firstAndLast()) // (null, null)
    // 2
    val list = mutableListOf(3, 1, 2)
    val result = list.sortedImmutable(true)
    println(result) // [1, 2, 3]
    // 3
    val map = mapOf(
        1 to listOf("a", "b", "c"),
        2 to listOf("x")
    )
    println(map.extractAt(1)) // {1=b, 2=null}
    // 4
    println(10.within(12, 3)) // true
    println(10.5.within(10.0, 0.4)) // false
    // 5
    val text = "Hello!"
    val encrypted = text.encrypt(3)
    val decrypted = encrypted.decrypt(3)

    println(encrypted)
    println(decrypted) // "Hello!"
    // 6
    val users = listOf("бардуля", "keeping_words", "lilya_kebab", "klaass")
    val word = "путлер"

    word.tweetStyle(users)
}
