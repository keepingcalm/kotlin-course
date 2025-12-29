package lesson30

import org.junit.jupiter.api.Test
import ru.kotlin.lessons.lesson30.RgbLamp
import kotlin.test.assertTrue

class RedLampTest {
    @Test
    fun lampIsOnTest() {
    val lamp = RgbLamp()
        assertTrue { lamp.powerOn() }
    }
}