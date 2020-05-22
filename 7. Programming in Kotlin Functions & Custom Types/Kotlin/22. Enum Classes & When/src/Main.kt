

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
    val today = DayWeek.Tuesday

    fun singAbouttoday(today : DayWeek){
        when (today) {
            DayWeek.Monday -> println("I don't care if $today's blue")
            DayWeek.Tuesday -> println("$today's gray")
            DayWeek.Wednesday -> println("and  $today's too")
            DayWeek.Thursday -> println("f $today's i dont care about you")
//            DayWeek.Friday -> println("f $today' i ' m in love")
//            DayWeek.Saturday -> println("f $today, waitt")
//            DayWeek.Sunday -> println("f $today always come too late")
            else -> println("I don't feel like singing")
        }
    }

    for (day in DayWeek.values()) {
        singAbouttoday(day)
    }


}

