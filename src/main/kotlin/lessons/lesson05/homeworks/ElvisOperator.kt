package ru.kotlin.lessons.lesson05.homeworks

fun main() {
    val soundLevel: Double = 55.99
    val coefficient: Double? = null
    val newSoundLevel: Double = soundLevel * (coefficient ?: 0.5)
    println(newSoundLevel)

    val priceGoods: Double? = null
    val costDelivery: Double = 88.88
    val priceInsurance: Double = (priceGoods ?: 50.00) / 200.00
    val totalCostDelivery = costDelivery + priceInsurance
    println(totalCostDelivery)

    val bar: Int? = null
    val message = (bar ?: "Error")
    println(message)
}