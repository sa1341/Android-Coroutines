package starcarr.co

import kotlinx.coroutines.*

@OptIn(InternalCoroutinesApi::class)
fun main(args: Array<String>) = runBlocking {
    val job = GlobalScope.launch(start = CoroutineStart.LAZY) {
        println("Job Start!")
        delay(5000)
    }

    delay(2000)
    job.cancel(cause = CancellationException("Tired of wating"))

    val cancellation = job.getCancellationException()
    println(cancellation.message)
}





