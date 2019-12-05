package com.surya.livescoreleague.ui.teams.team_detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;

import com.surya.livescoreleague.data.db.entities.Player
import com.surya.livescoreleague.data.db.entities.Teams
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.ui.teams.TeamsListener
import com.surya.livescoreleague.ui.teams.team_detail.player.PlayerListener
import com.surya.livescoreleague.ui.teams.team_detail.player.player_detail.PlayerDetailListener
import com.surya.livescoreleague.util.ApiException
import com.surya.livescoreleague.util.Coroutines

class TeamDetailViewModel(
    private val repository: MatchRepository
) : ViewModel() {


    var playerListener : PlayerListener ?= null

    var playerDetailListener: PlayerDetailListener ? = null

    var teamListener : TeamsListener ?= null

    private var players = MutableLiveData<List<Player>>()

    private var player = MutableLiveData<Player>()



    fun getDetailPlayer(id: String): MutableLiveData<Player>{

        playerDetailListener?.onStarted()

        Coroutines.main{
            try {
                val response = repository.getDetailPlayer(id)

                Log.e("datas","size players ${response.player?.size}   size player ${response.players?.size}")
                response.players?.get(0)?.let { playerDetailListener?.onSuccess(it) }

                player.value = response.player?.get(0)

            }catch (e: ApiException){
                playerDetailListener?.onFailure("${e.message}")
            }
        }

        return  player
    }

    fun setTeamId(team: Teams){

        team.idTeam?.let {
            repository.setTeamId(it)
        }
    }


}
