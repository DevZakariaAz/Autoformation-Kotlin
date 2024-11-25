// Exemple simple d'utilisation lambdes
fun main() {
    val trickFunction = trick
}
val trick = {
    println("It's work!")
}

// Exemple 2 :
val square: (Int) -> Int = { it * it }

fun main() {
    println(square(5)) // Output : 25
}