import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import java.util.concurrent.Flow

suspend fun main() = runBlocking {
    exampleOf("Sequence (blocks main thread)")

    fun prequels(): Sequence<String> = sequence {

        for (movie in listOf(episodeI, episodeII, episodeIII)) {
            Thread.sleep(DELAY)
            yield(movie)
        }
    }
    prequels().forEach { movie -> log(movie) }

    log("Something else to be done here")

    exampleOf("suspending fuction (asynchronous)")

    suspend fun original(): List<String> {
    delay(DELAY)
    return listOf(episodeIV, episodeV, episodeVI)
    }

    launch {
        original().forEach{movie -> log(movie)}
    }
    log("Sometimes else to be done here.")
    delay(2 * DELAY)
    exampleOf("Simple flow")

    fun sequels(): kotlinx.coroutines.flow.Flow<String> = flow {
        for (movie in listOf(episodeVII, episodeVIII,episodeIX)) {
            delay(DELAY)
            emit(movie)
        }
    }

    launch {
        sequels().collect { movie -> log(movie) }
    }

    launch {
        for (i in 1..3) {
            log("Not blocked $i")
            delay(DELAY)
        }
    }

    log("Someting else to be done here.")

    delay(4 * DELAY)
    exampleOf("Cold stream")

    val sequelFilms = sequels()

    sequelFilms.collect{movie -> log(movie)}

    delay(3 * DELAY)
    exampleOf("Collecting again")

    sequelFilms.collect { movie -> log(movie) }
}


