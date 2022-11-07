package starcarr.co

import kotlinx.coroutines.*

fun main() = runBlocking {
    val newDispatcher = newSingleThreadContext(name = "ServiceCall")
    val task = GlobalScope.launch(newDispatcher) {
        printCurrentThread()
    }
    task.join()
    println("Completed")
}

