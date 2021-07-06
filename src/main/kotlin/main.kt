import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

  exampleOf("flowOf")

  val favorites = flowOf(episodeV, episodeIX, episodeIV)

  favorites.collect { movie -> log(movie) }

  exampleOf("asFlow")

  val topAdjustedGrosses = listOf(episodeIV, episodeVII, episodeV)

  topAdjustedGrosses.asFlow().collect { movie -> log(movie) }

}


