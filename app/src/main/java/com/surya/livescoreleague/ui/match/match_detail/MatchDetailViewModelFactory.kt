package com.surya.livescoreleague.ui.match.match_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.ui.match.next.NextViewModel

/**
 * Created by suryamudti on 09/08/2019.
 */
class MatchDetailViewModelFactory (val repository: MatchRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MatchDetailViewModel(repository) as T
    }
}