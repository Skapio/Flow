import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking {

  fun duelOfTheFates(): Flow<ForceUser> = flow {
    for (forceUser in forceUsers) {
      delay(DELAY)
      log("Battling ${forceUser.name}")
      emit(forceUser)
    }
  }.transform { forceUser ->
    if (forceUser is Sith) {
      forceUser.name = "Darth ${forceUser.name}"
    }
    emit(forceUser)
  }.flowOn(Dispatchers.Default)

  duelOfTheFates().collect {
    log("Battled ${it.name}")
  }
}


