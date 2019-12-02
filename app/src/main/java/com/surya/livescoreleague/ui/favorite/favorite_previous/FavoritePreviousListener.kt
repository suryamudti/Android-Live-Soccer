package com.surya.livescoreleague.ui.favorite.favorite_previous

import com.surya.livescoreleague.data.db.entities.Event

/**
 * Created by suryamudti on 02/12/2019.
 */
interface FavoritePreviousListener {

    fun onStarted()
    fun onSuccess(data: List<Event>?)
    fun onFailure(message: String)
}