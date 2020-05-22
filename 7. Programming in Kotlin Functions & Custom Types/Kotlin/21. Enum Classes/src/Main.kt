

enum class DayWeek (val isWeekend : Boolean= false){
    Monday, Tuesday, Wednesday, Thursday, Friday, Saturday(true), Sunday(true);

    fun dayUntil(other : DayWeek) : Int {
        if (this.ordinal < other.ordinal){
            return other.ordinal - this.ordinal
        } else {
            return  other.ordinal - this.ordinal + DayWeek.values().count()
        }
    }
}

fun main() {
    for(day in DayWeek.values()) {
        println("Day ${day.ordinal}: ${day.name}, is weekend ${day.isWeekend} ")
    }

    val friday = DayWeek.Friday
    println(DayWeek.Tuesday.dayUntil(friday))

}

