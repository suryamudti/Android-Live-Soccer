package com.surya.livescoreleague.ui.match.match_detail

import androidx.lifecycle.ViewModel
import com.surya.livescoreleague.data.db.entities.Event
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.util.ApiException
import com.surya.livescoreleague.util.Coroutines

/**
 * Created by suryamudti on 09/08/2019.
 */
class MatchDetailViewModel(
    private val repository: MatchRepository
) : ViewModel() {

    var listener : MatchDetailViewModelListener ? = null

    fun getHomeTeam(id : String){
        Coroutines.main {
            try {
                val response = repository.getDetailTeam(id)
                listener?.onShowHomeTeam(response.teams[0])
            }catch (e: ApiException){
                listener?.onFailure(e.message!!)
            }
        }
    }

    fun getAwayTeam(id : String){
        Coroutines.main {
            try {
                val response = repository.getDetailTeam(id)
                listener?.onShowAwayTeam(response.teams[0])
            }catch (e: ApiException){
                listener?.onFailure(e.message!!)
            }
        }
    }

    fun addToFavorite(data: Event,isPrevious:Int){
        repository.insertEvent(data,isPrevious)
    }

    fun deleteFromFavorite(data: Event){
        repository.deleteEvent(data)
    }
}