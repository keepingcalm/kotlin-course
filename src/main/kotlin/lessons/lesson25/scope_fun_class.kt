package ru.kotlin.lessons.lesson25

import ru.kotlin.homework.PI
import ru.kotlin.lessons.lesson22.homeworks.throwIAE
import java.io.File

fun main() {
    val list = mutableListOf(1, 2, 3)
    println(list.size)
    list.add(3)
    println(list.size)
// То же используя with
    with(list) {
        println(size)
        add(4)
        println(size)
    }

    list.add(5)
    val result = list.sum()
// То же используя run
    val resultWithRun = list.run {
        add(5)
        sum()
    }

//    val s = File("example.txt").inputStream()
//    val content = s.readBytes()
//    println(content)
//    s.close()
//// То же используя use
//    File("example.txt").inputStream().use {
//        val content = it.readBytes()
//        println(content.size)
//    }

    val list1 = mutableListOf<Int>()
    list1.add(1)
    list1.add(2)
// То же используя apply
    val list2 = mutableListOf<Int>().apply {
        add(2)
        add(2)
    }
    println(list1)
    println(list2)

    list.also {
        println("Добавляем 3")
    }.add(3)

    val str: String? = "Helloггг"
    if (str != null) {
        println(str.length)
    }
    // через let, упрощение визуально, без проверки через иф на нал
    str?.let {
        println(it.length)  // только если str не null
    } ?: println("342")
}

fun ex1(): Int {
    val arg1 = listOf(1, 3, 4, 5, 453)
    val result = arg1.sum()
    println(result)
    return result
}

fun ex11(): Int {
    return listOf(1, 3, 4, 5, 453).sum()
        .apply { println(this) }
}

fun ex12(): Int {
    return listOf(1, 3, 4, 5, 453).sum()
        .also { println(it) }
}

fun ex2(): Int {
    val arg2 = mutableListOf(1, 35, 778, 333, 6)
    arg2.add(4)
    arg2.add(3434)
    println(arg2.size)
    return arg2.sum()
}

fun ex21(): Int {
    return with(mutableListOf(1, 35, 778, 333, 6)) {
        add(4)
        add(3434)
        println(size)
        sum()
    }
}

fun ex22(): Int {
    return mutableListOf(1, 35, 778, 333, 6).run {
        add(4)
        add(3434)
        println(size)
        sum()
    }
}


fun ex3(arg3: List<String>?): Int {
    if (arg3 == null) {
        println("Zero")
        return 0
    } else {
        val result = arg3.sumOf { it.length }
        println(result)
        return result
    }
}

fun ex31(arg3: List<String>?): Int {
    return (arg3?.let { a ->
        a.sumOf { it.length }
    } ?: 0).also { println(it) }
}

