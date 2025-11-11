package ru.kotlin.lessons.lesson19

class Box<R>(val item: R)

fun main1() {
    val a = listOf<String>()
    val appleBox = Box("Apple")
    val intBox = Box(42)

    val appleBoxAnyItem: Any = appleBox.item // Any вместо строки
    val intBoxAnyItem: Any = intBox.item // Any вместо числа

    appleBox.item

}

fun <S> secondOrNull(list: List<S>): S? {
    return list.getOrNull(1)
}

fun main() {
    val secondElementLength: Int? = secondOrNull(listOf("a", "b", "c"))?.length
}