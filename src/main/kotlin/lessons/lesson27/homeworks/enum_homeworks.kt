package ru.kotlin.lessons.lesson27.homeworks

import ru.kotlin.lessons.lesson27.homeworks.SolarSystem.entries

// 1 Создай Enum со статусами прохождения теста (passed, broken, failed).
enum class Statuses {
    PASSED,
    BROKEN,
    FAILED,
    ;

// 3 Создай функцию, которая принимает лямбду без аргументов и возвращаемого значения и возвращает Enum
// со статусом прохождения теста в зависимости от того как выполнится принятая лямбда:
//если без исключений - PASSED
//если будет AssertionError - FAILED
//прочие исключения  - BROKEN

    companion object {
        fun ex3(arg: () -> Unit): Statuses {
            return try {
                arg()
                Statuses.PASSED
            } catch (a: AssertionError) {
                Statuses.FAILED
            } catch (b: Throwable) {
                Statuses.BROKEN
            }
        }
    }
}

// 1 Создай Enum с типами жилой недвижимости для сайта аренды, включая человекопонятные названия этих типов.

enum class TypeProperty(val displayName: String) {
    FLAT("kvartira"),
    HOUSE("dom"),
    APARTMENT("apartamenty"),
    ROOM("komnata"),
    DORMITORIES("hostel"),
    ;

    // 2 Создай функцию, которая выводит на печать человекочитаемые названия типов недвижимости в порядке возрастания длины названия enum.
    companion object {
        fun ex2() {
            entries
                .sortedBy { it.name.length }
                .forEach { println(it.name) }
        }
    }
}

// 1 Создай Enum с планетами солнечной системы, включая расстояние до солнца в астрономических единицах и вес планеты.

enum class SolarSystem(val distanceToTheSunInMlnKm: Int, val planetMassInEarthMass: Double) {
    MERCURY(58, 0.055),
    VENUS(108, 0.815),
    EARTH(150, 1.0),
    MARS(228, 0.107),
    JUPITER(778, 318.0),
    SATURN(1429, 95.0),
    URANUS(2875, 14.5),
    NEPTUNE(4497, 17.0),
    ;

//Создай функцию, которая принимает лямбду и возвращает enum планеты.
// Лямбда должна принимать планету и возвращать булево значение.
// Лямбда здесь выступает в качестве фильтра,
// который должен отфильтровать список всех планет по какому-либо признаку (расстояние или вес).
// Вернуть нужно первый элемент из отфильтрованного списка или выкинуть исключение если список пустой.

}

fun ex4(arg: (SolarSystem) -> Boolean): SolarSystem {
    return entries
        .firstOrNull(arg)
        ?: throw NoSuchElementException("No planet matches the filter")
}

fun main() {
    TypeProperty.ex2()

    val ok = Statuses.ex3 {
        println("Тест прошёл")
    }
    println(ok)
    val failed = Statuses.ex3 {
        assert(false)
    }
    println(failed)
    val broken = Statuses.ex3 {
        error("Что-то пошло не так")
    }
    println(broken)

    val planet4 = ex4 { it.planetMassInEarthMass > 100 }
    println("This planet is kinda heavy: $planet4")

    val planet41 = ex4 { it.distanceToTheSunInMlnKm > 2000 }
    println("This is kinda distant planet from Sun: $planet41")

//    val planet42 = ex4 { it.distanceToTheSunInMlnKm > 200000 }
//    println("This is the most distant planet from Sun: $planet42")
}




