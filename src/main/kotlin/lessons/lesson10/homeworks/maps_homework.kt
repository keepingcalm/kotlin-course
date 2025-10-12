package ru.kotlin.lessons.lesson10.homeworks

import ru.kotlin.homework.name

fun main() {
//    Задачи на работу со словарём
//    Создайте пустой неизменяемый словарь, где ключи и значения - целые числа.
    val map0 = mapOf<String, Int>()

//    Создайте словарь, инициализированный несколькими парами "ключ-значение", где ключи - float, а значения - double
    val map1 = mapOf<Float, Double>(23.44F to 23.33, 34.33F to 25.77)

//    Создайте изменяемый словарь, где ключи - целые числа, а значения - строки.
    val map2 = mutableMapOf<Int, String>(1 to "sadd")

//    Имея изменяемый словарь, добавьте в него новые пары "ключ-значение".
    val map3 = mutableMapOf<String, String>("1f" to "sadd")
    map3["2"] = "zxc"

//    Используя словарь из предыдущего задания, извлеките значение, используя ключ. Попробуй получить значение с ключом, которого в словаре нет.
    val map4 = map3["1f"]
    val map41 = map3["qwe"]

    val result = map3["1f"]
    if (result != null) {
        println(result)
    } else {
        println("Not found")
    }

//    Удалите определенный элемент из изменяемого словаря по его ключу.
    val map5 = mutableMapOf<String, String>("dssdf" to "sdsd", "vcvc" to "cvbcb")
    map5.remove("dssf")

//    Создайте словарь (ключи Double, значения Int) и выведи в цикле результат деления ключа на значение. Не забудь обработать деление на 0 (в этом случае выведи слово “бесконечность”)
    val map6: Map<Double, Int> = mapOf(2.33 to 323, 4.55 to 444, 4.55 to 21, 5.6 to 0)
    for ((key, value) in map6) {
        if (value == 0) {
            println("$key/$value = infinity")
        } else {
            println(key / value)
        }
    }

//    Измените значение для существующего ключа в изменяемом словаре.
//    map6[5.6] = 99
//    println(map5)


//    Создайте два словаря и объедините их в третьем изменяемом словаре через циклы.
    val map11 = mapOf("a" to 1, "b" to 2, "c" to 3)
    val map12 = mapOf("d" to 4, "e" to 5, "f" to 6)
    val newMap = mutableMapOf<String, Int>()
    for ((key1, value1) in map11) {
        newMap[key1] = value1
    }
    for ((key2, value2) in map12) {
        newMap[key2] = value2
    }
    println("new map: $newMap")


//    Создайте словарь, где ключами являются строки, а значениями - списки целых чисел. Добавьте несколько элементов в этот словарь.
    val map7 = mutableMapOf<String, MutableList<Int>>()
    map7["первый"] = mutableListOf(1, 2, 3)
    map7["второй"] = mutableListOf(4, 5)
    map7["третий"] = mutableListOf(6, 7, 8, 9)
    println(map7)


//    Создай словарь, в котором ключи - это целые числа, а значения - изменяемые множества строк. Добавь данные в словарь. Получи значение по ключу (это должно быть множество строк) и добавь в это множество ещё строку. Распечатай полученное множество.
    val map8 = mutableMapOf<Int, MutableSet<String>>()
    map8[1] = mutableSetOf("яблоко", "банан")
    map8[2] = mutableSetOf("кот", "пёс")
    map8[3] = mutableSetOf("красный", "синий")
    map8[2]?.add("test")
    println("Полный словарь: $map8")

//    Создай словарь, где ключами будут пары чисел. Через перебор найди значение у которого пара будет содержать цифру 5 в качестве первого или второго значения.
    val map = mapOf(
        Pair(1, 2) to "один-два",
        Pair(3, 4) to "три-четыре",
        Pair(5, 6) to "пять-шесть",
        Pair(7, 5) to "семь-пять",
        Pair(8, 9) to "восемь-девять"
    )
    for ((key, value) in map) {
        val (first, second) = key
        if (first == 5 || second == 5) {
            println("Пара $key содержит цифру 5 → значение: $value")
        }
    }

//    Задачи на подбор оптимального типа для словаря
//    Словарь библиотека: Ключи - автор книги, значения - список книг
    val library = mapOf(
        "Толстой" to listOf("Война и мир", "Анна Каренина"),
        "Достоевский" to listOf("Преступление и наказание", "Идиот")
    )

//    Справочник растений: Ключи - типы растений (например, "Цветы", "Деревья"), значения - списки названий растений
    val plants = mapOf(
        "Цветы" to listOf("Роза", "Тюльпан", "Ромашка"),
        "Деревья" to listOf("Дуб", "Берёза", "Сосна")
    )


//    Четвертьфинала: Ключи - названия спортивных команд, значения - списки игроков каждой команды
    val quarterFinal = mutableMapOf<String, MutableList<String>>()
    quarterFinal["Орлы"] = mutableListOf("Иванов", "Петров", "Сидоров")
    quarterFinal["Тигры"] = mutableListOf("Смирнов", "Кузнецов", "Попов")

//    Курс лечения: Ключи - даты, значения - список препаратов принимаемых в дату
    val treatment = mapOf(
        "2025-10-12" to listOf("Амоксициллин", "Парацетамол"),
        "2025-10-13" to listOf("Ибупрофен")
    )


//    Словарь путешественника: Ключи - страны, значения - словари из городов со списком интересных мест.
    val travelGuide = mutableMapOf<String, MutableList<String>>()
    travelGuide["Рим"] = mutableListOf("Колизей", "Фонтан Треви")
    travelGuide["Флоренция"] = mutableListOf("Дуомо", "Галерея Уффици")
    travelGuide["Токио"] = mutableListOf("Синдзюку", "Храм Мэйдзи")
    travelGuide["Рим"]?.add("Пантеон")
    travelGuide["Париж"] = mutableListOf("Эйфелева башня", "Лувр")
}