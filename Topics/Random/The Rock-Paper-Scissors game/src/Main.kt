import kotlin.random.Random

fun makeDecision(): String {
    when (Random.nextInt(1, 4)) {    
        1 -> return "Rock"
        2 -> return "Paper"
        3 -> return "Scissors"
    }
    return "none"
}
