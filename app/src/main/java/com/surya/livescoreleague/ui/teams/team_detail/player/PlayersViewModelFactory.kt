package com.surya.livescoreleague.ui.teams.team_detail.player

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.ui.teams.team_detail.TeamDetailViewModel

/**
 * Created by suryamudti on 25/10/2019.
 */
class PlayersViewModelFactory (val repository: MatchRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PlayersViewModel(repository) as T
    }
}