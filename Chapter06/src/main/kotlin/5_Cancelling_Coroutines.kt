import kotlinx.coroutines.*

fun main() = runBlocking {
    val cancellable = launch {
        try {
            for (i in 1..30) {
                println("Cancellable: $i")
                if (i > 15) {
                    yield()
                }
            }
        } catch (e: CancellationException) {
            e.printStackTrace()
        }
    }

    val notCancellable = launch {
        for (i in 1..1_000) {
            if (i % 100 == 0) {
                println("Not cancellable $i")
//                if (i > 300) {
//                    yield()
//                }
            }
        }
    }
    cancellable.join()
    println("Canceling cancellable")
    cancellable.cancel()

    notCancellable.join()
    println("Canceling not cancellable")
    notCancellable.cancel()
}