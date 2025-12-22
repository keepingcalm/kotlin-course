package ru.kotlin.lessons.lesson29.homeworks

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File

enum class CharacterTypes {
    CTO,
    UX_UI,
    CRM, // Customer Relationship Manager
    FRONTEND_DEV,
    TEAM_LEAD,
    BACKEND_DEV,
    PM,
    SYSADMIN,
    QA
}

// 1 Создай дата класс сотрудника компании Employee, содержащий:
//имя
//статус трудоустройства (булево)
//дата рождения (строка)
//должность CharacterTypes
//список подчинённых с типом Employee

data class Employee(
    val name: String,
    val isEmployed: Boolean,
    val birthDate: String,
    val position: CharacterTypes,
    val subordinates: List<Employee> = emptyList()
)

// 2 Создай объекты рабочей группы так, чтобы у CTO был PM и CRM,
// у PM было два тим-лида (на фронт и бэк) и у каждого было по группе сотрудников подходящего для его стека профиля.

val frontendDev1 = Employee(
    name = "Anna",
    isEmployed = true,
    birthDate = "1996-03-14",
    position = CharacterTypes.FRONTEND_DEV
)

val frontendDev2 = Employee(
    name = "Ivan",
    isEmployed = true,
    birthDate = "1994-11-02",
    position = CharacterTypes.FRONTEND_DEV
)

val frontendTeamLead = Employee(
    name = "Olga",
    isEmployed = true,
    birthDate = "1988-08-23",
    position = CharacterTypes.TEAM_LEAD,
    subordinates = listOf(frontendDev1, frontendDev2)
)

val backendDev1 = Employee(
    name = "Sergey",
    isEmployed = true,
    birthDate = "1992-06-10",
    position = CharacterTypes.BACKEND_DEV
)

val backendDev2 = Employee(
    name = "Dmitry",
    isEmployed = true,
    birthDate = "1990-01-28",
    position = CharacterTypes.BACKEND_DEV
)

val qaEngineer = Employee(
    name = "Maria",
    isEmployed = true,
    birthDate = "1997-09-05",
    position = CharacterTypes.QA
)

val backendTeamLead = Employee(
    name = "Alex",
    isEmployed = true,
    birthDate = "1987-12-19",
    position = CharacterTypes.TEAM_LEAD,
    subordinates = listOf(backendDev1, backendDev2, qaEngineer)
)

val pm = Employee(
    name = "Elena",
    isEmployed = true,
    birthDate = "1989-04-30",
    position = CharacterTypes.PM,
    subordinates = listOf(frontendTeamLead, backendTeamLead)
)

val crm = Employee(
    name = "Pavel",
    isEmployed = true,
    birthDate = "1991-07-17",
    position = CharacterTypes.CRM
)

val cto = Employee(
    name = "Michael",
    isEmployed = true,
    birthDate = "1985-02-08",
    position = CharacterTypes.CTO,
    subordinates = listOf(pm, crm)
)

//3 Создай функцию в которой:
//сериализуй CTO в текст с настройкой prettyPrinting
//текст запиши в файл в корне проекта.

fun serializeCtoToFile(cto: Employee) {

    val gson = GsonBuilder()
        .setPrettyPrinting()
        .create()

    val jsonText = gson.toJson(cto)

    File("cto.json").writeText(jsonText)
}

// 4 Создай функцию в которой:
//прочитай текст из файла
//десериализуй его в объект класса Employee
//распечатай в консоль


fun readEmployeeFromFile() {

    val jsonText = File("cto.json").readText()

    val gson = Gson()

    val employee = gson.fromJson(jsonText, Employee::class.java)

    println(employee)
}

fun main() {
    serializeCtoToFile(cto)
    readEmployeeFromFile()
}
