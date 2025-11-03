package ru.kotlin.lessons.lesson16.homeworks

class Bird : Animal() {
    override fun makeSound() {
        printColored("Tweet", Colors.BLUE)
    }
}