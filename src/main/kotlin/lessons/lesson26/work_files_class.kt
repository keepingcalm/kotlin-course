package ru.kotlin.lessons.lesson26

import java.io.File

fun createFile(path: String) {
    val file = File(path)
    if (path.endsWith("/")) {
        file.mkdirs()
    } else {
        file.parentFile?.mkdirs()
        file.createNewFile()
    }
}

fun writeFile(path: String, obj: Map<String, Double>) {
    with(File(path)) {
        parentFile?.mkdirs()
        createNewFile()
        obj.map { "${it.key}=${it.value}" }
            .joinToString("\n")
            .also { writeText(it) }
    }

}

fun deleteFile(path: String, text: String) {
    File(path).apply {
        if (exists() && readText().contains(text)) {
            delete()
        }
    }
}

fun findFiles(basePath: String, keyWord: String): List<String> {
    return File(basePath).walk()
        .filter { it.isFile && it.name.contains(keyWord) }
        .map { it.readText() }
        .toList()
}

fun String.copyTo(targetPath: String) {
    val file = File(this).run {
        check(exists()) {
            "File doesn't exists"
        }
        val newFile = File(targetPath)
        newFile.parentFile?.mkdirs()
        copyTo(newFile)
    }
}

//fun main() {
//    val file = File("path/to/your/file.txt") // слеша вначале нет - значит идет от корня
//    val directory = File("path/to/your/directory") // ведет на директорию
//
//    if (file.exists()) {
//        println("Файл существует")
//    } else {
//        println("Файл не найден")
//    }
//// создать файл возможно только если путь существует
//    val isNewFileCreated: Boolean =
//        file.createNewFile()  // создание файла физически, если вызвать к вал директории без расширения, то так и создастся
//    if (isNewFileCreated) {
//        println("Файл был создан")
//    } else {
//        println("Файл уже существует")
//    }
//
//    file.parentFile?.mkdirs() // возвращает файл с путем до род объекта, мкдир создает директорию, при создании род директорий использовать проверну на нал
//    file.createNewFile()
//
//    file.writeText("hello world")
//
//    //val isDirectoryCreated: Boolean = directory.mkdirs() // создается весь недостающий путь
//    val isDirectoryCreated: Boolean = directory.createNewFile()
//    if (isDirectoryCreated) {
//        println("Директория была создана")
//    } else {
//        println("Не удалось создать директорию")
//    }
//
//    val files = directory.listFiles()
//    files?.forEach { file ->
//        println(file.name)
//        println(file)
//        println(file.absolutePath)
//    }
//
//    val sourceFile = File("/path/to/source.txt")
//    val destinationFile = File("/path/to/destination.txt")
////    sourceFile.copyTo(destinationFile, overwrite = true) // Копирует файл, перезаписывая его при необходимости
//
//    val baseDir = File("/path/to")
//    val file1 = File("/path/to/nested/file.txt")
//    println(file1.relativeTo(baseDir)) // Вывод: nested/file.txt
//    val relative = file1.relativeTo(baseDir)
//    val target = File("path/to1")
//    target.resolve(relative) // path/to1/nested/file.txt
//
////    if (file.delete()) {
////        println("Файл удален")
////    } else {
////        println("Не удалось удалить файл")
////    }
//
//}
//
//fun searchFilesUsingWalk(startDir: String, query: String): List<String> {
//    return File(startDir)
//        .walk() // Рекурсивный обход файлов и директорий начиная с startDir
//        .filter { it.isFile && it.name.contains(query, ignoreCase = true) } // Фильтрация по имени файла
//        .map { it.absolutePath } // Преобразование результатов в абсолютные пути
//        .toList() // Сбор результатов в список
//}
