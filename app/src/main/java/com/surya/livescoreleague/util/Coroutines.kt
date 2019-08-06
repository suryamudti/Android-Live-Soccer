package com.surya.livescoreleague.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by suryamudti on 06/08/2019.
 */
object Coroutines {

    fun main(work: suspend(()-> Unit)) =
        CoroutineScope(Dispatchers.Main).launch {
            work()
        }

    fun io(work: suspend(()-> Unit)) =
        CoroutineScope(Dispatchers.IO).launch {
            work()
        }

}