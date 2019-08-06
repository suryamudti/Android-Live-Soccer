package com.surya.livescoreleague.ui.match.next

import androidx.lifecycle.ViewModel;
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.util.ApiException
import com.surya.livescoreleague.util.Coroutines

class NextViewModel(
    private val repository: MatchRepository
) : ViewModel() {

    var listener : NextListener ? = null


    fun getNextMatch(){

        listener?.onStarted()
        Coroutines.main {
            try {
                val matchResponse = repository.getNextMatch()

                matchResponse.events.let {
                    listener?.onSuccess(it)
                }
            }catch (e: ApiException){

                listener?.onFailure(e.message!!)
            }
        }
    }
}
