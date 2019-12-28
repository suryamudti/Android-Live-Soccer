package com.surya.livescoreleague.ui.teams

import androidx.lifecycle.ViewModel;
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.util.ApiException
import com.surya.livescoreleague.util.Coroutines

class TeamsViewModel(
    private val repository: MatchRepository
) : ViewModel() {

    /**
     * Define listener will for Handling the events to UI
     * */
    var listener : TeamsListener ? = null

    /**
     * This function will fetch team list data from remote API
     * */
    fun getTeamList(){
        listener?.onStarted()

        Coroutines.main {
            try {
                val response = repository.getTeamList()

                response.let {
                    listener?.onSuccess(it.teams)
                }
            }catch (e: ApiException){
                listener?.onFailure(e.message!!)
            }
        }
    }
}
