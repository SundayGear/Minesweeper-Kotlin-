fun main() {
    val n = readln().toInt()
    val list = mutableListOf<Int>()
    for(i in 0 until n)
        list.add(readln().toInt())
    shift(list)
}
fun shift (list: MutableList<Int>) {
    val temp = list.last()
    for(i in list.size - 1 downTo  1)
        list[i] = list[i - 1]
    list[0] = temp
    print(list.joinToString(" "))
}