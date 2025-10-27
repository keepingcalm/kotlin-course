package ru.kotlin.lessons.lesson15

class Materials1:Materials() {
    fun extractFirst(): String {
        val materials = extractMaterials()
        materials.drop(1).forEach { addMaterial(it) }
        return materials.first()
    }
}