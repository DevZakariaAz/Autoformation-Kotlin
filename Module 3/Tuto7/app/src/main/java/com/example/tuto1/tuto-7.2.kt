package com.example.tuto1

fun main(){
/*
    // Array in Kotlin

    val rockPlanets = arrayOf("Earth" , "Mars", "Venus", "Mercury")
    val gasPlanets  = arrayOf("Jupiter" , "Saturn", "Uranus" , "Neptune")

    val solarSystem = rockPlanets + gasPlanets

    println(solarSystem.contentToString())
    rockPlanets.remove("Mars")
    println(solarSystem[1])
    solarSystem[0] = "little earth"
    println(solarSystem.contentToString())
//    solarSystem[8] = "new planet"
//    println(solarSystem.contentToString())

*/

/*
        // list in Kotlin

        val rockPlanets = listOf<String>("Earth", "Mars", "Venus", "Mercury")

        println(rockPlanets)
        println("Size of the list = " + rockPlanets.size)
        println( "Second element = " + rockPlanets[1])
        println( "Get Third element = " + rockPlanets[2])
        println( "Index of Earth = " + rockPlanets.indexOf("Earth"))
        for(rockPlanet in rockPlanets) {
        println("For each rock planet = " + rockPlanet)
        }
        val gasPlanets = mutableListOf("Jupiter", "Neptune" , "Saturn", "Uranus")
        gasPlanets.add("newPlanet")
        gasPlanets.remove("newPlanet")
        println(gasPlanets)

         // set
        val solarSystem = mutableSetOf("Mercury" , "Venus", "Earth" , "Mars")
        println(solarSystem.size)
        solarSystem.add("new planet")
        println(solarSystem.size)
        println(solarSystem.contains("Pluto"))

*/


    // MutableSet in Kotlin
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