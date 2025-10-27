package ru.kotlin.lessons.lesson14.homeworks

data class Grocery(val name: String, val price: Double, val quantity: Int)
fun main() {
    val apple = Grocery("Apple", 0.5, 10)
    println(apple)
}