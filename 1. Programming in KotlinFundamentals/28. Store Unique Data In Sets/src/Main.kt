fun main() {

    val userIds = setOf("ID1B", "ID2C", "ID3F", "ID8I")
    println(userIds)

    println(userIds.contains("ID3F"))
    println("ID1B" in userIds)

    val mutableList = userIds.toMutableSet()

    println(mutableList.add("ID0Z"))
    println(mutableList)

    println(mutableList.add("ID1B"))
    println(mutableList)

    for (userId in mutableList){
        println(userId)
    }

    val name = arrayOf("Philip", "Brian", "Joe", "Ted", "John", "Philip")
    println(name)

    val uniqueNames = name.toSet()
    println(uniqueNames)
}