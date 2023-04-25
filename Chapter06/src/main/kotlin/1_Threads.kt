import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread
import kotlin.system.exitProcess

fun main() {
//    startingThreads()
//    threadRace()
//    synchronisingThreads()
    sleeping()
}

fun synchronisingThreads() {
    var counter = 0
    val latch = CountDownLatch(100_000)
    repeat(100) {
        thread {
            repeat(1000) {
                synchronized(latch) {
                    counter++
                    latch.countDown()
                }
            }
        }
    }

    latch.await()

    println("Counter $counter")
}

fun threadRace() {
    var counter = 0
    val latch = CountDownLatch(100_000)
    repeat(100) {
        thread {
            repeat(1000) {
                //synchronized(latch) {
                counter++
                latch.countDown()
                //}
            }
        }
    }

    latch.await()

    println("Counter $counter")
}

fun startingThreads() {
    repeat(2) { t ->
        thread {
            for (i in 1..100) {
                println("T$t: $i")
            }
        }
    }
}

fun sleeping() {
    val pool = Executors.newFixedThreadPool(2000)
    val counter = AtomicInteger()
    val start = System.currentTimeMillis()
    try {
        for(i in 0..10_000) {
            pool.submit {
                counter.incrementAndGet()
                Thread.sleep(100)
                counter.incrementAndGet()
            }
//            thread {
//                counter.incrementAndGet()
//                Thread.sleep(100)
//            }
        }
        println("we somehow made it")
    } catch (oome: OutOfMemoryError) {
        println("Spawned ${counter.get()} threads before crashing")
        exitProcess(-42)
    }
    println("Executed ${counter.get() / 2} threads in ${System.currentTimeMillis() - start}ms")
}
