package ru.kotlin.lessons.lesson19.homeworks

class ListValidator<T : Number> : Validator<List<T?>> {
    override fun validate(item: List<T?>): Boolean {
        if (item.any { it == null }) return false
        if (item.any { it!!.toDouble() == 0.0 }) return false
        return true
    }
}
