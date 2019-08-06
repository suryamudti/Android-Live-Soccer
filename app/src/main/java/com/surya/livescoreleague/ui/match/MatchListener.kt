package com.surya.livescoreleague.ui.match

import com.surya.livescoreleague.data.db.models.League

/**
 * Created by suryamudti on 06/08/2019.
 */
interface MatchListener {

    fun onStarted()
    fun onSuccess(league: League)
    fun onFailure(message: String)
}