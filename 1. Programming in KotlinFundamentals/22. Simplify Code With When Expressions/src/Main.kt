fun main() {
    val myAge = 23

    val message = when(myAge) {
        in 0..12 -> "Still young"
        in 13..19 -> "Teenager"
        in 20..29 -> "In my twenties"
        in 30..39 -> "In my thirties"
        in 40..49 -> "In mu forties"
        else -> "I'm a wise man"
    }

    println(message)

    val email : String? = "mail@gmail.com"
    val password : String? = "ilskbjksjd"

    when {
        email == null || email.isEmpty() -> {
            println("You need to choose an email!")
        }

        "@" !in email -> {
            println("Email is invalid")
        }

        password == null || password.isEmpty() -> {
            println("you need to choose password")
        }

        password.length < 10 -> {
            println("Password not strong enough!")
        }

        else  -> {
            println(" Email length ${email.length}, Password length : ${password.length}")
        }

    }
}