
open class Animal{
    open fun speak() {    }
}

class  WildAnimal (val isPoisonous : Boolean) : Animal()

open class Pet : Animal {
    val name : String

    constructor(name : String) {
        this.name = name
    }

    fun play () {
        println("Playtime!.. noew neptime")
    }

    override fun speak() {
        println("Hi I'm $name! I am cute. Pet me !")
    }
}

class Cat  (name : String) : Pet(name)  {
    override fun speak() {
        println("I can has Cheezburger")
    }
}

fun main() {
    fun printElevatorPitch (animal: Animal){
        when {
            (animal as? WildAnimal != null ) -> {
                println(if (animal.isPoisonous)
                "It's only a little poisonous"
                else "Its not poisonous at all!"
                )
            }
            animal is Cat -> {
                println("Its a kitti named ${animal.name}! I 've always wanted a kitty")
                animal.speak()
            }

            (animal as? Pet) != null -> {
                println("This is definity a normal sort of pet an I've name them ${animal.name}")
                animal.speak()
                animal.play()
            }
            else -> { println("It's Anial! You know, the muppet ?")}
         }
    }

    val animal = Animal()
    val babyAragog = WildAnimal (true)
    val babySmaug = WildAnimal(false)
    val gamtoro = Pet("Hamtoro")
    val ozma = Cat("Ozma")

    val animals = arrayOf(animal, babyAragog, babySmaug, gamtoro, ozma)
    animals.forEach { printElevatorPitch(it) }

}