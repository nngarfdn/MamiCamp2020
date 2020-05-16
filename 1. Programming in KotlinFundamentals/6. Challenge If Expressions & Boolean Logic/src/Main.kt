fun main() {
    val username = "nngarfdn"
    val password = "dsgkldfkgjfdkg"
    val email = "nanangarif404@gmail.com"

//    val message = if (email.isEmpty() || password.isEmpty() || username.isEmpty()){
//        "You must fill in your data"
//    } else if (username.length< 6){
//        "Username need to be at least 6 character long!"
//    } else if (password.length< 8) {
//        "Password need to be at least 8 character long!"
//    } else if ((email.contains("@") && email.contains("."))) {
//        "Invalid email format"
//    } else {
//        "Succesfull regstration"
//    }
//
//    println(message)

    if (email.isEmpty() || password.isEmpty() || username.isEmpty()){
        "You must fill in your data"
    }
       else if (username.length <= 6){
            println("username minimal 6 character")
        } else{
            if (password.length <= 8) {
                println("password minimal 8 character")
            } else{
                if (email.contains("@") && email.contains(".")){
                    println("Data is Valid")
                } else{
                    println("Data is invalid")
                }
            }
        }

}