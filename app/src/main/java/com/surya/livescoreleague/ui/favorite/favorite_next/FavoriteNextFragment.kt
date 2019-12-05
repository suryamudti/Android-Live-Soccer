package com.surya.livescoreleague.ui.favorite.favorite_next

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mlsdev.animatedrv.AnimatedRecyclerView

import com.surya.livescoreleague.R
import com.surya.livescoreleague.data.db.entities.Event
import com.surya.livescoreleague.ui.main.ViewModelFactory
import com.surya.livescoreleague.ui.match.next.NextItem
import com.surya.livescoreleague.util.toast
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class FavoriteNextFragment : Fragment() , KodeinAware,
    FavoriteNextListener {

    override val kodein by kodein()

    private val factory : ViewModelFactory by instance()

    private lateinit var recyclerView: AnimatedRecyclerView

    companion object {
        fun newInstance() = FavoriteNextFragment()
    }

    private lateinit var viewModel: FavoriteNextViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewRoot = inflater.inflate(R.layout.favorite_next_fragment, container, false)

        recyclerView = viewRoot.findViewById(R.id.rv_favorite_next)

        return viewRoot
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        viewModel = ViewModelProviders.of(this,factory).get(FavoriteNextViewModel::class.java)

        viewModel.listener = this

        viewModel.getNextMatch()?.observe(viewLifecycleOwner, Observer {

            it?.let {
                val mAdapter = GroupAdapter<ViewHolder>().apply {
                    addAll(it.toItem())
                }
                recyclerView.adapter = mAdapter
            }
        })

    }

    private fun List<Event>.toItem() : List<NextItem>{
        return this.map {
            NextItem(it)
        }
    }

    override fun onStarted() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSuccess(data: List<Event>?) {
        if (data != null) {

            val mAdapter = GroupAdapter<ViewHolder>().apply {
                addAll(data.toItem())
            }
            recyclerView.adapter = mAdapter
        }
    }

    override fun onFailure(message: String) {
        activity?.toast("$message")
    }

}
