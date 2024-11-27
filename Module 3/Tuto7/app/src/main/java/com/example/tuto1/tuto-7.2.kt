package com.example.tuto1

fun main(){

   /* //array
    val rockPlanets = arrayOf<String>("Earth" , "Mars", "Venus", "Mercury")
    val gasPlanets = arrayOf("Jupiter" , "Saturn", "Uranus" , "Neptune")
    val solarSystem= rockPlanets + gasPlanets
    println(solarSystem.contentToString())
    println(solarSystem[1])
    solarSystem[0] = "little earth"
    println(solarSystem.contentToString())
   // solarSystem[8] = "new planet"
    //println(solarSystem.contentToString())

*/
    /*
    // list

    val rockPlanets = listOf<String>("Earth", "Mars", "Venus", "Mercury")

    println(rockPlanets)
    println(rockPlanets.size)
    println(rockPlanets[1])
    println(rockPlanets.get(1))
    println(rockPlanets.indexOf("Earth"))
    for(rockPlanet in rockPlanets) {
    println(rockPlanet)
    }
    val gasPlanets = mutableListOf("Jupiter", "Neptune" , "Saturn", "Uranus")
    gasPlanets.add("newPlanet")
    println(gasPlanets)

     // set
    val solarSystem = mutableSetOf("Mercury" , "Venus", "Earth" , "Mars")
    println(solarSystem.size)
    solarSystem.add("new planet")
    println(solarSystem.size)
    println(solarSystem.contains("Pluto"))


*/
    val solarSystem = mutableMapOf(
        "Mercury" to 0 ,
        "Venus" to 0 ,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )
    println(solarSystem.size)
    solarSystem["pluto"] = 5
    println(solarSystem.size)
    println(solarSystem["pluto"])
    println(solarSystem.get("Theia"))

}