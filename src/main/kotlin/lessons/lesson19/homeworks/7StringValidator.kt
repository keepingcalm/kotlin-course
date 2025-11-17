package ru.kotlin.lessons.lesson19.homeworks

class StringValidator : Validator<String?> {
    override fun validate(item: String?): Boolean {
        return item != null && item.isNotBlank()
    }
}
