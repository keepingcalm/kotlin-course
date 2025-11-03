package ru.kotlin.lessons.lesson16.homeworks

import kotlin.math.*

class Circle(private val radius: Double) : Shape() {
    override fun area(): Double {
        return Math.PI * radius.pow(2)
    }
}
