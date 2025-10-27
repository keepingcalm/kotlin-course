package ru.kotlin.lessons.lesson15

class Materials2:Materials() {
    fun extractMiddle(): String {
        val materials = extractMaterials()
        val index = materials.size / 2
        for (i in materials.indices) {
            if (i == index) continue
            addMaterial(materials[i])
        }
        return materials[index]
    }
}