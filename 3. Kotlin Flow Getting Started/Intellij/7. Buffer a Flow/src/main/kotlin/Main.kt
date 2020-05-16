import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun jediTrainees(): Flow<ForceUser> = forceUsers.asFlow()
    .transform { forceUsers ->
        if (forceUsers is Padawan) {
            delay(DELAY)
            emit(forceUsers)
        }
    }

fun main() = runBlocking {

    var time= measureTimeMillis {
        jediTrainees()
            .collect { jedi ->
                delay(3 * DELAY)
                log("Jedi ${jedi.name} is now a Jedi Master")
            }
    }

    log("Total time $time ms")

    exampleOf("buffer")

    time= measureTimeMillis {
        jediTrainees().buffer()
            .collect { jedi ->
                delay(3 * DELAY)
                log("Jedi ${jedi.name} is now a Jedi Master")
            }
    }

    log("Total time $time ms")

    exampleOf("conflate")

    time= measureTimeMillis {
        jediTrainees().conflate()
            .collect { jedi ->
                delay(3 * DELAY)
                log("Jedi ${jedi.name} is now a Jedi Master")
            }
    }

    log("Total time $time ms")


    exampleOf("collectLatest")

    time= measureTimeMillis {
        jediTrainees().collectLatest()
             { jedi ->
                 log("Jedi Master training for ${jedi.name}")
                delay(3 * DELAY)
                log("Jedi ${jedi.name} is now a Jedi Master")
            }
    }

    log("Total time $time ms")
}