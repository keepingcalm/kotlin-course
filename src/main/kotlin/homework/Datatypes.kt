package ru.kotlin.homework

val v1: Byte = 42
val v2: Long = 98765432123456789L
val v3: Float = 23.45f
val v4: Double = 0.123456789
val v5: String = "Kotlin & Java"
val v6: Boolean = FALSE //все буквы должны быть строчные  или стринг, можно и так val v6: String = "FALSE"
val v7: Char = 'c'
val v8: Int = 500
val v9: Long = 4294967296L
val v10: Float = 18.0f
val v11: Double = -0.001
val v12: String = "OpenAI"
val v13: Boolean / String = "true" // если булеан, то убираем кавычки, если стринг - то оставляем
val v14: List<Byte> = listOf(3, 14)
val v15: Char = '9'
val v16: Int = 2048
val v17: Long = 10000000000L
val v18: Set<String> = setOf("OpenAI", "Quantum Computing")
val v19: Float = 5.75f
val v20: Double = `1.414` // убрать кавычки, тогда будет дабл
val v21: String = "Artificial Intelligence"
val v22: Array<Char, String>= arrayOf('x', "A") // либо сделать все кавычки одинарными, то Char, либо двойными - то String
val v23: String = "Android Studio"
val v24: Char = '@'
val v25: Int = 1024
val v26: Long = 1234567890123L
val v27: Float = 10.01f
val v28: Double = -273.15
val v29: String = "SpaceX"
val v30: String = FALSE // см v6, либо добавить двойные кавычки и будет стринг, либо маленькими написать и будет булево
val v31: Double = 0.007
val v32: String = “🤯” // будет стринг, если поменять на кавычки двойные ""
val v33: Map<String,Byte> = mapOf("true" to 2, "false" to 34)
val v34: Int = ‘65535’ // убрать кавычки и будет int
val v35: Long = 72057594037927935L
val v36: Float = 2.71828f
val v37: Double = 101.0101
val v38: String = "Quantum Computing"
val v39: Map<Byte, String> = mapOf(2 to "true", 34 to "false") // если убрать кавычки, может быть Byte, Boolean
val v40: Char = 'x'
val v41: Int = 314
val v42: Long = 123456789123456789L
val v43: Float = 6.626f
val v44: Boolean = TRUE //надо писать маленькими буквами, как в v6

//Хранить букву, на которую указывает палец медиума во время спиритического сеанса.
val letter: Char = 'x'

//Хранить количество ложек сахара, которые я кладу в одну чашку чая.
val sugarcount: Byte = 3

//Хранить список расходов на доставку еды, чтобы ещё раз убедиться, что готовить было дешевле.
val foodPrice: Map<String, Double> = mapOf("макдак" to 12.2, "кфс" to 444.6)

//Хранить длину очереди в столовой до миллиардной доли сантиметра.
val queueLenght: Float = 123.33399969f

//Хранить факт, закрыт ли баг после того, как его просто переименовали в фичу.
val isOpen: Boolean = true

//Хранить количество свистков чайника за день.
val whistleKettleCount: Byte = 23

// Хранить количество нажатий котом на клавиатуру ноутбука за всё время твоей работы.
val catTapKeyboardCount: Long = 9038419276256929243L

// Хранить количество попыток пересчитать звёзды на небе за всю историю человечества.
val starCountAttempts: Long = 23232L

// Хранить массу воздуха в спускающем матрасе после нападения кота в долях грамма.
val airWeight: Double = 12.4839

//Хранить словарь «название стартапа → сумму потерь инвесторов».
val startupLoses: Map<String, Float> = mapOf("БольшиеБукинги" to 4442.2323, "МалыеБукинги" to 3333.34436)

//Хранить строку «починилось само», чтобы закрывать тикеты без лишних слов.
val fixText: String = "Починилось само"

//Хранить список тем для митингов, которые на самом деле никому не нужны.
val themes: List<String> = listOf("тема 1","тема 2","тема 3")