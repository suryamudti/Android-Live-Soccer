package com.surya.livescoreleague.ui.match

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ViewUtils
import androidx.databinding.DataBindingUtil
import com.squareup.picasso.Picasso

import com.surya.livescoreleague.R
import com.surya.livescoreleague.util.toast
import com.surya.livescoreleague.data.db.models.League
import com.surya.livescoreleague.databinding.MatchFragmentBinding
import kotlinx.android.synthetic.main.match_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class MatchFragment : Fragment(), MatchListener, KodeinAware {

    override val kodein by kodein()

    private val factory : MatchViewModelFactory by instance()

    companion object {
        fun newInstance() = MatchFragment()
    }

    private lateinit var viewModel: MatchViewModel
    private lateinit var binding : MatchFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        

        binding = DataBindingUtil.inflate(inflater,R.layout.match_fragment, container,false )

        viewModel = ViewModelProviders.of(this, factory).get(MatchViewModel::class.java)
        viewModel.matchListener = this
        viewModel.getDetailLeague()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(activity as AppCompatActivity){
            view_pager_main.adapter = MatchPagerAdapter(childFragmentManager)
            tabLayout.setupWithViewPager(view_pager_main)
        }
    }

    override fun onStarted() {
        binding.shimmerViewContainer.startShimmer()
    }

    override fun onSuccess(league: League) {
        binding.league = league
        Picasso.get().load(league.strLogo).into(binding.ivLeagueImage)
        Picasso.get().load(league.strTrophy).into(binding.ivLeagueThropy)
        binding.shimmerViewContainer.visibility = View.GONE
        binding.layoutScreen.visibility = View.VISIBLE
    }

    override fun onFailure(message: String) {
        context?.toast(message)
    }

}

