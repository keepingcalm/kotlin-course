package ru.kotlin.lessons.lesson22.homeworks

// Задание 9. Оберни все вызовы из предыдущего задания в блок try-catch и создай для каждого типа ошибки свой catch блок

// NullPointerException
fun throwNPE() {
    val s: String? = null
    println(s!!.length)
}

// IndexOutOfBoundsException
fun throwIOOBE() {
    val list = listOf(1, 2, 3)
    println(list[5])
}

// ClassCastException
fun throwCCE() {
    val any: Any = 123
    val s = any as String
}

// IllegalArgumentException
fun throwIAE() {
    require(false) { "Неверный аргумент" }
}

// NumberFormatException
fun throwNFE() {
    "abc".toInt()
}

// IllegalStateException
fun throwISE() {
    check(false) { "Состояние неверное" }
}

// OutOfMemoryError (делать осторожно!)
fun throwOOM() {
    val hugeList = MutableList(Int.MAX_VALUE) { 0 }
}

// StackOverflowError (тоже осторожно!)
fun throwSOE(): Int {
    return 1 + throwSOE()
}

fun testAllExceptions() {
    try {
        throwNPE()
        throwIOOBE()
        throwCCE()
        throwIAE()
        throwNFE()
        throwISE()
        throwOOM()
        throwSOE()
    } catch (e: NullPointerException) {
        println("Перехват: NullPointerException")
    } catch (e: IndexOutOfBoundsException) {
        println("Перехват: IndexOutOfBoundsException")
    } catch (e: ClassCastException) {
        println("Перехват: ClassCastException")
    } catch (e: IllegalArgumentException) {
        println("Перехват: IllegalArgumentException")
    } catch (e: NumberFormatException) {
        println("Перехват: NumberFormatException")
    } catch (e: IllegalStateException) {
        println("Перехват: IllegalStateException")
    } catch (e: OutOfMemoryError) {
        println("Перехват: OutOfMemoryError")
    } catch (e: StackOverflowError) {
        println("Перехват: StackOverflowError")
    }
}


// Задание 10. Напиши функцию, которая принимает nullable аргумент типа Any
// и в блоке try/catch выполни набор действий с этим аргументом которые могут потенциально вызвать одно из исключений в этом же порядке:

//NullPointerException
//IndexOutOfBoundsException
//ClassCastException
//IllegalArgumentException
//NumberFormatException
//IllegalStateException
//В блоке catch перехватывай исключение с общим типом Throwable а внутри через when определи тип исключения и выведи сообщение с названием исключения.
//Сразу после when выброси перехваченное исключение через throw, чтобы прекратить работу программы. Если аргумент функции не вызвал исключение,
//то выведи текст, сообщающий что переданный аргумент фантастически хорош!

fun analyzeArgument(arg: Any?) {
    try {
        // NullPointerException
        val len = arg!!.toString().length

        // IndexOutOfBoundsException
        val list = listOf(1, 2)
        println(list[10])

        // ClassCastException
        val s: String = arg as String

        // IllegalArgumentException
        require(arg != "bad") { "Плохой аргумент" }

        // NumberFormatException
        "abc".toInt()

        // IllegalStateException
        check(arg != 0) { "Нельзя быть нулём" }

        println("Аргумент фантастически хорош!")
    } catch (e: Throwable) {
        when (e) {
            is NullPointerException -> println("NullPointerException")
            is IndexOutOfBoundsException -> println("IndexOutOfBoundsException")
            is ClassCastException -> println("ClassCastException")
            is IllegalArgumentException -> println("IllegalArgumentException")
            is NumberFormatException -> println("NumberFormatException")
            is IllegalStateException -> println("IllegalStateException")
            else -> println("Неизвестное исключение: ${e::class.simpleName}")
        }
        throw e
    }
}

//Задание 11. Создай свой тип исключения в отдельном файле, наследуемый от AssertionError и принимающий текст. Выброси это исключение в main

class MyAssertionException(message: String) : AssertionError(message)


fun main() {
    // throw MyAssertionException("Моё собственное AssertionError исключение!")

//Задание 12. Создай свой тип исключения в отдельном файле, наследуемый от RuntimeException и принимающий IndexOutOfBoundsException тип в качестве аргумента.
// Напиши код, который спровоцирует выброс IndexOutOfBoundsException,
// перехвати его с помощью try-catch и в блоке catch выведи сообщение в консоль и сделай выброс своего типа исключения.
    try {
        listOf("")[1]
    } catch (e: IndexOutOfBoundsException) {
        println("Произошёл IndexOutOfBoundsException")
        throw MyRuntimeException(e)
    }
}


