package com.surya.livescoreleague.ui.teams.team_detail.player.player_detail

import com.surya.livescoreleague.data.db.entities.Player

/**
 * Created by suryamudti on 14/08/2019.
 */
interface PlayerDetailListener {
    fun onStarted()
    fun onSuccess(data: Player)
    fun onFailure(message: String)

}