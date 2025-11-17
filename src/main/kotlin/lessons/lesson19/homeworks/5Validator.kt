package ru.kotlin.lessons.lesson19.homeworks

interface Validator<T> {
    fun validate(item: T): Boolean
}
