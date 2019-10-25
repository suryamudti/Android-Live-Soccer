package com.surya.livescoreleague.ui.teams

import android.content.Intent
import android.util.Log
import com.squareup.picasso.Picasso
import com.surya.livescoreleague.R
import com.surya.livescoreleague.data.db.entities.Teams
import com.surya.livescoreleague.databinding.ItemTeamsBinding
import com.surya.livescoreleague.ui.teams.team_detail.TeamDetailActivity
import com.xwray.groupie.databinding.BindableItem

/**
 * Created by suryamudti on 09/08/2019.
 */
class TeamsItem(
    private val team: Teams
) : BindableItem<ItemTeamsBinding>() {

    override fun getLayout() = R.layout.item_teams

    override fun bind(viewBinding: ItemTeamsBinding, position: Int) {

        Picasso.get().load(team.strTeamBadge).into(viewBinding.imgLiga)

        viewBinding.team = team



        viewBinding.root.setOnClickListener {

            Log.e("team ",team.toString())
//            val intent = Intent(it.context, TeamDetailActivity::class.java)
//            intent.putExtra("team",team)
//            it.context.startActivity(intent)
        }
    }
}