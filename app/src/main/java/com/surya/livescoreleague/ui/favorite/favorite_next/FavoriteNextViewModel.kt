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

    /**
     * Define observable data for list of event
     * */
    private var dataList = MutableLiveData<List<Event>>()

    /**
     * Define listener will for Handling the events to UI
     * */
    var listener : FavoriteNextListener? =null

    /**
     * This function will get next match favorite
     * @return type should return List of Event LiveData
     * */
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
