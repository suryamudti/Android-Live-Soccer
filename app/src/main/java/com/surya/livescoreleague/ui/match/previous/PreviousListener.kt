package com.surya.livescoreleague.ui.match.previous

import com.surya.livescoreleague.data.db.entities.Event

/**
 * Created by suryamudti on 06/08/2019.
 */
interface PreviousListener {

    fun onStarted()
    fun onSuccess(data: List<Event>)
    fun onFailure(message: String)
}