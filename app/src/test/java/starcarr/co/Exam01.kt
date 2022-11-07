package starcarr.co

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val task = GlobalScope.async {
        doSomething()
    }
    task.await()
    println("Completed")
}


fun doSomething() {
    throw UnsupportedOperationException("Can't do")
}