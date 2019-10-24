package com.surya.livescoreleague.ui.favorite.favorite_teams

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.surya.livescoreleague.data.repositories.MatchRepository

/**
 * Created by suryamudti on 25/10/2019.
 */
class FavoriteTeamsViewModelFactory(val repository: MatchRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FavoriteTeamsViewModel(repository) as T
    }
}