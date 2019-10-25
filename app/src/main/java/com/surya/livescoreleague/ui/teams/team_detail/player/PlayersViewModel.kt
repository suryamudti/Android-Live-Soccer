package com.surya.livescoreleague.ui.teams.team_detail.player

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.surya.livescoreleague.data.db.entities.Player
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.util.ApiException
import com.surya.livescoreleague.util.Coroutines

/**
 * Created by suryamudti on 25/10/2019.
 */

class PlayersViewModel(
    private val repository: MatchRepository
) : ViewModel(){

    var playerListener : PlayerListener ?= null

    private var players = MutableLiveData<List<Player>>()

    fun getListPlayers(){


        playerListener?.onStarted()
        Coroutines.main {
            try {


                val response = repository.getListPlayer()
                Log.e("masuk vm", "${response.toString()}")

                response.player?.let { playerListener?.onSuccess(it) }

            }catch (e: ApiException){
                e.message?.let { playerListener?.onFailure(it) }
            }
        }
    }

}