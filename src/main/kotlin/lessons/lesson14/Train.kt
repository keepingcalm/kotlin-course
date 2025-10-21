package ru.kotlin.lessons.lesson14

import javax.annotation.processing.Messager

class Train(val engineType: String) {
    val carriages = mutableListOf<Carriage>()
    fun boardPassenger(
        passenger: Passenger,
        seat: Int,
        carriageType: String
    ) {
        // логика для размещения пассажира
    }
}

