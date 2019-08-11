package com.surya.livescoreleague.ui.teams

import com.surya.livescoreleague.data.db.entities.Teams

/**
 * Created by suryamudti on 09/08/2019.
 */
interface TeamsListener {
    fun onStarted()
    fun onSuccess(data: List<Teams>)
    fun onFailure(message: String)
}