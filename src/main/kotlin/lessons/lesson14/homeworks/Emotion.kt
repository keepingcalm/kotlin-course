package ru.kotlin.lessons.lesson14.homeworks

class Emotion(val type: String, val intensity: Int) {
    fun express() {
        println("Feeling $type with intensity level $intensity.")
    }
}
fun main() {
    val emotion = Emotion("happiness", 8)
    emotion.express()  // Feeling happiness with intensity level 8.
}