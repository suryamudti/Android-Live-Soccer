package com.surya.livescoreleague.ui.match.previous

import androidx.lifecycle.ViewModel;
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.util.ApiException
import com.surya.livescoreleague.util.Coroutines

class PreviousViewModel(
    val repository: MatchRepository
) : ViewModel() {

    var listener : PreviousListener ? = null

    fun getPreviousMatch(){

        listener?.onStarted()

        Coroutines.main {
            try {
                val matchResponse = repository.getPreviousMatch()

                matchResponse.events.let {
                    listener?.onSuccess(it)
                }
            }catch (e: ApiException){
                listener?.onFailure(e.message!!)
            }
        }

    }
}
