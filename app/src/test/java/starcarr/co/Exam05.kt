package starcarr.co

import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking {
    val job = GlobalScope.launch(start = CoroutineStart.LAZY) {
        println("Job Start!")
        delay(5000)
    }

    delay(2000)
    job.cancel()
}





