package com.surya.livescoreleague.ui.teams.team_detail.player.player_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import com.surya.livescoreleague.R
import com.surya.livescoreleague.data.db.entities.Player
import com.surya.livescoreleague.databinding.ActivityPlayerDetailBinding
import com.surya.livescoreleague.ui.main.ViewModelFactory
import com.surya.livescoreleague.ui.teams.team_detail.TeamDetailViewModel
import com.surya.livescoreleague.util.toast
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class PlayerDetailActivity : AppCompatActivity(), KodeinAware, PlayerDetailListener {

    override val kodein by kodein()
    private val factory : ViewModelFactory by instance()
    private lateinit var binding : ActivityPlayerDetailBinding
    private lateinit var viewModel : TeamDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val playerid = intent.getStringExtra("playerid")

        binding = DataBindingUtil.setContentView(this,R.layout.activity_player_detail)

        viewModel = ViewModelProviders.of(this,factory).get(TeamDetailViewModel::class.java)

        viewModel.playerDetailListener = this

        viewModel.getDetailPlayer(playerid)

    }

    override fun onStarted() {
        binding.shimmerPlayer.visibility =View.VISIBLE
        binding.shimmerPlayer.startShimmer()
    }

    override fun onSuccess(data: Player) {
        binding.player = data

        Picasso.get().load(data.strCutout).into(binding.imgPlayer)

        binding.shimmerPlayer.visibility = View.GONE
    }

    override fun onFailure(message: String) {
        toast(message)
    }
}
