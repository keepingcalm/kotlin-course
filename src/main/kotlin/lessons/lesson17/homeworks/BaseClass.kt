package ru.kotlin.lessons.lesson17.homeworks

abstract class BaseClass(
    // 1. объясни, почему это поле доступно в main() для чтения из класса ChildrenClass
    // там не приватная переменная указана, с таким же именем
    private val privateVal: String,
    // 2. объясни, почему это поле недоступно в main() -
    // переменная протектед, доступна только в классе и в дочерних классах
    protected val protectedVal: String,
    val publicVal: String
) {
    var publicField = "3. измени меня из функции main() на Антонио Бандераса и проверь через функцию getAll()" +
            "4. Доработай ChildrenClass таким образом, чтобы это получилось"
        set(value) {
            if (verifyPublicField(value)) {
                field = value
            }
        }
    protected var protectedField = "5. измени меня из функции main() через сеттер в наследнике"
    private var privateField = "6. добавь сеттер чтобы изменить меня из main()" // нельзя поменять в прайват переменной
    fun getAll(): String {
        return mapOf(
            "privateVal" to privateVal,
            "protectedVal" to protectedVal,
            "publicVal" to publicVal,
            "publicField" to "Антонио Бандерас",
            "protectedField" to protectedField,
            "privateField" to privateField,
            "generate" to generate(),
        ).map { "${it.key}: ${it.value}" }
            .joinToString("\n")
    }
    fun printText() {
        privatePrint()
    }
    // 7. объясни, почему эта функция не может быть публичной
    // создан протект класс, публично получить ссылку на протект класс нельзя поэтому и весь метод протектед
    protected open fun getProtectedClass() = ProtectedClass()
    protected open fun verifyPublicField(value: String): Boolean {
        return value.length < 3
    }
    // 8. Распечатай getAll() и объясни, почему в поле "generate" другой текст
    // generate переоределен в доч классе
    open fun generate(): String {
        return "Это генерация из родительского класса"
    }
    private fun privatePrint() {
        println("Печать из класса BaseClass")
    }
    // 9. объясни, почему эта функция не может быть публичной или protected
    // возвращается прайват класс, к которому извне нет доступа, поэтому все прайват
    private fun getPrivateClass() = PrivateClass()

    protected class ProtectedClass() {}

    private class PrivateClass() {}
}
class ChildrenClass(
    val privateVal: String,
    protectedVal: String,
    // 10. объясни, почему этот аргумент доступен в main() несмотря на то, что это не поле
    // потому что можем использовать как child.publicVal
    publicVal: String
) : BaseClass(privateVal, protectedVal, publicVal) {
    // 11. объясни, почему в main() доступна функция getAll() хотя её здесь нет
    // потому что есть наследование из баз класса, даже без объявление - работает наследование
    // 12. проверь, что выводится на печать при вызове функции printText()
    // и объясни, почему не происходит переопределение метода privatePrint()
    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }
    override fun verifyPublicField(value: String) = true
    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }
    fun setProtectedField1(value: String) {
        protectedField = value
    }
}

fun main() {
    val child = ChildrenClass("private", "protected", "public")
    child.publicField = "Антонио Бандерас"
    child.setProtectedField1("Новое значение")
    child.printText()
    println(child.getAll())

}