package com.surya.livescoreleague.ui.teams.team_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.surya.livescoreleague.R
import com.surya.livescoreleague.data.db.entities.Teams
import kotlinx.android.synthetic.main.activity_team_detail.*

class TeamDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)

        val team = intent.getParcelableExtra<Teams>("team")

        supportActionBar?.title = team.strTeam

        view_pager_teams.adapter = TeamDetailPagerAdapter(supportFragmentManager)
        tabLayoutTeams.setupWithViewPager(view_pager_teams)
//        preference = MyPreference(this)
        val id = team.idTeam


    }
}
