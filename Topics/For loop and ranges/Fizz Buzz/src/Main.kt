fun main() {
    val range = readln().toInt()..readln().toInt()
    for (x in range) {
        if (x % 3 == 0 && x % 5 == 0) {
            println("FizzBuzz")
        } else if (x % 5 == 0) {
            println("Buzz")
        } else if (x % 3 == 0) {
            println("Fizz")
        } else {
            println(x)
        }
    }
}