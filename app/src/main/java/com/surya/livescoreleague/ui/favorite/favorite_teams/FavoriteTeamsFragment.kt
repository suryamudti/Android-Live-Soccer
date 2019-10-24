package com.surya.livescoreleague.ui.favorite.favorite_teams

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.surya.livescoreleague.R
import com.surya.livescoreleague.ui.favorite.FavoriteViewModel
import com.surya.livescoreleague.ui.teams.team_detail.TeamDetailViewModel
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class FavoriteTeamsFragment : Fragment(), KodeinAware {

    override val kodein by kodein()

    private val factory : FavoriteTeamsViewModelFactory by instance()

    companion object {
        fun newInstance() = FavoriteTeamsFragment()
    }

    private lateinit var viewModel: FavoriteTeamsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.favorite_teams_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, factory).get(FavoriteTeamsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
