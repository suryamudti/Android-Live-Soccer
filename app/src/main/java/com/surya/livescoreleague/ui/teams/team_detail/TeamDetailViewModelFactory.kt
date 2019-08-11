package com.surya.livescoreleague.ui.teams.team_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.ui.teams.TeamsViewModel

/**
 * Created by suryamudti on 09/08/2019.
 */
class TeamDetailViewModelFactory(val repository: MatchRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TeamDetailViewModel(repository) as T
    }
}