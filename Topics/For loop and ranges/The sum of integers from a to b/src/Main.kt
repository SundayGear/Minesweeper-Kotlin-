fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    var i = 0
    var sum = 0
    for(i in a..b) {
        sum += i
    }
    print(sum)
}
