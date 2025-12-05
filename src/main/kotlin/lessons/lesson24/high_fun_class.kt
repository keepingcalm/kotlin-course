//package ru.kotlin.lessons.lesson24
//
////fun main() {
////    println("дратути")
////}
//import javax.crypto.interfaces.DHPublicKey
//import kotlin.random.Random
//
//abstract class LambdaVehicle<E, P, M>(
//    private val energySource: () -> E,
//    private val powerUnit: (E, Double) -> P,
//    private val motionSystem: (P) -> M
//) {
//    fun performMove(sourceQuantity: Double): M {
//        val energy: E = energySource()
//        val power: P = powerUnit(energy, sourceQuantity)
//        return motionSystem(power)
//    }
//}
//
//class LambdaInterfaceStringIntMobil : LambdaVehicle<String, Double, Int>(
//    StringEnergy()::provide,
//    DoublePower()::generate,
//    IntMotion()::move
//)
//
//// Источник ресурса E (топливо, электроэнергия, сжатый воздух, корм для тягового животного)
//fun interface EnergySource<E> {
//    fun provide(): E
//}
//
//// Узел, который берёт ресурс E и превращает его в "двигательную мощность" P
//// (например: топливо -> крутящий момент вала, электроэнергия -> крутящий момент, пар -> поступательное усилие, корм -> движение мускулатуры)
//fun interface PowerUnit<E, P> {
//    fun generate(input: E, quantity: Double): P
//}
//
//// Узел, который берёт мощность P и превращает её в "движение" M
//// (крутящий момент -> скорость вращения колеса, тяга -> скорость, тяга -> подъёмная сила и т.п.)
//fun interface MotionSystem<P, M> {
//    fun move(input: P): M
//}
//
//// Абстрактное транспортное средство:
//// E — тип исходного ресурса (топливо, энергия и т.п.)
//// P — тип мощности или усилия, которое создаёт силовая установка
//// M — тип "движения" на выходе (скорость, тяга, подъёмная сила, что угодно)
//abstract class Vehicle<E, P, M>(
//    private val energySource: EnergySource<E>,
//    private val powerUnit: PowerUnit<E, P>,
//    private val motionSystem: MotionSystem<P, M>
//) {
//    fun performMove(powerQuantity: Double): M {
//        val energy: E = energySource.provide()
//        val power: P = powerUnit.generate(energy, powerQuantity)
//        return motionSystem.move(power)
//    }
//}
//
//class StringEnergy : EnergySource<String> {
//    override fun provide() = "Топливо"
//}
//
//class DoublePower : PowerUnit<String, Double> {
//    override fun generate(input: String, sourceQuantity: Double): Double {
//        return input.map { it.code / 2.0 }.sum() * sourceQuantity
//    }
//}
//
//class IntMotion : MotionSystem<Double, Int> {
//    override fun move(input: Double): Int {
//        return input.toInt() / 2
//    }
//}
//
//class StringIntMobil : Vehicle<String, Double, Int>(
//    StringEnergy(),
//    DoublePower(),
//    IntMotion()
//)
//
//fun main() {
//    val m = StringIntMobil()
//    println(m.performMove(2.0))
//    m.performMove(2.4)
//    val r: () -> String = {
//        Random.nextFloat().toString()
//    }
//    val parameterizedAuto = StringIntMobil()
//
//    val result = "my text".charTransform { it.uppercaseChar() }
//    println(result)
//    val result2 = "my text".charTransform { it + 1 }
//    println(result2)
//    val result3 = "my text".charTransform { it }.reversed()
//    println(result3)
//    listOf("").filter { it == "f" }
//    //   println(ex11("dfsf")())
//
//    val we = ex6("sdafnjdkjlg")
//    println(we(6))
//
//    val exN = 10.1.encode { it + 5 }
//    println(exN)
//    val exN2 = exN.decode({ it - 5 }, { it.toDouble() })
//
//
//}
//
//fun Number.encode(fn: (Char) -> Char): String {
//    return toString().map(fn).joinToString { "" }
//}
//
//fun <F : Number> String.decode(fn: (Char) -> Char, fn2: (String) -> F): F {
//    val decodeString = map(fn).joinToString("")
//    return fn2(decodeString)
//}
//
//
//fun String.charTransform(transformation: (Char) -> Char): String {
//    this.map { transformation(it) }
//    return map(transformation).joinToString("")
//}
//
////fun ex11(arg1: String): (Int) -> String {
////    val a: (Int) -> String = {
////        (1..it).joinToString { "" } {arg1}
////    }
////    return a
////}
//
//fun ex1(fn: () -> Int) {}
//fun ex2(fn: (Int) -> String) {}
//fun ex3(fn: Int.() -> Unit) {}
//fun ex4(fn: (Double, Double) -> Boolean) {}
//fun <S> ex5(fn: (S) -> List<S?>) {}
//fun ex6(arg: String): (Int) -> Boolean {
////    val h = fun (a: Int) : Boolean {
////        return true
////    }
////    val z: (Int) -> Boolean = {
////        true
////    }
//    return { it == arg.length }
//}
//
//fun x(a: Int): Boolean {
//    return true
//}
//
//
//
//
