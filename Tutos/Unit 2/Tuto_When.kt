// Tuto about Using when in kotlin

fun main() {
    val Color = "Blue"

    val message = when(Color) {
        "Red" -> "Color is Red"
        "Yellow" -> "Color is Yellow."
        "Green" -> "Color is Green"
        else -> "We don't now !!"
    }
    println(message)
}