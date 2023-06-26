import kotlin.random.Random

fun generatePredictablePassword(seed: Int): String {
    var randomPassword = ""
    val password = Random(seed)
    repeat(10) {
        randomPassword += password.nextInt(33,127).toChar()
    }
	return randomPassword
}