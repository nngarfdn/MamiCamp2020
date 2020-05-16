import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    fun duelOfTheFates() : Flow<ForceUser> = flow {
        for (forceUser in forceUsers) {
            delay(DELAY)
            log("Baitting ${forceUser.name}")
            emit(forceUser)
        }
    }.transform { forceUsers->
        if (forceUsers is Sith) {
            forceUsers.name = "Darth ${forceUsers.name}"
        }
        emit(forceUsers)
    }.flowOn(Dispatchers.Default)

    duelOfTheFates().collect { log("Battled ${it.name}") }
}