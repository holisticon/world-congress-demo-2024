package org.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = blocking()

fun blocking() {
    runBlocking {
        (0..1_000_000).forEach {  // launch a lot of coroutines
            launch {
                println("Thread ${Thread.currentThread().name} no ${it} ")
                delay(10_000L)
            }
        }
    }
}

