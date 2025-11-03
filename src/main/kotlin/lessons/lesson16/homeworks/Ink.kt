package ru.kotlin.lessons.lesson16.homeworks

class InkjetPrinter : PrinterBase() {

    private val colorPairs = listOf(
        Colors.RED to Background.YELLOW,
        Colors.GREEN to Background.PURPLE,
        Colors.BLUE to Background.CYAN,
        Colors.YELLOW to Background.BLUE,
        Colors.PURPLE to Background.GREEN
    )

    override fun print(text: String) {
        val words = text.split(" ")
        words.forEachIndexed { index, word ->
            val (textColor, bgColor) = colorPairs[index % colorPairs.size]
            printColored(word, textColor, bgColor)
        }
    }
}