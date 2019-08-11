package com.surya.livescoreleague.ui.match.standings

import androidx.lifecycle.ViewModel;
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.util.ApiException
import com.surya.livescoreleague.util.Coroutines

class StandingsViewModel(
    val repository: MatchRepository
) : ViewModel() {

    var listener : StandingsListener ? = null
    fun getStandings(){
        listener?.onStarted()

        Coroutines.main {
            try {
                val response = repository.getStandings()

                response.table.let {
                    listener?.onSuccess(it)
                    return@main
                }
            }catch (e: ApiException){
                listener?.onFailure(e.message!!)
            }
        }
    }


}
