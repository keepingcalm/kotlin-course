package ru.kotlin.lessons.lesson15

// Основной класс Транспортное средство
open class Vehicle(
    val maxWeight: Int,
    val passengerCapacity: Int,
    val serialNumber: String
) {
    open fun startMovement() {
        println("Транспортное средство начало движение.")
    }
    open fun stopMovement() {
        println("Транспортное средство остановлено.")
    }
}

// Класс Колёсное транспортное средство, наследующийся от Транспортного средства
open class WheeledVehicle(
    maxWeight: Int,
    passengerCapacity: Int,
    serialNumber: String,
    val wheelCount: Int
) : Vehicle(maxWeight, passengerCapacity, serialNumber)
// Класс Автомобиль, наследующийся от Колёсного транспортного средства
class Car(
    maxWeight: Int,
    passengerCapacity: Int,
    serialNumber: String,
    wheelCount: Int,
    val engineType: String,
    val bodyType: String
) : WheeledVehicle(maxWeight, passengerCapacity, serialNumber, wheelCount) {
    fun turnOnLights() {
        println("Габариты включены.")
    }
    fun turnOffLights() {
        println("Габариты выключены.")
    }
    fun activateTurnSignal(direction: String) {
        println("Поворотник включен: $direction")
    }
    fun activateWipers() {
        println("Стеклоочистители включены.")
    }
}

