fun main() {

    fun getFullNameLength(name: String, lastName : String = "") = name.length + lastName.length

    fun getFullNameLength(name: String,midddleName: List<String>, lastName : String = "") :Int {
        val nameLength = name.length + lastName.length
        var midddleNamsde = 0

        for (middle in midddleName) {
            midddleNamsde += middle.length
        }
        return  nameLength + midddleNamsde
    }

    val myNameLength = getFullNameLength("Nanang")
    println(myNameLength)
    val myName = getFullNameLength("NNG", listOf("Nanag","Udin"), "Arif")
    println(myName)
}