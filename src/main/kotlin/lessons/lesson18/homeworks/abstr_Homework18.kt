package ru.kotlin.lessons.lesson18.homeworks

import java.io.InputStream
import java.security.Signer

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
abstract class Fridge: Powerable, Openable, TemperatureRegulatable, Drainable, LightEmitting, SoundEmitting, Programmable, Cleanable
// Стиральная машина
abstract class WashingMachine: Powerable, Openable, WaterContainer, TemperatureRegulatable, WaterConnection, AutomaticShutdown, Drainable, Timable, SoundEmitting, Programmable, Cleanable
// Умная лампа
abstract class SmartLamp: Powerable, AutomaticShutdown, Timable, LightEmitting, Programmable, Cleanable
// Электронные часы
abstract class ElectronicWatch: Powerable, Openable, Timable, BatteryOperated, LightEmitting, SoundEmitting, Programmable, Rechargeable, Cleanable
// Робот-пылесос
abstract class RobotVacuum: Powerable, Openable, AutomaticShutdown, Timable, BatteryOperated, SoundEmitting, Programmable, Movable, Cleanable, Rechargeable