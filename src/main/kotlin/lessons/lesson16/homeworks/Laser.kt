package ru.kotlin.lessons.lesson16.homeworks

class LaserPrinter : PrinterBase() {
    override fun print(text: String) {
        val words = text.split(" ")
        words.forEach { word ->
            printColored(word, Colors.YELLOW, Background.WHITE)
        }
    }
}