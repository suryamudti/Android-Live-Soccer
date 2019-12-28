package com.surya.livescoreleague.ui.match

import androidx.lifecycle.ViewModel
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.util.ApiException
import com.surya.livescoreleague.util.Coroutines

class MatchViewModel(
    val repository: MatchRepository
) : ViewModel() {

    /**
     * Define listener will for Handling the events to UI
     * */
    var matchListener : MatchListener ? = null

    /**
     * This function will fetch Detail League data from remote API
     * */
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
