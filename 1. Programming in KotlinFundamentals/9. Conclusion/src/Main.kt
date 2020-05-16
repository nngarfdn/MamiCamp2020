fun main() {
    val name = "Nanang"
    val lastName = "Arifudin"
    val nickname: String? = null
    val country = "Indonesia"
    val age = 19

    val nameToPrint : String = if (age>= 18) "$name," else ""
    val nicknameToPrint :String = nickname?: ""
    val yearOfBirth = 2019 -  age

    val userData = "$nameToPrint $nickname $lastName, born on $yearOfBirth in $country"
    println(userData)
}