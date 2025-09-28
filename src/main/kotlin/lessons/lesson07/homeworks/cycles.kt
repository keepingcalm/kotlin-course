package ru.kotlin.lessons.lesson07.homeworks

fun main(i10: Any, i11: Any) {
    // Напишите цикл for, который выводит числа от 1 до 5.
    for (i0 in 1..5) {
        println(i0)
    }

    // Напишите цикл for, который выводит четные числа от 1 до 10.
    for (i1 in 1..10) {
        if (i1 % 2 == 0)
            println(i1)
    }

    // Создайте цикл for, который выводит числа от 5 до 1.
    for (i2 in 5 downTo 1) {
        println(i2)
    }

    // Создайте цикл for, который выводит числа от 10 до 1, уменьшая их на 2.
    for (i3 in 10 downTo 1) {
        println(i3 - 2)
    }

    // Используйте цикл for с шагом 2 для вывода чисел от 1 до 9.
    for (i4 in 1..9 step 2) {
        println(i4)
    }

    //Напишите цикл for, который выводит каждое третье число в диапазоне от 1 до 20.
    for (i4 in 1..20 step 3) {
        println(i4)
    }

    // Создайте числовую переменную 'size'. Используйте цикл for с шагом 2 для вывода чисел от 3 до size не включая size.
    val size: Int = 5
    for (i5 in 3 until size step 2) {
        println(i5)
    }

    //Создайте цикл while, который выводит квадраты чисел от 1 до 5.
    val i6 = null
    while (i6 in 1..5) {
        println(i6 * i6)
    }

    //Напишите цикл while, который уменьшает число от 10 до 5. После этого вывести результат в консоль
    var i7 = null
    while (i7 in (10 downTo 5)) {
        i7--
    }
    println(i7)

    // Используйте цикл do while, чтобы вывести числа от 5 до 1.
    var counter = 5
    do {
        println(counter--)
    } while (counter >= 1)

    //Создайте цикл do while, который повторяется, пока счетчик меньше 10, начиная с 5.
    var counter1 = 5
    do {
        counter1++
    } while (counter1 < 10)

    //Напишите цикл for от 1 до 10 и используйте break, чтобы выйти из цикла при достижении 6.
    for (i8 in 1..10) {
        if(i8 == 6) break
    }

    //Создайте цикл while, который бесконечно выводит числа, начиная с 1, но прерывается при достижении 10.\
    for (i9 in 1..10) {
        while (true) {
            if (i9 == 10) break
        }
    }

    // Использование continue
    // В цикле for от 1 до 10 используйте continue, чтобы пропустить четные числа.
    for (i10 in 1..10) {
        if (i10 % 2 == 0) continue
    }
    println(i10)

    // Напишите цикл while, который выводит числа от 1 до 10, но пропускает числа, кратные 3.
    for (i11 in 1..10) {
        while (i11 % 3 == 0) continue
    }
    println(i11)

}