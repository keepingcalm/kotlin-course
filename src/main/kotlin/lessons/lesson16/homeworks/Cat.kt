package ru.kotlin.lessons.lesson16.homeworks

class Cat : Animal() {
    override fun makeSound() {
        printColored("Meow", Colors.GREEN)
    }
}