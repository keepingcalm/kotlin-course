package ru.kotlin.lessons.lesson19.homeworks

// 1 Напиши функцию getMiddleElement с дженериком, которая будет принимать список и возвращать средний элемент,
// если он существует, иначе возвращать null. Например, у списка из четырёх элементов - среднего элемента нет.

fun <T> getMiddleElement(list: List<T>): T? {
    if (list.size % 2 == 0) return null   // нет среднего
    return list[list.size / 2]
}

fun <K, V> transposition(map: Map<K, V>): Map<V, K> {
    return map.entries.associate { (k, v) -> v to k }
}


fun main() {

    println(getMiddleElement(listOf(1,2,3,4,5)))  // 3
    println(getMiddleElement(listOf(1,2,3,4)))    // null

    val holder = ListHolder<String>()
    holder.add("Hello")
    holder.add("World")
    println(holder.getAll())

    val mapper = PhrasesToListOfStrings()
    println(mapper.mapItem("Hello world from Kotlin"))
    println(mapper.mapList(listOf("one two", "three   four")))

    val map = mapOf(1 to "A", 2 to "B")
    println(transposition(map)) // {A=1, B=2}

    val strValidator = StringValidator()
    println(strValidator.validate(" Kotlin ")) // true
    println(strValidator.validate("   "))      // false

    val evenValidator = OddValidator()
    println(evenValidator.validate(4))  // true
    println(evenValidator.validate(5))  // false

    val listValidator = ListValidator<Int>()
    println(listValidator.validate(listOf(1,2,3)))       // true
    println(listValidator.validate(listOf(1,0,3)))       // false
    println(listValidator.validate(listOf(1,null,3)))    // false
}
