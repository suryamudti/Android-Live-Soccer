package com.surya.livescoreleague.ui.teams.team_detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.squareup.picasso.Picasso
import com.surya.livescoreleague.R
import com.surya.livescoreleague.data.db.entities.Player
import com.surya.livescoreleague.data.db.entities.Teams
import com.surya.livescoreleague.databinding.TeamDetailFragmentBinding
import com.surya.livescoreleague.ui.main.ViewModelFactory
import org.kodein.di.android.x.kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class TeamDetailFragment : Fragment(), KodeinAware {
    override val kodein by kodein()

    private val factory : ViewModelFactory by instance()

    companion object {
        fun newInstance() = TeamDetailFragment()
    }

    private lateinit var viewModel: TeamDetailViewModel
    private lateinit var binding : TeamDetailFragmentBinding

    private var menuItem: Menu? = null
    private var isFavorite: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.team_detail_fragment, container,false )

        val team = activity?.intent?.getParcelableExtra<Teams>("team")

        binding.team = team

        Picasso.get().load(team?.strTeamBadge).into(binding.imgTeamDetail)

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this,factory).get(TeamDetailViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater?.inflate(R.menu.detail_menu, menu)
        menuItem = menu
        returnTransition
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item?.itemId) {
            R.id.add_to_favorite -> {
                if (isFavorite) removeFromFavorite()
                else  addToFavorite()
                isFavorite = !isFavorite
                setFavorite()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setFavorite() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun addToFavorite() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun removeFromFavorite() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
