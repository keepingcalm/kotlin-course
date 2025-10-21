package ru.kotlin.lessons.lesson14

import java.time.LocalDate
import java.time.Period

fun main() {
    val lamp = tableLamp(shine = true)
    lamp.toggle()
    lamp.toggle()

    val wind = Wind(5)
    wind.convertSpeed()

//    val reservedSeatCarriage = Carriage(48)
//    val compartmentCarriage = Carriage(16, "Купе")
//    val train = Train("Electric locomotive")
//    train.carriages.add(reservedSeatCarriage)
//    train.carriages.add(compartmentCarriage)
//    val passengerAlexandr = Passenger("Alexandr", "02.10.1983", "")
//    train.boardPassenger(passengerAlexandr, 10, "Купе")
//
//    Logger.log("dsdsds")
//    val result = Calculator.add(5, 3)
//    println("Result: $result")
//
//    val user1 = User(1, "Alice")
//    val user2 = user1.copy(name = "Bob")
}

object Logger {
    fun log(message: String) {
        println("Log: $message")
    }
}

class Calculator() {
    companion object {
        fun add(a: Int, b: Int): Int {
            return a + b
        }
    }
}

data class User(val id: Int,val name: String)