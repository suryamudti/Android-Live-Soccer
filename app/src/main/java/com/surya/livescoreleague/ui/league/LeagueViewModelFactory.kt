package com.surya.livescoreleague.ui.league

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.surya.livescoreleague.data.repositories.MatchRepository

/**
 * Created by suryamudti on 06/08/2019.
 */
class LeagueViewModelFactory(val repository: MatchRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LeagueViewModel(repository) as T
    }
}