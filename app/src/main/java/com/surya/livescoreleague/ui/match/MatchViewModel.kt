package com.surya.livescoreleague.ui.match

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel;
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.util.ApiException
import com.surya.livescoreleague.util.Coroutines

class MatchViewModel(
    val repository: MatchRepository
) : ViewModel() {

    var matchListener : MatchListener ? = null

    fun getDetailLeague(){
        matchListener?.onStarted()

        Coroutines.main {
            try {
                val leagueResponse = repository.getLeagueDetail()

                leagueResponse.leagues.get(0).let {
                    matchListener?.onSuccess(it)
                }
            }catch (e : ApiException){
                matchListener?.onFailure(e.message!!)
            }
        }



    }



}
