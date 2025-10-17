package ru.kotlin.lessons.lesson13

fun main() {
    val fruitPrices = mapOf("apple" to 0.3, "banana" to 2.99, "melon" to 3.99)

    for (entry in fruitPrices) {
        println("Key ${entry.key}, Value: ${entry.value}")
    }

    for ((key, value) in fruitPrices) {
        println("Key: $key, Value: $value")
    }

    val entrie: Set<Map.Entry<String, Double>> = fruitPrices.entries
    val key = fruitPrices.keys
    val value = fruitPrices.values
    println(entrie)
    println(key)
    println(value)

    val entries = fruitPrices.entries
    val keys: Set<String> = fruitPrices.keys
    val values: Collection<Double> = fruitPrices.values
    println(entries)
    println(keys)
    println(values)

    val priceOfPearOrElse = fruitPrices.getOrElse("pear") { 9999.9 }
    val priceOfApple = fruitPrices.getValue("apple")
    val priceOfPearOrDefault = fruitPrices.getOrDefault("pear", 0.0)

    val fruitswithoutbanana = fruitPrices - "banana" // создание нов словаря без банана
    val fruitswithPineapple = fruitPrices + ("pineapple" to 7.33) // создание нов словаря c ананасом
    val mutableFruits = fruitPrices.toMutableMap() // создаст новый измен словарь
    mutableFruits["kiwi"] = 2.75 // добавление
    mutableFruits.putAll(mapOf("lime" to 1.22, "avocado" to 11.22)) // добавлеине словаря
    mutableFruits + mapOf("lime" to 1.11, "avocado" to 1.54) // не добавляет словарь, а соединяет
    mutableFruits.remove("apple") // remove element
    mutableFruits.clear() // очистка словаря

    val contapple = fruitPrices.containsKey("apple")
    val con = fruitPrices.containsValue(1.5)
    val empty = fruitPrices.isEmpty()
    val nempty = fruitPrices.isNotEmpty()
    val aa = fruitPrices.all { it.value < 1.0 }
    val isany = fruitPrices.none { it.value < 1.0 }

    val fil1 = fruitPrices.filter { it.value > 1.0 && it.key.startsWith("e") }
    val fil2 = fruitPrices.filterKeys { it.startsWith("a") }
    val fil3 = fruitPrices.filterValues { it < 2.0 }
    val fi4 = fruitPrices.filterNot { it.key == "apple" }
    val fil5 = fruitPrices.count { it.value > 1.5 }

    val increasedPrice = fruitPrices.mapValues { "${it.value * 1.1}" }
    val upper = fruitPrices.mapKeys { it.key.uppercase() }
    val list = fruitPrices.map { "${it.key} costs ${it.value}" }

    val toMap = mutableFruits.toMap()
    val toMutableMap = fruitPrices.toMutableMap()

    fruitPrices.forEach { (fruit, price) ->
        println("$fruit costs $price")
    }

    fruitPrices.forEach {
        println("${it.key} costs ${it.value}")
    }

    fruitPrices.size
    fruitPrices.count()
    fruitPrices.count { it.value > 2 } // кол-во ключей если сначала применить фильтрацию по условию

    val food = mapOf(
        "Овощи" to listOf("Картофель", "Морковь", "Лук"),
        "Фрукты" to listOf("Яблоки", "Груши", "Апельсины"),
        "Ягоды" to listOf("Виноград", "Клубника", "Голубика"),
        "Орехи" to listOf("Арахис", "Фундук", "Макадамия"),
        "Зелень" to listOf(),
    )

    val veg = food["Овощи"]

    for ((key, value) in food) {
        println("Это тип $key, содержит $value")
    }

    food.forEach { _ -> println("Это тип $key, содержит $value") }

    val a2: List<String> = food.getValue("Фрукты")

    val a3: List<String> = food.getOrDefault("Крупы", listOf())

    val a4: List<String> = food.getOrElse("Рыба") {
        println("Не найдено")
        listOf()
    }

     if (!food.containsKey("Мясо") && !food.containsKey("Рыба")) {
         println("Еда для вегетарианцев")
         }

    val a5 = food.map{"Это тип $key, содержит $value"}
}

