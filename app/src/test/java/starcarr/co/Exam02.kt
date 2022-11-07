package starcarr.co

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val task = GlobalScope.launch {
        //doSomething2()
        printCurrentThread()
    }
    task.join()
    println("Completed")
}

fun printCurrentThread() {
    println("Running in thread [${Thread.currentThread().name}]")
}


fun doSomething2() {
    throw UnsupportedOperationException("Can't do")
}