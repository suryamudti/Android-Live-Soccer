package com.surya.livescoreleague.ui.favorite.favorite_teams

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.surya.livescoreleague.R

class FavoriteTeamsFragment : Fragment() {

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
        viewModel = ViewModelProviders.of(this).get(FavoriteTeamsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
