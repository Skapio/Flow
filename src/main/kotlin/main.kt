import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() = runBlocking {

  fun starWarsSounds() = flow {
    for (sound in listOf(chewieSound, r2d2Sound, blasterSound, saberSound)) {
      delay(DELAY)
      log("Emitting $sound")
      emit(sound)
    }
  }

  withTimeoutOrNull((3.1 * DELAY).toLong()) {
    starWarsSounds().collect { sound -> log(sound) }
  }

  log("Done emitting sounds")

}


