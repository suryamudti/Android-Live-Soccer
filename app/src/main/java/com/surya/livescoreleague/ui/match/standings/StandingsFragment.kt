package com.surya.livescoreleague.ui.match.standings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.facebook.shimmer.ShimmerFrameLayout
import com.surya.livescoreleague.R
import com.surya.livescoreleague.data.db.entities.Table
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.standings_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class StandingsFragment : Fragment(), StandingsListener, KodeinAware {

    override val kodein by kodein()

    private val factory : StandingsViewModelFactory by instance()

    private lateinit var shimmer: ShimmerFrameLayout

    companion object {
        fun newInstance() = StandingsFragment()
    }

    private lateinit var viewModel: StandingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewRoot = inflater.inflate(R.layout.standings_fragment, container, false)
        shimmer = viewRoot.findViewById(R.id.shimmer_view_container)
        return viewRoot
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, factory).get(StandingsViewModel::class.java)

        viewModel.listener = this

        viewModel.getStandings()

    }

    override fun onStarted() {
        shimmer.visibility = View.VISIBLE
        shimmer.startShimmerAnimation()
    }

    override fun onSuccess(data: List<Table>) {
        shimmer.visibility = View.GONE

        val mAdapter = GroupAdapter<ViewHolder>().apply {
            addAll(data.toItem())
        }

        rv_standings.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = mAdapter
        }
    }

    override fun onFailure(message: String) {
        shimmer.visibility = View.GONE
    }

    private fun List<Table>.toItem() : List<StandingsItem>{
        return this.map {
            StandingsItem(it)
        }
    }

}
