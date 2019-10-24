package com.surya.livescoreleague.ui.teams.team_detail.player

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.facebook.shimmer.ShimmerFrameLayout
import com.mlsdev.animatedrv.AnimatedRecyclerView

import com.surya.livescoreleague.R
import com.surya.livescoreleague.data.db.entities.Player
import com.surya.livescoreleague.data.db.entities.Teams
import com.surya.livescoreleague.ui.teams.team_detail.TeamDetailViewModel
import com.surya.livescoreleague.ui.teams.team_detail.TeamDetailViewModelFactory
import com.surya.livescoreleague.util.toast
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import org.kodein.di.android.x.kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class PlayersFragment : Fragment(), KodeinAware, PlayerListener {

    override val kodein by kodein()

    private val factory : TeamDetailViewModelFactory by instance()

    private lateinit var shimmer : ShimmerFrameLayout
    private lateinit var recyclerView: AnimatedRecyclerView

    companion object {
        fun newInstance() = PlayersFragment()
    }

    private lateinit var viewModel: TeamDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewRoot = inflater.inflate(R.layout.players_fragment, container, false)
        shimmer = viewRoot.findViewById(R.id.shimmer_player)
        recyclerView = viewRoot.findViewById(R.id.rv_player)

        return  viewRoot
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.layoutManager = GridLayoutManager(context,2)
        recyclerView.setHasFixedSize(true)

        viewModel = ViewModelProviders.of(this, factory).get(TeamDetailViewModel::class.java)

        val team = activity?.intent?.getParcelableExtra<Teams>("team")

        viewModel.playerListener = this

        team?.idTeam?.let { viewModel.getListPlayers(it) }
    }

    override fun onStarted() {
        shimmer.visibility = View.VISIBLE
        shimmer.startShimmer()
    }

    override fun onSuccess(data: List<Player>) {
        val mAdapter = GroupAdapter<ViewHolder>().apply {
            addAll(data.toItem())
        }
        recyclerView.adapter = mAdapter
        shimmer.visibility = View.GONE
    }

    override fun onFailure(message: String) {
        shimmer.visibility = View.GONE
        activity?.toast("$message")
    }

    private fun List<Player>.toItem() : List<PlayerItem>{
        return this.map {PlayerItem(it)}
    }

}
