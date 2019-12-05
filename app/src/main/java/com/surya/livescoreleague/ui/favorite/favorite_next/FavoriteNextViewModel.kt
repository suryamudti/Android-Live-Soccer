package com.surya.livescoreleague.ui.favorite.favorite_next

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.surya.livescoreleague.data.db.entities.Event
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.util.ApiException
import com.surya.livescoreleague.util.Coroutines

class FavoriteNextViewModel(
    val repository: MatchRepository
) : ViewModel() {

    private var dataList = MutableLiveData<List<Event>>()

    var listener : FavoriteNextListener? =null

    fun getNextMatch(): LiveData<List<Event>>? {

        Coroutines.io {
            try {
                val matchResponse = repository.getAllLocalEvents(0)

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
