package com.surya.livescoreleague.ui.teams.team_detail.player

import com.surya.livescoreleague.data.db.entities.Player

/**
 * Created by suryamudti on 14/08/2019.
 */
interface PlayerListener {
    fun onStarted()
    fun onSuccess(data: List<Player>)
    fun onFailure(message: String)
}