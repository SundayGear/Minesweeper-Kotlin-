import kotlin.math.max

fun main() {
    val numberList = mutableListOf<Int>()
    numberList.add(readln().toInt())
    var max = 0
    while(numberList[numberList.size - 1] != 0){
        numberList.add(readln().toInt())
    }
    for(i in numberList.indices) {
        max = max(max, numberList[i])
    }
        print(max)

}