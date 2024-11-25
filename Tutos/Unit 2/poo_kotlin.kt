// Exemple de Héritage
open class Animal(val nom: String) {
    fun dormir() {
        println("$nom dort.")
    }
}

// Classe enfant
class Chien(nom: String) : Animal(nom) {
    fun aboyer() {
        println("$nom aboie.")
    }
}

fun main() {
    val monChien = Chien("Rex")
    monChien.dormir()  // Hérité de la classe Animal
    monChien.aboyer()  // Méthode propre à Chien
}


/*==================================================*/

// Exemple de Polymorphisme
open class Forme {
    open fun dessiner() {
        println("Dessiner une forme")
    }
}

// Classe enfant
class Cercle : Forme() {
    override fun dessiner() {
        println("Dessiner un cercle")
    }
}

// Classe enfant
class Rectangle : Forme() {
    override fun dessiner() {
        println("Dessiner un rectangle")
    }
}

fun main() {
    val formes: List<Forme> = listOf(Cercle(), Rectangle())

    for (forme in formes) {
        forme.dessiner()  // Appel polymorphique
    }
}


/*==================================================*/

// Exemple de Encapsulation
class CompteBancaire(private var solde: Double) {

    fun deposer(montant: Double) {
        if (montant > 0) {
            solde += montant
            println("Dépôt de $montant, nouveau solde : $solde")
        } else {
            println("Montant invalide")
        }
    }

    fun retirer(montant: Double) {
        if (montant > 0 && montant <= solde) {
            solde -= montant
            println("Retrait de $montant, nouveau solde : $solde")
        } else {
            println("Fonds insuffisants")
        }
    }
}

fun main() {
    val monCompte = CompteBancaire(100.0)
    monCompte.deposer(50.0)
    monCompte.retirer(30.0)
}


/*==================================================*/

// Exemple de Abstraction
abstract class Vehicule {
    abstract fun demarrer()  // Méthode abstraite sans implémentation
}

// Classe concrète
class Voiture : Vehicule() {
    override fun demarrer() {
        println("La voiture démarre.")
    }
}

fun main() {
    val maVoiture = Voiture()
    maVoiture.demarrer()  // Implémentation de la méthode abstraite
}

// Sortie : La voiture démarre.

