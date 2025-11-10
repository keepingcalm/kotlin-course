package ru.kotlin.lessons.lesson17.homeworks

class SlotMachine (
    val color: String,
    val model: String,
    var onOff: Boolean,
    var loadOS: Boolean,
    var listGame: List<String>,
    val joystick: Boolean,
    private var earnedMoney: Double,
    var owner: String,
    var phoneSupport: String,
    var isSessionPaid: Boolean,
    var sessionPrice: Double,
    private var pinCode: String
) {
    fun onOff () {
       onOff = true
       println("Автомат включен")
    }
    fun powerOff() {
        onOff = false
        println("Автомат выключен")
    }
    fun loadOs() {
        if (onOff) {
            loadOS = true
            println("ОС загружена")
        } else {
            println("Сначала включите автомат")
        }
    }
    fun shutdownOs() {
        if (loadOS) {
            loadOS = false
            println("ОС завершила работу")
        } else {
            println("ОС не была загружена")
        }
    }
    fun showGames() {
        println("Список игр: $listGame")
    }
    fun startGame(gameName: String) {
        if (loadOS && isSessionPaid && listGame.contains(gameName)) {
            println("Игра $gameName запущена")
        } else {
            println("Невозможно запустить игру: проверьте оплату и загрузку ОС")
        }
    }
    fun paySession(amount: Double) {
        if (amount >= sessionPrice) {
            isSessionPaid = true
            earnedMoney += amount
            println("Сеанс оплачен")
        } else {
            println("Недостаточно средств для сеанса")
        }
    }
    fun takeCash(inputPin: String): Double {
        return if (inputPin == pinCode) {
            val cash = earnedMoney
            earnedMoney = 0.0
            println("Выдано наличных: $cash")
            cash
        } else {
            println("Неверный пин-код")
            0.0
        }
    }
    fun openSafe() {
        println("Сейф открыт, можно забрать наличные через takeCash()")
    }
}

