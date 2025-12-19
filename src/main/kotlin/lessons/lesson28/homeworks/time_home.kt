package ru.kotlin.lessons.lesson28.homeworks

import ru.kotlin.lessons.lesson27.Tech
import java.time.LocalTime
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.Period
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoField
import java.time.temporal.Temporal

fun main() {

//1 Создай текущую метку времени и выведи её на печать (чтобы ещё раз запомнить название этого класса)
    val ex1 = Instant.now()
    println(ex1) // 2025-12-18T14:32:24.274046Z

// 2 Создай дату своего дня рождения.
    val ex2 = LocalDate.of(1988, 8, 23)
    println(ex2) // 1988-08-23

// 3 Создай период между датой своего рождения и текущей датой. Выведи на печать количество лет из этого периода.
    val ex3 = Period.between(ex2, LocalDate.now())
    println(ex3) //  P37Y3M25D
    println(ex3.years) //  37


// 7 Создай два объекта даты: 25 февраля 2023 года и 25 февраля 2024 года. Создай форматтер, который форматирует дату в месяц и день.
    val ex71 = LocalDate.of(2023, 2, 25)
    val ex72 = LocalDate.of(2024, 2, 25)
    val formatter7 = DateTimeFormatter.ofPattern("MM - dd")
// 8 Выведи первую отформатированную дату, прибавив к ней 10 дней.
    println(ex71.plusDays(10).format(formatter7))
// 9  Выведи вторую отформатированную дату, прибавив к ней 10 дней. Найди отличия)))
    println(ex72.plusDays(10).format(formatter7)) // високосный год

    val dates6 = listOf(
        LocalDate.of(1946, 1, 1),   // начало бумеров
        LocalDate.of(1964, 12, 31), // конец бумеров
        LocalDate.of(1997, 1, 1),   // начало зумеров
        LocalDate.of(2012, 12, 31), // конец зумеров
        LocalDate.of(1985, 8, 23)   // вне диапазонов
    )

    dates6.forEach {
        println("$it → ${it.identifyGeneration()}")
    }

}

// 4 Создай функцию, которая принимает тип Temporal и выводит форматированное значение в зависимости от того, содержит ли аргумент время и часовой пояс.
// Temporal - это общий тип для разных классов даты-времени.
// В форматированном значении нужно выводить часы, минуты, секунды и таймзону, если они представлены в переданном объекте.
// Обработай в методе все типы дат, которые знаешь.
// Реализуй два варианта функции - с собственный форматированием и с форматами из ISO коллекции

fun ex4(temporal: Temporal): String {
    return when (temporal) {
        is LocalDate -> "dd-MM-YYYY"
        is LocalTime -> "HH:mm:ss"
        is LocalDateTime -> "dd-MM-YYYY HH:mm:ss"
        is ZonedDateTime -> "dd-MM-YYYY HH:mm:ss z"
        is OffsetDateTime -> "dd-MM-YYYY HH:mm:ss ZZZ"
        else -> throw IllegalArgumentException("Неизвестный тип данных")
    }.let {
        DateTimeFormatter.ofPattern(it).format(temporal)
    }.also { println(it) }
}


// 6 Создайте функцию identifyGeneration, которая расширяет класс LocalDate и печатает строку, определяющую,
// к какому поколению принадлежит человек родившийся в эту дату:
// "Бумер" для тех, кто родился с 1946 по 1964 год включительно, и
// "Зумер" для тех, кто родился с 1997 по 2012 год включительно.
// Если дата рождения не попадает ни в один из этих диапазонов, функция должна печатать "Не определено".
// Для сравнения дат используй методы isAfter(otherDate) и isBefore(otherDate) или проверку вхождения в диапазон.
// Объекты с эталонными датами вынеси в приватные поля файла с методом identifyGeneration.

fun LocalDate.identifyGeneration(): String =
    when (year) {
        in 1946..1964 -> "Бумер"
        in 1997..2012 -> "Зумер"
        else -> "Не определено"
    }