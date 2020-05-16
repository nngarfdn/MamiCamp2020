fun main() {
    val myName = "Filip"
    val nickname: String? = null
    val lastName : String? = null

    println(nickname)

    val nickNameLength = nickname?.length?.toDouble()
    println(nickNameLength)

    if (lastName != null) {
        println("My last name is ${lastName.length} character long")
    } else{
        println("I dont have a last name")
    }

    if (nickname?.isEmpty() == true) {
        println("You dont have a nickname! It's length is ${nickname?.length}")
    }

//    val notNulNickname = requireNotNull(nickname)
//    println(notNulNickname.length)

    val myNickname: String = nickname?: myName
    println(myNickname)

    val lastBirthdayYear = 2019
    val myAge : Int? = 23

    val myAgeNotNull : Int = myAge?: return

    val yearBirth = lastBirthdayYear - myAgeNotNull
    println("I'm was born in $yearBirth")

}