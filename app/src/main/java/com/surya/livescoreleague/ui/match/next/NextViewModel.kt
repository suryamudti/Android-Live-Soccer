package com.surya.livescoreleague.ui.match.next

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.surya.livescoreleague.data.db.entities.Event
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.util.ApiException
import com.surya.livescoreleague.util.Coroutines

class NextViewModel(
    private val repository: MatchRepository
) : ViewModel() {

    var dataList = MutableLiveData<List<Event>>()


    var listener : NextListener ? = null


    fun getNextMatch(): LiveData<List<Event>>{
        listener?.onStarted()
        Coroutines.main {
            try {
                val matchResponse = repository.getNextMatch()

                matchResponse.events.let {
                    dataList?.value = it
                    listener?.onSuccess(it)
                    return@main
                }
            }catch (e: ApiException){

                listener?.onFailure(e.message!!)
            }
        }

        return dataList
    }
}
