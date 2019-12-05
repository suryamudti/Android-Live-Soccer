package com.surya.livescoreleague.ui.teams.team_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.surya.livescoreleague.R
import com.surya.livescoreleague.data.db.entities.Teams
import com.surya.livescoreleague.ui.main.ViewModelFactory
import kotlinx.android.synthetic.main.activity_team_detail.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class TeamDetailActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()

    private val factory : ViewModelFactory by instance()

    private lateinit var viewModel : TeamDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)

        val team = intent.getParcelableExtra<Teams>("team")
        Log.e("team selected",team.toString())

        supportActionBar?.title = team.strTeam

        viewModel = ViewModelProviders.of(this,factory).get(TeamDetailViewModel::class.java)

        viewModel.setTeamId(team)

        view_pager_teams.adapter = TeamDetailPagerAdapter(supportFragmentManager)
        tabLayoutTeams.setupWithViewPager(view_pager_teams)
    }
}
