package ru.kotlin.lessons.lesson28

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.Period
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit
import java.time.Duration
import java.time.format.DateTimeFormatter

fun main() {
    val instant = Instant.now()
    println(instant)
    println(instant.epochSecond)

    val dateTimeNow = LocalDate.now()
    val birthday = LocalDate.of(1983, 10, 2)

    val localTimeNow = LocalTime.now()
    val endOfTheMyWorkingDay = LocalTime.of(18, 0, 0)

    val localDateTime = LocalDateTime.now()
    val alarmClock = LocalDateTime.of(2024, 4, 1, 9, 0, 0)

    // Примеры ZoneId: "Europe/Paris", "America/New_York".
    val vaticanCurrentTime = ZonedDateTime.now(ZoneId.of("Europe/Vatican"))
    val mobileWorldCongress = ZonedDateTime.of(
        2024,
        2,
        26,
        10,
        0,
        0,
        0,
        ZoneId.of("Europe/Madrid")
    )

    // Примеры ZoneOffset: "+02:00", "-05:00".
    val birthdayInDubai = OffsetDateTime.of(birthday.atTime(19, 0), ZoneOffset.of("+09:00"))

    val vaticanCurrentTimeInstant = vaticanCurrentTime.toInstant()
    val birthdayInstant = birthday.atTime(19, 0).toInstant(ZoneOffset.of("+09:00"))
    val instantToZonedDateTime = instant.atZone(ZoneId.systemDefault())
    val instantToOffsetDateTime = instant.atOffset(ZoneOffset.of("-02:00"))

    LocalDate.now().plus(2, ChronoUnit.DAYS)
    LocalDate.now().minusYears(2)

    birthdayInDubai.isAfter(instantToOffsetDateTime)
    birthdayInDubai.isBefore(instantToOffsetDateTime)


    //Duration.between(startDateTime, endDateTime)
    val nanoSeconds = Duration.ofNanos(200)
    println(nanoSeconds.dividedBy(4).toNanos())
    println(nanoSeconds.plus(Duration.ofSeconds(2)).toNanos())
    val seconds = Duration.ofSeconds(45)
    println(seconds.minusMinutes(1).seconds)
    println(seconds.minusMinutes(3).toMinutes())

    //Period.between(startDate, endDate)

    val period = Period.of(2, 4, 10)
    println(period.minusMonths(13).toTotalMonths())

    val periodFromConferenceToBirthday = Period.between(mobileWorldCongress.toLocalDate(), birthday)
    println("${periodFromConferenceToBirthday.years} лет ${periodFromConferenceToBirthday.months} месяцев ${periodFromConferenceToBirthday.days} дней")

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS ZZZ")
    println(instantToZonedDateTime.format(formatter))

    val isoFormatter = DateTimeFormatter.ISO_DATE_TIME

    val prettyFormatter = DateTimeFormatter.ofPattern("'год' yyyy', месяц' MM', день' dd")
    val prettyFormattedDate = dateTimeNow.format(prettyFormatter)
    println(prettyFormattedDate)

    val parseDate = LocalDate.parse(prettyFormattedDate, prettyFormatter)
    println(parseDate)

    val ex1 = Instant.now()
    val ex2 = Instant.ofEpochSecond(900009877)
    val ex3 = Instant.ofEpochSecond(-900009877)
    println(ex2)
    println(ex3)

    val ex4 = LocalDate.of(2023,9,1)
    val ex5 = LocalDate.of(2025,5,31)

    val ex6 = Period.between(ex4,ex5)
    println(ex6)

    val ex7 = Period.of(2,3,24)
    println(ex5 + ex7)

    val ex8 = ZonedDateTime.of(2025,12,22,10,0,0,0, ZoneId.of("Europe/Moscow"))
    val ex9 = LocalDate.of(2025,12,22)
    val ex10 = LocalTime.of(10,10,10)
    val ex11 = ZonedDateTime.of(ex9,ex10, ZoneId.of("Europe/Moscow"))

    val ex12 = ex9.atTime(ex10).atZone(ZoneId.of("Europe/Moscow"))

    val ex13 = ex12.plusDays(11).plusHours(5)

    val ex14 = DateTimeFormatter.ofPattern("'Days:' dd, 'Hours:' HH")
    println(ex13.format(ex14))

    val ex15 = ex6.multipliedBy(2)
    println(ex15)
}