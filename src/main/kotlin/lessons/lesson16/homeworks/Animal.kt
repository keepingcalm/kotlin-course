package ru.kotlin.lessons.lesson16.homeworks

abstract class Animal {
    open fun makeSound() {
        printColored("This animal makes no sound.", Colors.PURPLE)
    }
}