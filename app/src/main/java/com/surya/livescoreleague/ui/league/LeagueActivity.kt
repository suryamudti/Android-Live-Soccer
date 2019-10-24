package com.surya.livescoreleague.ui.league

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
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

    private lateinit var activedFragment : Fragment
    private lateinit var f1 : Fragment
    private lateinit var f2 : Fragment
    private lateinit var f3 : Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        f1 = MatchFragment()
        f2 = FavoriteFragment()
        f3 = TeamsFragment()

        val league = intent.getParcelableExtra<StaticLeague>("league_data")

        supportActionBar?.title = league.name

        val viewModel = ViewModelProviders.of(this,factory).get(LeagueViewModel::class.java)

        league.idLiga?.let { viewModel.setLeagueId(it) }

        activedFragment = f1

        supportFragmentManager
            .beginTransaction()
            .add(R.id.mainContainerFavorites,f3,"3")
            .hide(f3).commit()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.mainContainerFavorites,f2,"2")
            .hide(f2).commit()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.mainContainerFavorites,f1,"1")
            .commit()

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
                .hide(activedFragment)
                .show(f2)
                .commit()
            activedFragment = f2

        }
    }

    private fun loadMatchFragment(savedInstanceState: Bundle?){
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .hide(activedFragment)
                .show(f1)
                .commit()
            activedFragment = f1
        }
    }

    private fun loadTeamsFragment(savedInstanceState: Bundle?){
        if (savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .hide(activedFragment)
                .show(f3)
                .commit()
            activedFragment = f3
        }
    }
}
