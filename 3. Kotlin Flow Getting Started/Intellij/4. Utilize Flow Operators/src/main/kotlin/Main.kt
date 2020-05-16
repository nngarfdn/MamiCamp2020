import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking{
    exampleOf("filter operator")

    forceUsers.asFlow()
        .filter { forceUser -> forceUser is Jedi }
        .collect { forceUsers -> log(forceUsers.name) }

    exampleOf("map operaor")

    suspend fun bestowSithtitle (forceUser: ForceUser) : String {
        delay(DELAY)
        return "Darth ${forceUser.name}"
    }

    val sith = forceUsers.asFlow()
        .filter { forceUser -> forceUser is Sith }
        .map { sith -> bestowSithtitle(sith) }

    sith.collect { sitName -> log(sitName) }

    exampleOf("trasform operator")

    forceUsers.asFlow()
        .transform { forceUsers ->
            if (forceUsers is Sith) {
                emit("Turning ${forceUsers.name} to the Dark side)")
                emit(bestowSithtitle(forceUsers))
            }
        }
        .collect { log(it) }

    exampleOf("size-limiting operators")

    sith.take(2).collect { log(it) }
    
    exampleOf("terminal operators")
    
    val jediLineage = forceUsers.asFlow()
        .filter { it is Jedi }
        .map { it.name }
        .reduce { a,b-> "$a trained by $b"  }

}