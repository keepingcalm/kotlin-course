package ru.kotlin.lessons.lesson19.homeworks

// 4 Создай класс PhrasesToListOfStrings и имплементируй интефрейс Mapper с типами String и List<String>.
// Метод преобразования должен разбивать входящую строку по символу пробела и возвращать список из полученных слов.
// Метод преобразования списков с аналогичной механикой.

class PhrasesToListOfStrings : `3Mapper`<String, List<String>> {
    override fun mapItem(item: String): List<String> {
        return item.split(" ").filter { it.isNotBlank() }
    }

    override fun mapList(items: List<String>): List<List<String>> {
        return items.map { mapItem(it) }
    }
}
