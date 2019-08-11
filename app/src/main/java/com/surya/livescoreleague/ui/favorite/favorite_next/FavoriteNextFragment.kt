package com.surya.livescoreleague.ui.favorite.favorite_next

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.surya.livescoreleague.R

class FavoriteNextFragment : Fragment() {

    companion object {
        fun newInstance() = FavoriteNextFragment()
    }

    private lateinit var viewModel: FavoriteNextViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.favorite_next_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FavoriteNextViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
