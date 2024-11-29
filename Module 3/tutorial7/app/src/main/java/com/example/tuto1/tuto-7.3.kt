package com.example.tuto1

class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)
val cookies = listOf(
    Cookie(
        name = "Chocolate Chips" ,
        softBaked = false ,
        hasFilling = false ,
        price = 1.69
    ),
    Cookie(
        name = "Banan Walnut" ,
        softBaked = true ,
        hasFilling = false ,
        price = 1.49
    ),
    Cookie(
        name = "Chocolate Peanut Butter" ,
        softBaked = false ,
        hasFilling = true ,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)
fun main(){
    /*  cookies.forEach(){
          println("menu item : ${it.name}")
      }


      val fullMenu = cookies.map {
         "${it.name} - $${it.price}"
      }
      println("full menu : ")
      fullMenu.forEach{
          println("- $it") ;
      }
      val softBakedMenu = cookies.filter {
          it.softBaked
      }
      softBakedMenu.forEach {
          println(it.name)
      }
      val groupedMenu = cookies.groupBy {
          it.softBaked
      }
      val crunchyMenu = groupedMenu[false]?: listOf()
    val softBakedMenu = groupedMenu[true]?: listOf()

      println("Soft cookies : ")
      softBakedMenu.forEach {
          println(it.name)
      }
      println(" crunchy cookies :")
      crunchyMenu.forEach{
         println(it.name)
      }
      val totalPrice = cookies.fold(0.0){
          total , cookie-> total+ cookie.price
      }
      println("total price : $totalPrice$")*/
    val alphabetMenu = cookies.sortedBy {
        it.name
    }
    alphabetMenu.forEach {
        println(it.name)
    }
}