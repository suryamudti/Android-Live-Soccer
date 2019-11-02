package com.surya.livescoreleague.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.ui.favorite.FavoriteViewModel
import com.surya.livescoreleague.ui.favorite.favorite_next.FavoriteNextViewModel
import com.surya.livescoreleague.ui.favorite.favorite_players.FavoritePlayerViewModel
import com.surya.livescoreleague.ui.favorite.favorite_previous.FavoritePreviousViewModel
import com.surya.livescoreleague.ui.favorite.favorite_teams.FavoriteTeamsViewModel
import com.surya.livescoreleague.ui.league.LeagueViewModel
import com.surya.livescoreleague.ui.match.MatchViewModel
import com.surya.livescoreleague.ui.match.match_detail.MatchDetailViewModel
import com.surya.livescoreleague.ui.match.next.NextViewModel
import com.surya.livescoreleague.ui.match.previous.PreviousViewModel
import com.surya.livescoreleague.ui.match.standings.StandingsViewModel
import com.surya.livescoreleague.ui.teams.TeamsViewModel
import com.surya.livescoreleague.ui.teams.team_detail.TeamDetailViewModel
import com.surya.livescoreleague.ui.teams.team_detail.player.PlayersViewModel

/**
 * Created by suryamudti on 02/11/2019.
 */
class ViewModelFactory(val repository: MatchRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MatchViewModel::class.java))
            return MatchViewModel(repository) as T
        else if (modelClass.isAssignableFrom(NextViewModel::class.java))
            return NextViewModel(repository) as T
        else if(modelClass.isAssignableFrom(PreviousViewModel::class.java))
            return PreviousViewModel(repository) as T
        else if(modelClass.isAssignableFrom(MatchDetailViewModel::class.java))
            return MatchDetailViewModel(repository) as T
        else if(modelClass.isAssignableFrom(StandingsViewModel::class.java))
            return StandingsViewModel(repository) as T
        else if(modelClass.isAssignableFrom(PlayersViewModel::class.java))
            return PlayersViewModel(repository) as T
        else if (modelClass.isAssignableFrom(LeagueViewModel::class.java))
            return LeagueViewModel(repository) as T
        else if(modelClass.isAssignableFrom(FavoriteViewModel::class.java))
            return FavoriteViewModel(repository) as T
        else if(modelClass.isAssignableFrom(TeamsViewModel::class.java))
            return TeamsViewModel(repository) as T
        else if(modelClass.isAssignableFrom(TeamDetailViewModel::class.java))
            return TeamDetailViewModel(repository) as T
        else if (modelClass.isAssignableFrom(LeagueViewModel::class.java))
            return LeagueViewModel(repository) as T
        else if (modelClass.isAssignableFrom(FavoriteNextViewModel::class.java))
            return FavoriteNextViewModel(repository) as T
        else if (modelClass.isAssignableFrom(FavoritePreviousViewModel::class.java))
            return FavoritePreviousViewModel(repository) as T
        else if (modelClass.isAssignableFrom(FavoritePlayerViewModel::class.java))
            return FavoritePlayerViewModel(repository) as T
        else if (modelClass.isAssignableFrom(FavoriteTeamsViewModel::class.java))
            return FavoriteTeamsViewModel(repository) as T

        throw IllegalArgumentException("Unknown ViewModel class")


    }
}