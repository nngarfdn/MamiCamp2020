import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

suspend fun main() {
    exampleOf("flowOf")

    val favorites = flowOf(episodeV, episodeIX, episodeIV)

    favorites.collect { movie -> log(movie) }

    exampleOf("asFlow")

    val topAdjstedGrosses = listOf(episodeIV, episodeVII, episodeVIII)

    topAdjstedGrosses.asFlow().collect { movie -> log(movie) }

}