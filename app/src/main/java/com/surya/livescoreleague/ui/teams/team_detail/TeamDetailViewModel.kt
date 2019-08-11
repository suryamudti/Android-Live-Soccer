package com.surya.livescoreleague.ui.teams.team_detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.example.surya.footballmatch.model.Player
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.ui.teams.TeamsListener
import com.surya.livescoreleague.util.ApiException
import com.surya.livescoreleague.util.Coroutines

class TeamDetailViewModel(
    private val repository: MatchRepository
) : ViewModel() {


    var teamListener : TeamsListener ?= null

    private var players = MutableLiveData<List<Player>>()


    fun getListPlayers(id: String): MutableLiveData<List<Player>>{

        Coroutines.main {
            try {

            }catch (e: ApiException){

            }

        }

        return players
    }

}
