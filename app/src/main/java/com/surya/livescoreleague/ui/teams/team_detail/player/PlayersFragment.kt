package com.surya.livescoreleague.ui.teams.team_detail.player

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.surya.livescoreleague.R

class PlayersFragment : Fragment() {

    companion object {
        fun newInstance() = PlayersFragment()
    }

    private lateinit var viewModel: PlayersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.players_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PlayersViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
