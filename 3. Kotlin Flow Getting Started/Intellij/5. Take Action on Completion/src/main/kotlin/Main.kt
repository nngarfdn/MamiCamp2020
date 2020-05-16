import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    fun turnToDarkSide(): Flow<ForceUser> = forceUsers.asFlow()
        .transform { forceUsers ->
            if (forceUsers is Jedi) {
                emit(Sith(forceUsers.name))
            }
        }

    exampleOf("Imperative completion")

    try {
        turnToDarkSide().collect { sith ->
            log("${sith.name}, your journey to the Dark Side is now  complete.")
        }
    } finally {
        log("Everyting is proceeding as I have foreseen")
    }

    exampleOf("Declarative completion")
    turnToDarkSide()
        .onCompletion { log("Everyting is proceeding as I have foreseen") }
        .collect { sith ->
        log("${sith.name}, your journey to the Dark Side is now  complete.")
    }

}