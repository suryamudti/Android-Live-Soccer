package com.surya.livescoreleague.ui.match.previous

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout
import com.surya.livescoreleague.R
import com.surya.livescoreleague.data.db.entities.Event
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.previous_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class PreviousFragment : Fragment(),PreviousListener, KodeinAware {

    override val kodein by kodein()

    private val factory : PreviousViewModelFactory by instance()

    private lateinit var viewModel: PreviousViewModel
    private lateinit var shimmer: ShimmerFrameLayout
    private lateinit var recyclerView: RecyclerView

    companion object {
        fun newInstance() = PreviousFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewRoot = inflater.inflate(R.layout.previous_fragment, container, false)
        shimmer = viewRoot.findViewById(R.id.shimmer_view_container)
        recyclerView = viewRoot.findViewById(R.id.rv_prev)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        return viewRoot
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, factory).get(PreviousViewModel::class.java)

        viewModel.listener = this

        viewModel.getPreviousMatch()

    }

    override fun onStarted() {
        shimmer.visibility = View.VISIBLE
        shimmer.startShimmerAnimation()
    }

    override fun onSuccess(data: List<Event>) {
        shimmer.visibility = View.GONE
        val mAdapter = GroupAdapter<ViewHolder>().apply {
            addAll(data.toItem())
        }

        recyclerView.adapter = mAdapter

    }

    override fun onFailure(message: String) {
        shimmer.visibility = View.GONE
    }

    private fun List<Event>.toItem() : List<PreviousItem>{
        return this.map {
            PreviousItem(it)
        }
    }

}
