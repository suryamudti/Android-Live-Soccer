package com.surya.livescoreleague

import android.app.Application
import com.surya.livescoreleague.data.db.MyDatabase
import com.surya.livescoreleague.data.network.MyApi
import com.surya.livescoreleague.data.network.NetworkConnectionInterceptor
import com.surya.livescoreleague.data.preferences.PreferencesProvider
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.ui.favorite.FavoriteViewModelFactory
import com.surya.livescoreleague.ui.favorite.favorite_teams.FavoriteTeamsViewModelFactory
import com.surya.livescoreleague.ui.league.LeagueViewModelFactory
import com.surya.livescoreleague.ui.match.MatchViewModelFactory
import com.surya.livescoreleague.ui.match.match_detail.MatchDetailViewModelFactory
import com.surya.livescoreleague.ui.match.next.NextViewModelFactory
import com.surya.livescoreleague.ui.match.previous.PreviousViewModelFactory
import com.surya.livescoreleague.ui.match.standings.StandingsViewModelFactory
import com.surya.livescoreleague.ui.teams.TeamsViewModelFactory
import com.surya.livescoreleague.ui.teams.team_detail.TeamDetailViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 * Created by suryamudti on 06/08/2019.
 */
class LiveScoreApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@LiveScoreApplication))
        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { MyDatabase(instance()) }
        bind() from singleton { PreferencesProvider(instance()) }
        bind() from singleton { MatchRepository(instance(),instance(),instance()) }
        bind() from provider { LeagueViewModelFactory(instance()) }
        bind() from provider { MatchViewModelFactory(instance()) }
        bind() from provider { PreviousViewModelFactory(instance()) }
        bind() from provider { NextViewModelFactory(instance()) }
        bind() from provider { StandingsViewModelFactory(instance()) }
        bind() from provider { MatchDetailViewModelFactory(instance())}
        bind() from provider { TeamsViewModelFactory(instance()) }
        bind() from provider { TeamDetailViewModelFactory(instance()) }
        bind() from provider { FavoriteViewModelFactory(instance()) }
        bind() from provider { FavoriteTeamsViewModelFactory(instance())}


    }

}