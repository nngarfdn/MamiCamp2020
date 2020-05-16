fun main() {

    val myPassword : String? = "12345"
    val myPasswordLength = myPassword?.length?:0
    val message: String = if (myPassword== null || myPassword.isEmpty()){
        "You need to a password for a safe"
    } else if (myPasswordLength  > 0 && myPasswordLength<6) {
        "Weak password Try a few more symbol to it"
    } else if (myPasswordLength> 10){
        "no one is getting through this!"
    } else{
        "Ironclad"
    }

    println(message)
}