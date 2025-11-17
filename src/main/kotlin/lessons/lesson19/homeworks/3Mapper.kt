package ru.kotlin.lessons.lesson19.homeworks

// 3 Создай интерфейс Mapper с двумя дженериками, который будет определять методы для преобразования:
//элементов одного типа в элементы другого типа
//списка элементов одного типа в список элементов другого типа

interface `3Mapper`<F, T> {
    fun mapItem(item: F): T
    fun mapList(items: List<F>): List<T>
}
