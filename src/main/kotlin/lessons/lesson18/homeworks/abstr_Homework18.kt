package ru.kotlin.lessons.lesson18.homeworks

import java.io.InputStream

interface Powerable {
    fun powerOn()
    fun powerOff()
}

interface Openable {
    fun open()
    fun close()
}

interface WaterContainer {
    val capacity: Int
    fun fillWater(amount: Int)
    fun getWater(amount: Int)
}

interface TemperatureRegulatable {
    val maxTemperature: Int
    fun setTemperature(temp: Int)
}

interface WaterConnection {
    fun connectToWaterSupply()
    fun getWater(amount: Int)
}

interface AutomaticShutdown {
    val sensorType: String
    val maxSensoredValue: Int
    fun startMonitoring()
}

interface Drainable {
    fun connectToDrain()
    fun drain()
}

interface Timable {
    fun setTimer(time: Int)
}

interface BatteryOperated {
    fun getCapacity(): Double
    fun replaceBattery()
}

interface Mechanical {
    fun performMechanicalAction()
}

interface LightEmitting {
    fun emitLight()
    fun completeLiteEmission()
}

interface SoundEmitting {
    fun setVolume(volume: Int)
    fun mute()
    fun playSound(stream: InputStream)
}

interface Programmable {
    fun programAction(action: String)
    fun execute()
}

interface Movable {
    fun move(direction: String, distance: Int)
}

interface Cleanable {
    fun clean()
}

interface Rechargeable {
    fun getChargeLevel(): Double
    fun recharge()
}

// Задача 1. Создай абстрактные классы устройств, используя эти интерфейсы. Реализовывать методы не нужно.
//Холодильник
abstract class Fridge : Powerable, Openable, TemperatureRegulatable, Drainable, LightEmitting, SoundEmitting,
    Programmable

// Стиральная машина
abstract class WashingMachine : Powerable, Openable, WaterContainer, TemperatureRegulatable, WaterConnection, Drainable,
    SoundEmitting, Programmable, Cleanable

// Умная лампа
abstract class SmartLamp : Powerable, LightEmitting, Programmable

// Электронные часы
abstract class ElectronicWatch : Powerable, LightEmitting, SoundEmitting, Programmable, Rechargeable

// Робот-пылесос
abstract class RobotVacuum : Powerable, Openable, SoundEmitting, Programmable, Movable, Cleanable, Rechargeable

// Механические часы
abstract class MechaWatch : Mechanical, Timable

// Фонарик
abstract class Torch : Powerable, BatteryOperated, LightEmitting

// Кофемашина
abstract class CoffeeMachine : Powerable, Openable, WaterContainer, TemperatureRegulatable, AutomaticShutdown,
    Drainable, Timable, SoundEmitting, Cleanable

// Умная колонка
abstract class Alexa : Powerable, LightEmitting, SoundEmitting, Programmable, Rechargeable

//Задача 2. Создай абстрактный класс для включаемого оборудования и имплементируй соответствующий интерфейс с реализацией методов (достаточно println с выполняемым действием).

abstract class SwitchableDevices(val name: String) : Powerable {
    private var deviceState: Boolean = false

    override fun powerOn() {
        deviceState = true
        println("$name включено.")
    }

    override fun powerOff() {
        deviceState = false
        println("$name выключено.")
    }

    protected fun getDeviceState() = deviceState
}

//Задача 3. Создай абстрактный класс для программируемого оборудования (с имплементацией соответствующего интерфейса и реализацией методов) и наследуй его от абстрактного класса включаемого оборудования.

abstract class ProgrammableDevices(val arg: String, name: String) :
    SwitchableDevices(name), Programmable {

    private var currentAction: String? = null

    override fun programAction(action: String) {
        currentAction = action
        println("$name: действие \"$action\" запрограммировано.")
    }

    override fun execute() {
        if (currentAction != null) {
            println("$name выполняет действие: \"$currentAction\".")
        } else {
            println("$name: действие не задано.")
        }
    }

    protected fun currentDeviceAction() = currentAction
}

//Задача 4. Создай абстрактный класс оборудования с возможностью устанавливать температуру и открываться и с наследованием от программируемого оборудования. Также имплементируй интерфейсы.

abstract class ThermalDevice(
    name: String,
    arg: String,
    override val maxTemperature: Int
) : ProgrammableDevices(arg, name), TemperatureRegulatable, Openable {

    private var currentTemp: Int = 20
    private var isOpen: Boolean = false

    override fun setTemperature(temp: Int) {
        if (temp <= maxTemperature) {
            currentTemp = temp
            println("$name: температура установлена на $temp°C.")
        } else {
            println("$name: невозможно установить $temp°C — превышен максимум $maxTemperature°C!")
        }
    }

    override fun open() {
        if (!isOpen) {
            isOpen = true
            println("$name открыто.")
        } else {
            println("$name уже открыто.")
        }
    }

    override fun close() {
        if (isOpen) {
            isOpen = false
            println("$name закрыто.")
        } else {
            println("$name уже закрыто.")
        }
    }
}

