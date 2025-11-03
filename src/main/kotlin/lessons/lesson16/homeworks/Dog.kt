package ru.kotlin.lessons.lesson16.homeworks

class Dog : Animal() {
    override fun makeSound() {
        printColored("Bark", Colors.YELLOW)
    }
}