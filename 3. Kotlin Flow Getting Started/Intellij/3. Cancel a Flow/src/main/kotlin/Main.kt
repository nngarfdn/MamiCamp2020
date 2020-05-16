import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

fun main()  = runBlocking{
    fun startWarsSounds() = flow {
        for (sound in listOf(chewieSound, r2d2Sound,blasterSound,saberSound)){
            delay(DELAY)
            log("Emitting $sound")
            emit(sound)
        }
    }
    withTimeoutOrNull((3.1 * DELAY).toLong()){
        startWarsSounds().collect { movie -> log(movie) }
    }

    log("Done emitting sounds")

}