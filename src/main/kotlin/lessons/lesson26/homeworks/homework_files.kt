package ru.kotlin.lessons.lesson26.homeworks

import ru.kotlin.lessons.lesson26.createFile
import java.io.File


fun main() {
// Задача 1
//Создайте текстовый файл workspace/task1/example.txt.
// Запишите в него строку "Hello, Kotlin!", а затем проверьте, существует ли файл.
// Реши задачу с использованием scope функции без создания переменной.


    File("workspace/task1/example.txt").apply {
        parentFile?.mkdirs()
        writeText("Hello, Kotlin!")
        println(if (exists()) "File exists" else "File doesn't exist")
    }


//Задача 2
//Создайте директорию workspace/task2/testDir. Проверьте, является ли она директорией, и выведите её абсолютный путь.


    File("workspace/task2/testDir").run {
        mkdirs()
        if (isDirectory) {
            println(absolutePath)
        } else {
            println("Is not directory")
        }
    }


//Задача 3
//Создайте директорию workspace/task3/structure.
// Внутри директории structure создайте папку myDir с двумя вложенными поддиректориями subDir1 и subDir2.
// Проверьте, что myDir действительно содержит эти поддиректории.
// Используй scope функции для минимизации создания переменных а так же метод file.resolve("myDir")
// для создания нового объекта File путём добавления к существующему пути ещё одной секции.
// И так же для других директорий.

    File("workspace/task3/structure").apply {
        mkdirs()
    }.resolve("myDir").apply {
        listOf("subDir1", "subDir2").forEach { resolve(it).mkdirs() }
    }.also { myDir ->
        println("myDir path: ${myDir.absolutePath}")
        println(
            "subDir created: ${
                listOf("subDir1", "subDir2").all {
                    myDir.resolve(it).exists() && myDir.resolve(it).isDirectory
                }
            }"
        )
    }


//Задача 4
//Создайте директорию workspace/task4/temp.
// Внутри директории temp создайте несколько вложенных файлов и директорий.
// Удалите директорию workspace/task4 со всем содержимым

    File("workspace/task4/temp").apply {
        mkdirs()
    }.also { ex4 ->
        listOf("file1.txt", "file2.txt").forEach { name ->
            File(ex4, name).createNewFile()
        }
        listOf("subDir1", "subDir2").forEach { name ->
            File(ex4, name).mkdirs()
        }
    }.also { tempDir ->
        File(tempDir, "subDir1/file3.txt").createNewFile()
    }
    File("workspace/task4").run {
        deleteRecursively()
        println("Dir workspace/task4 is deleted totally")
    }

//Задача 5
//Создайте файл workspace/task5/config/config.txt.
// запишите в него список параметров (в формате ключ=значение),
// затем прочитайте файл и выведите только значения.

    File("workspace/task5/config/config.txt").apply {
        parentFile?.mkdirs()
        writeText(
            mapOf(
                "env" to "prod",
                "bd" to "postgress",
                "email_CTO" to "test@gmail.com"
            ).toString()
        )
        println(readText())
    }

//Задача 6
//Пройди по всем вложенным директориям workspace и выведи в консоль сначала пути директорий, а потом пути файлов

    File("workspace").takeIf { it.exists() && it.isDirectory }?.run {
        println("\nDirectories ex6:")
        walk().filter { it.isDirectory }.forEach { println(it) }

        println("\nFiles ex6:")
        walk().filter { it.isFile }.forEach { println(it) }
    } ?: println("dir workspace not found")

//Задача 7
//Создайте директорию workspace/task7/docs.
// Проверь, есть ли файл с именем readme.md. Если файла нет, создайте его и запишите текст "This is a README file.".
// Проверьте текст в файле.

    File("workspace/task7/docs").resolve("readme.md").apply {
        if (exists() && isFile) {
            check(readText() == "This is a README file.") { "Файл содержит неправильный текст!" }
            println(readText())
        } else {
            parentFile?.mkdirs()
            createNewFile()
            writeText("This is a README file.")
        }
    }
//Задача 8
//workspace/task8/data/1/4/prod/data14.mysql
//workspace/task8/data/2/3/prod/data23.mysql
//workspace/task8/data/5/2/prod/data52.mysql
//Создайте директорию workspace/task8/backup и скопируйте туда файлы из workspace/task8/data сохраняя структуру директорий.
// Для копирования используй метод copyTo.
// Для получения относительного пути начиная от data используй relativeTo от пути до файла,
// передавая в него путь до базовой директории (то-есть data).
// Полученный relative фрагмент можно присоединить к пути бэкапа через resolve
// и таким образом получить путь назначения копирования, например workspace/task8/backup/1/4/prod/data14.mysql
// сохраняя весь относительный путь.

    val ex8 = File("workspace/task8/data/").apply { mkdirs() }
        .also { dir ->
            listOf(
                "1/4/prod/data14.mysql",
                "2/3/prod/data23.mysql",
                "5/2/prod/data52.mysql"
            ).forEach { fileName ->
                dir.resolve(fileName).apply {
                    parentFile?.mkdirs()
                    if (!exists()) {
                        createNewFile()
                        writeText("This is $fileName file.")
                    }
                }
            }
        }
    val ex81 = File("workspace/task8/backup").apply { mkdirs() }


}


