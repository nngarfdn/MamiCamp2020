fun main() {
    val creditCard = Triple("25364576324674", "007", "Visa")
    val bankAccount = Pair(16000.0, creditCard)

    val (balance, card) = bankAccount
    val (cardNumber, scurityCode, cardType) = creditCard

    println("The account has $$balance, with cardnumber $cardNumber and cardtype $cardType, security ***" )
}