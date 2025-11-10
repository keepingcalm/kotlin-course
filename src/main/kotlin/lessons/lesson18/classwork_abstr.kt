package ru.kotlin.lessons.lesson18

interface PowerableDevice {
    fun turnOn()
    fun turnOff()
}

interface Openable {
    fun open ()
    fun close ()
}

// чайник

abstract class Kettle: PowerableDevice, Openable

fun closeList (list: List<Openable>) {
    list.forEach {
        it.close()
    }
}