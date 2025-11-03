package ru.kotlin.lessons.lesson16.homeworks



abstract class Shape {
    open fun area(): Double {
        return 0.0
    }
}

fun main() {
    val circle = Circle(5.0)
    val square = Square(4.0)
    val triangle = Triangle(3.0, 4.0, 90.0)

    val shapes: List<Shape> = listOf(circle, square, triangle)

    shapes.forEachIndexed { index, shape ->
        println("Фигура ${index + 1}: площадь = %.2f".format(shape.area()))
    }
}
