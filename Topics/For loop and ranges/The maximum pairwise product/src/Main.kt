fun main() {
    val n = readln().toInt()
    var maxMultiple = 0
    val list = mutableListOf<Int>()
    for (i in 0 until n)
        list.add(readln().toInt())
    if(n == 1) {
        maxMultiple = list[0]
    }
    else {
        for (i in 0 until n)
            for (j in 0 until n) {
                if(i==j) continue
               else if (list[i] * list[j] > maxMultiple) maxMultiple = list[i] * list [j]
            }

    }
    println(maxMultiple)
}