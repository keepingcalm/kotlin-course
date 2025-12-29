package lesson31.homeworks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import ru.kotlin.lessons.lesson31.homeworks.PhoneNumberFormatter
import org.junit.jupiter.params.provider.ValueSource
import org.junit.jupiter.api.Assertions.assertThrows



class PhoneNumberFormatterValidTest {

    private val formatter = PhoneNumberFormatter()

    @ParameterizedTest(name = "Input: {0} → Expected: {1}")
    @CsvSource(
        "8 (922) 941-11-11, +7 (922) 941-11-11",
        "79229411111, +7 (922) 941-11-11",
        "+7 922 941 11 11, +7 (922) 941-11-11",
        "9229411111, +7 (922) 941-11-11",
        "abc +7 922 941 11 11, +7 (922) 941-11-11"
    )
    fun `should format valid phone numbers`(
        input: String,
        expected: String
    ) {
        val result = formatter.formatPhoneNumber(input)

        assertEquals(expected, result)
    }
}

class PhoneNumberFormatterInvalidTest {

    private val formatter = PhoneNumberFormatter()

    @ParameterizedTest(name = "Invalid input: {0}")
    @ValueSource(strings = [
        "12345",                    // слишком короткий
        "+1 (922) 941-11-11",       // неверный код страны
        "999999999999",             // слишком длинный
        "7",                        // мусор
        "abcdefgh"                  // нет цифр
    ])
    fun `should throw exception for invalid phone numbers`(input: String) {
        assertThrows(IllegalArgumentException::class.java) {
            formatter.formatPhoneNumber(input)
        }
    }
}