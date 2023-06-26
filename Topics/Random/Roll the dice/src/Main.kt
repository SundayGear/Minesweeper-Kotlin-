import kotlin.random.Random

fun throwD6(): Int {
    val numberOnTheDice = Random.Default
	return numberOnTheDice.nextInt(1, 7)
}
