fun main() {
    val par = MutableList(4) { readln().toInt() }
    val range = 0..1000
    for (x in range) {
        if (par[0] * x * x * x + par[1] * x * x + par[2] * x + par[3] == 0) {
            println(x)
        }
    }

}