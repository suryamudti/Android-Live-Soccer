package com.surya.livescoreleague.ui.match.standings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.ui.match.previous.PreviousViewModel

/**
 * Created by suryamudti on 06/08/2019.
 */

class StandingsViewModelFactory (val repository: MatchRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StandingsViewModel(repository) as T
    }
}