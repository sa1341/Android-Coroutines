package starcarr.co

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

@OptIn(InternalCoroutinesApi::class)
fun main(args: Array<String>) = runBlocking {

    val time = measureTimeMillis {
        val job = GlobalScope.launch(start = CoroutineStart.LAZY) {
            println("Job Start!")
            delay(2000)
        }

        job.join()


        // Restart the job
        job.start()
        job.join()
    }

    println("Took $time ms")
}





