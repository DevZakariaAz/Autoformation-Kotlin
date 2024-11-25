// Une simple classe

class Voiture {
    var marque: String = "Inconnue"  // Propriété avec une valeur par défaut
    var modele: String = "Inconnu"   // Une autre propriété
    var annee: Int = 0               // Propriété de type entier

    // Fonction membre (méthode) de la classe
    fun demarrer() {
        println("La voiture démarre.")
    }

    fun details() {
        println("Détails de la voiture : $marque $modele, Année : $annee")
    }
}

// Créer une Instance d’une Classe

fun main() {
    val maVoiture = Voiture()  // Créer une instance de la classe Voiture

    // Accéder et modifier les propriétés
    maVoiture.marque = "Toyota"
    maVoiture.modele = "Corolla"
    maVoiture.annee = 2020

    // Appeler les méthodes
    maVoiture.demarrer()      // Sortie : La voiture démarre.
    maVoiture.details()       // Sortie : Détails de la voiture : Toyota Corolla, Année : 2020
}

// Constructeurs
class Voiture(val marque: String, val modele: String, val annee: Int) {
    fun details() {
        println("Détails de la voiture : $marque $modele, Année : $annee")
    }
}

// Constructeurs Secondaires
class Voiture {
    var marque: String
    var modele: String
    var annee: Int

    // Constructeur primaire
    constructor(marque: String, modele: String, annee: Int) {
        this.marque = marque
        this.modele = modele
        this.annee = annee
    }

    // Constructeur secondaire
    constructor() {
        marque = "Inconnue"
        modele = "Inconnu"
        annee = 0
    }

    fun details() {
        println("Détails de la voiture : $marque $modele, Année : $annee")
    }
}

// Utilisation des deux constructeurs
fun main() {
    val voiture1 = Voiture("Ford", "Mustang", 1969)  // Constructeur primaire
    voiture1.details()  // Sortie : Détails de la voiture : Ford Mustang, Année : 1969

    val voiture2 = Voiture()  // Constructeur secondaire
    voiture2.details()  // Sortie : Détails de la voiture : Inconnue Inconnu, Année : 0
}


// Héritage des Classes :
// Classe parent (super classe)
open class Vehicule(val marque: String) {
    fun klaxonner() {
        println("Bip bip!")
    }
}

// Classe enfant (sous-classe)
class Voiture(marque: String, val modele: String) : Vehicule(marque) {
    fun details() {
        println("Voiture : $marque $modele")
    }
}


// Classes de Données

data class Voiture(val marque: String, val modele: String, val annee: Int)

fun main() {
    val voiture1 = Voiture("Audi", "A4", 2022)
    println(voiture1)  // Sortie : Voiture(marque=Audi, modele=A4, annee=2022)

    // Copie de la voiture avec une année différente
    val voiture2 = voiture1.copy(annee = 2023)
    println(voiture2)  // Sortie : Voiture(marque=Audi, modele=A4, annee=2023)
}
