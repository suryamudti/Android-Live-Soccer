package com.surya.livescoreleague.ui.favorite.favorite_next

import com.surya.livescoreleague.data.db.entities.Event

/**
 * Created by suryamudti on 05/12/2019.
 */
interface FavoriteNextListener {

    fun onStarted()
    fun onSuccess(data: List<Event>?)
    fun onFailure(message: String)

}