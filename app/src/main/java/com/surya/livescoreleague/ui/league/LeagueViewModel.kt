package com.surya.livescoreleague.ui.league

import androidx.lifecycle.ViewModel
import com.surya.livescoreleague.data.repositories.MatchRepository

/**
 * Created by suryamudti on 06/08/2019.
 */

class LeagueViewModel(
    val repository: MatchRepository
) : ViewModel(){

    fun setLeagueId(id: String){
        repository.setLeagueId(id)
    }



}