package ru.kotlin.lessons.lesson21

import kotlin.math.absoluteValue


fun main1() {

    val obj: Any = "Hello, World!"

    if (obj is String) {
        obj.length
        println("Объект является строкой")
    }
    if (obj !is Int) {
        println("Объект не является целым числом")
    }

//    val num1: Any = 123
//    val str: String = num1 as String // Выбросит ClassCastException
//
//    val num: W1 = W3()
//    val str: W2 = num as W2 //
//    val safeStr: String? = num as? String // safeStr ьулет равно null
}

interface W1 {}
interface W2 {}

class W3 : W1, W2

interface Drivable {
    fun drive()
}

interface Flyable {
    fun fly()
}

open class Car : Drivable {

    override fun drive() {
        println("Едет как автомобиль")
    }
}

class FlyingCar : Car(), Flyable {

    override fun fly() {
        println("Летит как самолёт")
    }
}

fun checkCapabilitiesWithSmartCast(drivable: Drivable) {
    drivable.drive()
    if (drivable is Flyable) {
        drivable.fly()
    } else {
        println("Этот объект не может летать.")
    }
}

fun checkCapabilities(drivable: Drivable) {
    drivable.drive()
    (drivable as? Flyable)?.fly() ?: println("Этот объект не может летать.")
}

fun main() {
    val car = Car()
    checkCapabilities(car)

    val flyingCar = FlyingCar()
    checkCapabilities(flyingCar)

    val arg: Any = "String"
    println((arg as String).length)
    //println(arg as Int)
    if (arg is String) {
        println(arg)
    } else {
        println("This is not a string")
    }

    println(arg as? String ?: "This is not a string")

    val arg1: Any = listOf("wads")
    //println(arg1 as List<String>)
    //println((arg1 as List<Int>)[0].absoluteValue)
//    if (arg1 is List<*>) {
//    println(arg1)
//    } else {
//        println("Smth")
//    }
//    if ((arg1 as List<*>).isNotEmpty() && arg1[0] is String) {
//        println(arg1[0])
//    }

    println((arg1 as? List<*>)?.getOrNull(0) as? String ?: "This is not a string")
}

fun tryMultiple1(arg3: Any): Int? {

    if (arg3 is Int) {
        return arg3 * 2
    } else if (arg3 is String) {
        return arg3.toInt() * 2
    } else {
        return null
    }


}

fun tryMultiple2(arg4: Any): Int? {
    return (arg4 as? Int)?.times(2) ?: (arg4 as? String)?.toIntOrNull()?.times(2)
}