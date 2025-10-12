package ru.kotlin.lessons.lesson11

fun main(){
    sayHello()
    greetUser("Olga")
    val r = sum(4,2)
    println(r)
    println(sum(3,4))
    println(printSum(5,7))
    println(a6(4,7))
}

//fun nameFun(parameters): TypeReturnValue {
//    // body fun
//    return value
//
//    fun nameFun(parameters): Unit {
//        // body fun функция ничего не возвращает
//}

    fun sayHello() {
    println("Hello, world!")}

fun greetUser (name: String) {
    println("Hello, $name")
}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun printSum(a: Int, b: Int): Unit {
    println("Sum of $a and $b is ${a + b}")
}

fun multiply(a: Int, b: Int): Int {
    return a * b
}

fun multiplyOneString(a: Int, b: Int): Int = a * b

private fun calculateDiscount(price: Double): Double {
    return price * 0.1
}

fun finalPrice(price: Double): Double {
    val discount = calculateDiscount(price)
    return price - discount
}

fun findValue(numbers: List<Int>, target: Int): String {
    for (number in numbers) {
        if (number == target) {
            println("Value found: $number")
            return "sdsd"
        }
    }
    println("Value not found")
    return "sdafg"
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}


fun a1 () {

}

fun a2 (): String {
    return "sdsd"
}

fun a3 (a: String) {

}

fun a4(a: Double, s: Double): Double {
    return a / s
}

fun a5(a: String?): Boolean {
    return false
}

fun a6(a: Int, f: Int): Int {
    return a + f
}

fun a7(y: Int, p: Int): Int {
    return if (y > p) {
        y
    } else p
}

fun a8(t: List<Int>) {
    for (i in t) {
        if (i > 0 ) {
            println(i)
        } else if (i == 0) {
            println("Zero")
        }  else return
    }
}

fun a9(string: MutableList<String>,goal: String) {
    for (i in string.indices) {
        if (string[i].contains(goal)) {
            string[i] = string[i].replace(goal,goal.uppercase())
            return
        }
    }
}

//Напишите функцию replaceString, которая принимает список строк и искомую строку. Функция должна перебрать список и заменить первое вхождение искомой строки на её версию в верхнем регистре, после чего завершить выполнение с помощью return без возврата значения.
fun a10(numbers: List<Int>) {
    for (i in numbers) {
        println(i)
        if (i % 2 == 0) {
            println("Чётное число найдено")
            return
        }
    }
}

//Создайте функцию findFirstEvenNumber, которая принимает список целых чисел. Функция должна выводить каждый номер. При нахождении первого чётного числа она должна вывести сообщение "Чётное число найдено" и завершить выполнение с помощью return без возврата значения.
fun a11(a: Map<String, Double>) : Double {
    var sum = 0.0
    for ((key,value) in a) {
        sum += if (value < 0) {
           0 - value
        }  else {
            value
        }
    }
    return sum
}