package com.surya.livescoreleague.ui.favorite.favorite_previous

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.surya.livescoreleague.data.db.entities.Event
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.util.ApiException
import com.surya.livescoreleague.util.Coroutines

class FavoritePreviousViewModel(
    val repository: MatchRepository
) : ViewModel() {

    private var dataList = MutableLiveData<List<Event>>()

    var listener: FavoritePreviousListener ? = null

    fun getPreviousMatch() : LiveData<List<Event>>? {

        listener?.onStarted()

        Coroutines.io {
            try {
                val matchResponse = repository.getAllLocalEvents(1)

                matchResponse?.let {
                    dataList.postValue(it)
                }
            }catch (e: ApiException){
                listener?.onFailure(e.message!!)
            }
        }

        return dataList

    }



}
