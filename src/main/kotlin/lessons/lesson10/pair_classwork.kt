package ru.kotlin.lessons.lesson10

import java.io.StringReader

fun main () {

    val pair = 1 to "a"

    val emptyMap: Map<String, Int> = mapOf( "adsada" to 1)

    val capitals: Map<String, String>  = mapOf("Russia" to "Moscow", "France" to "Paris")
    val map: Map<Int, String> = mapOf(1 to "a", 2 to "v", 3 to "f")

    val mutableCapitals: MutableMap<String, String> = mutableMapOf("Russia" to "Moscow", "France" to "Paris")

    mutableCapitals["German"] = "Berlin" // новая пара ключ/значение создастся
    mutableCapitals["German"] = "Berlin21" // отредактируется значение для ключа, который уже существует, тк ключи уникальны
    mutableCapitals.remove("France") // удаляет и ключ и значение сразу

    val capitalsOfRussia = capitals["Russia"] // get по ключу - то есть получаем тоже ключ значение
    println(capitalsOfRussia)

    for ((country, capital) in capitals) {
        println("$country: $capital")
    }

    if ("Russia" in capitals) {
        println("Capital of Russia: ${capitals["Russia"]}")
    }

    val mapWithNullableKey = mutableMapOf<String?, Int>(null to 1)

    val map4 = mutableMapOf("a" to 1, "v" to 1, "s" to 3) // ключи всегда уникальные, значения могут быть неуникальными

    val a2 = mapOf<String, Int>()
    val a3 = mapOf<String, Int>("string" to 1, "string2" to 2)
    val a4 = mutableMapOf<String, String>("vot" to "tak", "vot2" to "tak2")
    a4["vot3"] = "tak3"
    a4.remove("vot2")

    for ((country, capital) in a3) {
        println("$country, а столица $capital")
    }
    a4["vot4"] = "tak4"
    mapKey(a4,"vot4")
    if ("vot4" in a4) {
        println(a4["vot4"])
    } else println("key not found")
    //График работы сотрудников: ключи - это дни недели, а значения - списки сотрудников, работающих в каждый день. График составляется на короткий период и не подразумевает изменения.
    val workSchedule = mapOf<String, MutableList<String>>()
    // Учебный план: ключи - это названия предметов, а значения - списки доступных курсов и их описаний.
    val studyPlan = mapOf<String, MutableList<String>>()
    // Контакты в телефонной книге: ключи - это имена контактов, а значения - список данных контакта (например, номер телефона, адрес электронной почты).
    val phoneBook = mutableMapOf<String, MutableMap<String, String>>()
    phoneBook["Sergey"] = mutableMapOf("Phone number" to "231381931")
    phoneBook["Sergey"]?.put("email", "sdasd@sda.com")

}

fun mapKey(map: Map<String, String>, key: String) {
    for ((k, v) in map) {
        if (key == k) {
            println(v)
            return
        }
    }
    println("Not found")
}
