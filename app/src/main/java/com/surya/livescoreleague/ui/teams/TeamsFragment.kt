package com.surya.livescoreleague.ui.teams

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.facebook.shimmer.ShimmerFrameLayout
import com.mlsdev.animatedrv.AnimatedRecyclerView
import com.surya.livescoreleague.R
import com.surya.livescoreleague.data.db.entities.Teams
import com.surya.livescoreleague.ui.main.ViewModelFactory
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class TeamsFragment : Fragment(), TeamsListener, KodeinAware {
    override val kodein by kodein()

    private val factory: ViewModelFactory by instance()

    companion object {
        fun newInstance() = TeamsFragment()
    }

    private lateinit var viewModel: TeamsViewModel
    private lateinit var shimmer: ShimmerFrameLayout
    private lateinit var recyclerView: AnimatedRecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewRoot = inflater.inflate(R.layout.teams_fragment, container, false)

        shimmer = viewRoot.findViewById(R.id.shimmer_teams)
        recyclerView = viewRoot.findViewById(R.id.rv_teams)

        return viewRoot
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.setHasFixedSize(true)

        viewModel = ViewModelProviders.of(this, factory).get(TeamsViewModel::class.java)
        viewModel.listener = this
        viewModel.getTeamList()
    }

    override fun onStarted() {
        shimmer.visibility = View.VISIBLE
        shimmer.startShimmer()
    }

    override fun onSuccess(data: List<Teams>) {
        val mAdapter = GroupAdapter<ViewHolder>().apply {
            addAll(data.toItem())
        }
        recyclerView.adapter = mAdapter
        shimmer.visibility = View.GONE
    }

    override fun onFailure(message: String) {
        shimmer.visibility = View.GONE
    }

    private fun List<Teams>.toItem(): List<TeamsItem> {
        return this.map {
            TeamsItem(it)
        }
    }
}
