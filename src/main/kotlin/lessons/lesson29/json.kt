package ru.kotlin.lessons.lesson29

import com.google.gson.Gson
import com.google.gson.GsonBuilder

data class Address(
    val street: String,
    val city: String,
    val postalCode: Int
)
data class User(
    val id: Int,
    val name: String,
    val isActive: Boolean,
    val address: Address
)

fun main() {
    // сериализация
    val address = Address("Baker Street", "London", 221)
    val user = User(1, "Sherlock Holmes", true, address)
    val gson = Gson() // Создаём экземпляр Gson
    val json = gson.toJson(user) // Сериализация объекта
    println("JSON: $json")

    // десериализация
    val json1 = """{"id":1,"name":"Sherlock Holmes","isActive":true,"address":{"street":"Baker Street","city":"London","postalCode":221}}"""
    val gson1 = Gson()
    val user1 = gson.fromJson(json, User::class.java) // Десериализация JSON в объект
    println("User: $user1")

    val gson2 = GsonBuilder()
        .setPrettyPrinting() // Для красивого форматирования JSON
        .serializeNulls() // Включить null-поля в JSON
        .create()
    val user2 = User(3, "Mary Morstan", false, Address("Fleet Street", "London", 123))
    val json2 = gson.toJson(user)
    println("Pretty JSON:\n$json2")
}