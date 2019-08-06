package com.surya.livescoreleague.ui.match.previous

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.ui.match.MatchViewModel

/**
 * Created by suryamudti on 06/08/2019.
 */
class PreviousViewModelFactory(val repository: MatchRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PreviousViewModel(repository) as T
    }
}