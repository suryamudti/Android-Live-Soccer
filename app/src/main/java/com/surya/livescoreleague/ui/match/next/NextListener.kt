package com.surya.livescoreleague.ui.match.next

import com.surya.livescoreleague.data.db.entities.Event

/**
 * Created by suryamudti on 06/08/2019.
 */
interface NextListener {

    fun onStarted()
    fun onSuccess(data: List<Event>)
    fun onFailure(message: String)
}