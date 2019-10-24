package com.surya.livescoreleague.ui.match.next

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout
import com.mlsdev.animatedrv.AnimatedRecyclerView
import com.surya.livescoreleague.R
import com.surya.livescoreleague.data.db.entities.Event
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.next_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class NextFragment : Fragment(), NextListener, KodeinAware {


    override val kodein by kodein()

    private val factory : NextViewModelFactory by instance()

    private lateinit var shimmer: ShimmerFrameLayout
    private lateinit var recyclerView: AnimatedRecyclerView

    companion object {
        fun newInstance() = NextFragment()
    }

    private lateinit var viewModel: NextViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewRoot = inflater.inflate(R.layout.next_fragment, container, false)

        shimmer = viewRoot.findViewById(R.id.shimmer_view_container)
        recyclerView = viewRoot.findViewById(R.id.rv_next)


        return viewRoot
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        viewModel = ViewModelProviders.of(this, factory).get(NextViewModel::class.java)

        viewModel.listener = this

        viewModel.getNextMatch()

    }

    override fun onStarted() {
        shimmer.visibility = View.VISIBLE
        shimmer.startShimmer()
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

    private fun List<Event>.toItem() : List<NextItem>{
        return this.map {
            NextItem(it)
        }
    }

}
