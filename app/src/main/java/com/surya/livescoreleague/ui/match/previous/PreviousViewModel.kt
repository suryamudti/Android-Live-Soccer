package com.surya.livescoreleague.ui.match.previous

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.surya.livescoreleague.data.db.entities.Event
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.util.ApiException
import com.surya.livescoreleague.util.Coroutines

class PreviousViewModel(
    val repository: MatchRepository
) : ViewModel() {

    private var dataList = MutableLiveData<List<Event>>()

    var listener : PreviousListener ? = null

    fun getPreviousMatch() : MutableLiveData<List<Event>>? {

        listener?.onStarted()

        Coroutines.main {
            try {
                val matchResponse = repository.getPreviousMatch()

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
