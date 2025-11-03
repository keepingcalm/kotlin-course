package ru.kotlin.lessons.lesson16.homeworks

import kotlin.math.*

class Square(private val side: Double) : Shape() {
    override fun area(): Double {
        return side.pow(2)
    }
}