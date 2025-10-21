package ru.kotlin.lessons.lesson14

class Wind(private var speed: Int) {

    fun convertSpeed(): Double {//конвертим км/ч в м/с
        return speed / 3.6
    }

    fun setSpeed (speed: Int) {
        if (speed < 0 ) {
            return
        } else {
            this.speed = speed
        }
    }

    fun print() {
        print("Текущая скорость: $speed м/с")
    }
}