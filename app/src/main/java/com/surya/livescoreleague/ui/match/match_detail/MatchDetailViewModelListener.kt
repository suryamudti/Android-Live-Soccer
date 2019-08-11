package com.surya.livescoreleague.ui.match.match_detail

import com.surya.livescoreleague.data.db.entities.Teams

/**
 * Created by suryamudti on 09/08/2019.
 */
interface MatchDetailViewModelListener {

    fun onStarted()
    fun onShowHomeTeam(team: Teams)
    fun onShowAwayTeam(team: Teams)
    fun onFailure(message: String)

}