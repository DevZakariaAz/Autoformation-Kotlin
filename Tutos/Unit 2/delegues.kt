interface  Base {
    fun print()
}
open class BaseImpl(val text: String) : Base{
    override fun print() {
        print(text)
    }
}

class drived(b: Base) : Base by b

fun main() {
    val basse = BaseImpl("Hello delegation")
    drived(basse).print()
}