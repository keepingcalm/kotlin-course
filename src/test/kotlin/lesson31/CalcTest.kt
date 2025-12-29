package lesson31

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import ru.kotlin.lessons.lesson31.calculateDiscountedPrice
import kotlin.test.assertFailsWith

class DiscountCalculatorTest {

    @Test
    fun `should return original price when discount is 0`() {
        val originalPrice = 100.0
        val discountPercentage = 0
        val actualPrice = calculateDiscountedPrice(originalPrice, discountPercentage)
        assertEquals(100.0, actualPrice, 0.01, "Цена без скидки рассчитана неверно")
    }

    @Test
    fun `should calculate 50 percent discount`() {
        val originalPrice = 200.0
        val discountPercentage = 50
        val actualPrice = calculateDiscountedPrice(originalPrice, discountPercentage)
        assertEquals(100.0, actualPrice, 0.01, "50% скидка рассчитана неверно")
    }

    @Test
    fun `should return 0 when discount is 100 percent`() {
        val originalPrice = 50.0
        val discountPercentage = 100
        val actualPrice = calculateDiscountedPrice(originalPrice, discountPercentage)
        assertEquals(0.0, actualPrice, 0.01, "Полная скидка рассчитана неверно")
    }

    @Test
    fun `should calculate 25 percent discount`() {
        val originalPrice = 99.99
        val discountPercentage = 25
        val actualPrice = calculateDiscountedPrice(originalPrice, discountPercentage)
        assertEquals(74.99, actualPrice, 0.01, "25% скидка рассчитана неверно")
    }

    @Test
    fun `should throw exception when original price is negative`() {
        val originalPrice = -10.0
        val discountPercentage = 10
        assertThrows(IllegalArgumentException::class.java) {
            calculateDiscountedPrice(originalPrice, discountPercentage)
        }
    }

    @Test
    fun `should throw exception when discount percentage is out of range`() {
        val originalPrice = 100.0
        val discountPercentage = 150
        assertThrows(IllegalArgumentException::class.java) {
            calculateDiscountedPrice(originalPrice, discountPercentage)
        }
    }
}

class DiscountCalculatorParameterizedTest {
    @ParameterizedTest
    @MethodSource("provideDiscountData")
    fun `should calculate discounted price correctly`(
        originalPrice: Double,
        discountPercentage: Int,
        expectedPrice: Double
    ) {
        val actualPrice = calculateDiscountedPrice(originalPrice, discountPercentage)
        assertEquals(expectedPrice, actualPrice, 0.01, "Цена после скидки рассчитана неверно")
    }

    annotation class ParameterizedTest

    @ParameterizedTest
    @MethodSource("provideInvalidPrices")
    fun `should throw exception for invalid original price`(originalPrice: Double, discountPercentage: Int) {
        assertFailsWith<IllegalArgumentException>("Цена должна быть неотрицательной") {
            calculateDiscountedPrice(originalPrice, discountPercentage)
        }
    }

    annotation class MethodSource(val value: String)

    @ParameterizedTest
    @MethodSource("provideInvalidDiscounts")
    fun `should throw exception for invalid discount percentage`(discountPercentage: Int) {
        assertFailsWith<IllegalArgumentException>("Скидка должна быть от 0 до 100%") {
            calculateDiscountedPrice(100.0, discountPercentage)
        }
    }

    companion object {
        @JvmStatic
        fun provideDiscountData() = listOf(
            arrayOf(100.0, 0, 100.0),   // Без скидки
            arrayOf(200.5, 49, 102.255), // Неровная цена и скидка
            arrayOf(50.0, 100, 0.0),   // Полная скидка
            arrayOf(99.99, 25, 74.99)  // 25% скидка и дробная цена
        )

        @JvmStatic
        fun provideInvalidPrices() = listOf(
            arrayOf(-0.01, 10), // Отрицательная цена
            arrayOf(-1.0, 0),  // Отрицательная цена без скидки
            arrayOf(-0.01, 100), // Отрицательная цена и полная скидка
        )

        @JvmStatic
        fun provideInvalidDiscounts() = listOf(
            arrayOf(-1),  // Скидка меньше 0
            arrayOf(101)   // Скидка больше 100
        )
    }
}