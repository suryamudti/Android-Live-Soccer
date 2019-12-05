package com.surya.livescoreleague.ui.favorite.favorite_players

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.surya.livescoreleague.data.db.entities.Event
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.ui.favorite.favorite_next.FavoriteNextListener
import com.surya.livescoreleague.util.ApiException
import com.surya.livescoreleague.util.Coroutines

class FavoritePlayerViewModel(
    val repository: MatchRepository
) : ViewModel() {



}
