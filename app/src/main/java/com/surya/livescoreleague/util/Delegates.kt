package com.surya.livescoreleague.util

import kotlinx.coroutines.*

/**
 * Created by suryamudti on 04/08/2019.
 */

fun<T> lazyDeferred(
    block: suspend CoroutineScope.() -> T
): Lazy<Deferred<T>>{

    return lazy {
        GlobalScope.async (
            start = CoroutineStart.LAZY
        ){
            block.invoke(this)
        }
    }
}