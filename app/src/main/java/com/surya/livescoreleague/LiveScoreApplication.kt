package com.surya.livescoreleague

import android.app.Application
import com.surya.livescoreleague.data.db.MyDatabase
import com.surya.livescoreleague.data.network.MyApi
import com.surya.livescoreleague.data.network.NetworkConnectionInterceptor
import com.surya.livescoreleague.data.preferences.PreferencesProvider
import com.surya.livescoreleague.data.repositories.MatchRepository
import com.surya.livescoreleague.ui.league.LeagueViewModelFactory
import com.surya.livescoreleague.ui.match.MatchViewModelFactory
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

    }

}