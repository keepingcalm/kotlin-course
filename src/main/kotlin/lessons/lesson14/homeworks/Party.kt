package ru.kotlin.lessons.lesson14.homeworks

class Party(val location: String, val attendees: Int) {
    fun details() {
        println("The party is at $location with $attendees attendees.")
    }
}
fun main() {
    val party = Party("Beach House", 20)
    party.details()  // The party is at Beach House with 20 attendees.
}