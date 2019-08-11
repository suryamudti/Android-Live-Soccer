package com.surya.livescoreleague.ui.teams

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.ui.league.LeagueViewModel

/**
 * Created by suryamudti on 09/08/2019.
 */
class TeamsViewModelFactory(val repository: MatchRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TeamsViewModel(repository) as T
    }
}