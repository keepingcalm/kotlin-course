package lesson30

import org.junit.jupiter.api.Test
import ru.kotlin.lessons.lesson14.Calculator
import kotlin.test.assertEquals

class MyUnitTest {

    @Test
    fun additionalTest() {
        val calc = Calculator()
        assertEquals(42, Calculator.Companion.add2(12, 2))
    }

}