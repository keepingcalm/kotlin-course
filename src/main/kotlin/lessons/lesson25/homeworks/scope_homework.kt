package ru.kotlin.lessons.lesson25.homeworks

//Задание 1. Функция высшего порядка.
//Создайте функцию timeTracker, которая принимает другую функцию в качестве аргумента и измеряет время её выполнения.
// Функция timeTracker должна возвращать затраченное время в миллисекундах.
// Для измерения времени используйте System.currentTimeMillis() до и после выполнения переданной функции.

fun ex1(block: () -> Unit): Long {
    val start = System.currentTimeMillis()
    block()
    val end = System.currentTimeMillis()
    return end - start
}

// 2 Задания для работы со scope функциями
//Давайте создадим два класса, которые будут использоваться в заданиях для демонстрации работы scope функций с преобразованием объектов
// и инициализацией или обновлением полей.
// Классы будут представлять собой Person и Employee, где Employee может быть создан на основе данных класса Person.

//Классы для выполнения заданий

class Person(val name: String, val age: Int) {
    var email: String = ""
}

class Employee(val name: String, val age: Int, val position: String) {
    var email: String = ""
    var department: String = "General"
}

//Задание 3: Использование also для логирования
//Создайте функцию, принимающую объект Person и выводящую информацию об объекте в консоль в красивом, отформатированном виде.
// Используй with для создания контекста Person и возможности использовать поля объекта напрямую без обращения к переменной.

fun logPerson(person: Person) = person.also {
    with(it) {
        println()
    }
}

//Задание 6: Использование let для безопасного преобразования Person в Employee
//
//Создайте функцию toEmployee, которая расширяет класс Person, который может быть null.
// В функции используйте функцию let для создания Employee, только если объект Person не null.
// В противном случае возвращается null

fun Person?.toEmployee(position: String): Employee? {
    return this?.let { person ->
        Employee(person.name, person.age, position).apply {
            email = person.email
            department = "General"
        }
    }
}

fun main() {
    val myFunction = {
        val list = List(10000000) { (0..10000).random() }
        list.sorted()
    }

//Задание 2: Использование apply для инициализации объекта Employee

    val person = Person("Olga", 18).apply {
        email = "olga18@gmail.com"
    }

    val employee = Employee(person.name, person.age, "QA_test").apply {
        email = person.email
        department = "Development"
    }

    val person1 = Person("Kitty", 33)
        .also { it.email = "33_kitty@gmail.com" }
        .also { logPerson(it) }

    logPerson(person)

    println(person1)
    println(person)
    println(employee)


//Задание 4: Использование with для преобразование Person в Employee
//
//Создайте объект класса Person. Используйте функцию with, чтобы создать из этого объекта Employee, указав дополнительно должность.
// Возвращаемым значением должен быть новый объект Employee.

    val employee1 = with(person) {
        Employee(name, age, "QA_engineer").apply {
            email = this@with.email
            department = "IT"
        }
    }

//Задание 5: Использование run для преобразования и инициализации Employee
//
//Перепиши предыдущую задачу на использование run вместо with.

    val employee2 = person.run {
        Employee(name, age, "Developer").apply {
            email = this@run.email
            department = "IT"
        }
    }
}
