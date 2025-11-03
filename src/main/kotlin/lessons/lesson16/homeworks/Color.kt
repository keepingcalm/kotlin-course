package ru.kotlin.lessons.lesson16.homeworks

//Переопределение методов
//
//Животные и Их Звуки
//Базовый класс: Animal с методом makeSound().
//Классы наследники: Dog, Cat, Bird.
//Базовый метод makeSound() в классе Animal выводит "This animal makes no sound."
//Переопределите метод makeSound() в каждом классе-наследнике, чтобы Dog выводил "Bark", Cat - "Meow", Bird - "Tweet". Обогати вывод звуков цветом.
//Создайте список животных List<Animal> и вызовите в цикле метод makeSound()


object Colors {
    const val RESET = "\u001B[0m"
    const val RED = "\u001B[31m"
    const val GREEN = "\u001B[32m"
    const val YELLOW = "\u001B[33m"
    const val BLUE = "\u001B[34m"
    const val PURPLE = "\u001B[35m"
}


fun printColored(text: String, color: String) {
    println("$color$text${Colors.RESET}")
}

fun main() {
    val dog = Dog()
    val cat = Cat()
    val bird = Bird()

    dog.makeSound()
    cat.makeSound()
    bird.makeSound()

    println("\n--- Список животных ---")

    val animals: List<Animal> = listOf(dog, cat, bird)
    animals.forEach { it.makeSound() }
}