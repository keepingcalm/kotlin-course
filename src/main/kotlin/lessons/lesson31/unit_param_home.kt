package ru.kotlin.lessons.lesson31

class PhoneNumberFormatter {

    fun formatPhoneNumber(input: String): String {
        // 1. Убираем все нечисловые символы
        val digits = input.replace("\\D".toRegex(), "")

        // 2. Проверка длины
        if (digits.length != 10 && digits.length != 11) {
            throw IllegalArgumentException("Invalid phone number length")
        }

        // 3. Если 11 цифр — проверяем первую и убираем её
        val normalizedDigits = if (digits.length == 11) {
            if (digits.first() != '7' && digits.first() != '8') {
                throw IllegalArgumentException("Invalid country code")
            }
            digits.substring(1)
        } else {
            digits
        }

        // 4. Формируем фрагменты
        val areaCode = normalizedDigits.substring(0, 3)
        val firstPart = normalizedDigits.substring(3, 6)
        val secondPart = normalizedDigits.substring(6, 8)
        val thirdPart = normalizedDigits.substring(8, 10)

        // 5. Вставляем в шаблон
        return "+7 ($areaCode) $firstPart-$secondPart-$thirdPart"
    }
}
