fun main() {
    val companies = readln().toInt()
    val companyListIncome = mutableListOf<Int>()
    val companyListTaxesPaid = mutableListOf<Float>()
    for (i in 0..companies - 1) companyListIncome.add(readln().toInt())
    for (i in 0..companies - 1) {
        companyListTaxesPaid.add(companyListIncome[i].toFloat() * readln().toFloat() / 100)
    }
    print(companyListTaxesPaid.indexOf(companyListTaxesPaid.maxOrNull()) + 1)

}