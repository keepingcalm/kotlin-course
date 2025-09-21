package ru.kotlin.homework

class class_homework {

    //val name: String = 'Summer'

    var age: Int = 30

    lateinit var phoneNumber: String /// переменная которая может быть определена позже

    fun example() {
        age = 31
    }

    fun example() {
        speed.dec()
    }

    var count: Int = 0
        get() {
            return if (field >100) field else 0
        }
        set (value) {
            if (value >= 0) field = value
        }
}

