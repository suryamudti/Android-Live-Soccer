package com.surya.livescoreleague.ui.league

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.surya.livescoreleague.R
import com.surya.livescoreleague.data.db.entities.StaticLeague
import com.surya.livescoreleague.ui.favorite.FavoriteFragment
import com.surya.livescoreleague.ui.match.MatchFragment
import com.surya.livescoreleague.ui.teams.TeamsFragment
import kotlinx.android.synthetic.main.activity_league.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LeagueActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()

    private val factory : LeagueViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        val league = intent.getParcelableExtra<StaticLeague>("league_data")

        supportActionBar?.title = league.name

        val viewModel = ViewModelProviders.of(this,factory).get(LeagueViewModel::class.java)

        league.idLiga?.let { viewModel.setLeagueId(it) }

        bottomFavorites.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.match -> {
                    loadMatchFragment(savedInstanceState)
                }
                R.id.favorites -> {
                    loadFavoriteFragment(savedInstanceState)
                }
                R.id.teams -> {
                    loadTeamsFragment(savedInstanceState)
                }

            }
            true
        }
        bottomFavorites.selectedItemId = R.id.match

    }

    private fun loadFavoriteFragment(savedInstanceState: Bundle?){
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.mainContainerFavorites,
                    FavoriteFragment(), FavoriteFragment::class.java.simpleName
                )
                .commit()
        }
    }

    private fun loadMatchFragment(savedInstanceState: Bundle?){

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.mainContainerFavorites,
                    MatchFragment(), MatchFragment::class.java.simpleName
                )
                .commit()
        }

    }

    private fun loadTeamsFragment(savedInstanceState: Bundle?){
        if (savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainContainerFavorites,
                    TeamsFragment(),TeamsFragment::class.java.simpleName
                ).commit()
        }
    }
}
