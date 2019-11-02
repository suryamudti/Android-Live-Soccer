package com.surya.livescoreleague.ui.favorite.favorite_players

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.surya.livescoreleague.R
import com.surya.livescoreleague.ui.main.ViewModelFactory
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class FavoritePlayerFragment : Fragment() , KodeinAware {

    override val kodein by kodein()
    private val factory : ViewModelFactory by instance()

    companion object {
        fun newInstance() = FavoritePlayerFragment()
    }

    private lateinit var viewModelFavorite: FavoritePlayerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.player_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModelFavorite = ViewModelProviders.of(this,factory).get(FavoritePlayerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
