import kotlin.math.*

fun main() {
    val n = readln().toDouble()
    val square = floor(sqrt(n))
    var i = 1
    while (i <= square) {
        println(i.toDouble().pow(2).roundToInt())
        i++
    }
    
}
