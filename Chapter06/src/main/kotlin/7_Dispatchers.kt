import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch {
            println("Using basic launch, currently on: ${Thread.currentThread().name}")
        }
        GlobalScope.launch {
            println("Using GlobalScope launch, currently on: ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Default) {
            println("Using Default dispatchers launch, currently on: ${Thread.currentThread().name}")
        }
        launch(Dispatchers.IO) {
            println("Using IO dispatchers launch, currently on: ${Thread.currentThread().name}")
        }
    }
}