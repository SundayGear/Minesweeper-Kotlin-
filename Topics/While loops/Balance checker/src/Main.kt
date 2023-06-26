import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    var balance = readln().toInt()
    var indicator: Boolean = true
    while (scanner.hasNextInt()) {
        val purchase = scanner.nextInt()
        if (balance >= purchase) {
            balance -= purchase
        }
        else {
            println("Error, insufficient funds for the purchase. Your balance is $balance, but you need $purchase.")
            indicator = false
            break
        }

    }
    if (indicator == true)
    println("Thank you for choosing us to manage your account! Your balance is $balance.")
}