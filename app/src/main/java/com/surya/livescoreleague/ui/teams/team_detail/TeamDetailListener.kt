package com.surya.livescoreleague.ui.teams.team_detail

import com.example.surya.footballmatch.model.Player

/**
 * Created by suryamudti on 09/08/2019.
 */
interface TeamDetailListener {
    fun onStarted()
    fun onSuccess(data: List<Player>)
    fun onFailure(message: String)
}