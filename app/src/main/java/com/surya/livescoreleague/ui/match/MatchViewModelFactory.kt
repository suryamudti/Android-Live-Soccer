package com.surya.livescoreleague.ui.match

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.ui.league.LeagueViewModel

/**
 * Created by suryamudti on 06/08/2019.
 */
class MatchViewModelFactory(val repository: MatchRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MatchViewModel(repository) as T
    }
}