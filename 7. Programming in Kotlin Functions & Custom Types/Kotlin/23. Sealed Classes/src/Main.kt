
sealed class AcceptedCurrency {
    abstract val valueInDollar : Float
    var amount : Float = 0.0f


    class Dollar: AcceptedCurrency() {
        override val valueInDollar = 1.0f
    }
    class Euro :AcceptedCurrency(){
        override val valueInDollar = 1.25f
    }
    class Crypto : AcceptedCurrency() {
        override val valueInDollar = 2534.92f
    }

    val name : String
    get() =  when(this) {
        is Euro -> "Euro"
        is Dollar -> "Dollars"
        is Crypto -> "MeowCoin"
    }

    fun totalValueInDollars() : Float {
        return amount * valueInDollar
    }
}

fun main() {
    val currency = AcceptedCurrency.Crypto()
    println("You've got some ${currency.name}")
    currency.amount = .27541f
    println("${currency.amount} of ${currency.name} is ${currency.totalValueInDollars()} in Dollars")
}