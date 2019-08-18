package com.surya.livescoreleague.ui.teams.team_detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.squareup.picasso.Picasso
import com.surya.livescoreleague.R
import com.surya.livescoreleague.data.db.entities.Player
import com.surya.livescoreleague.data.db.entities.Teams
import com.surya.livescoreleague.databinding.TeamDetailFragmentBinding
import org.kodein.di.android.x.kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class TeamDetailFragment : Fragment(), KodeinAware {
    override val kodein by kodein()

    private val factory : TeamDetailViewModelFactory by instance()

    companion object {
        fun newInstance() = TeamDetailFragment()
    }

    private lateinit var viewModel: TeamDetailViewModel
    private lateinit var binding : TeamDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.team_detail_fragment, container,false )

        viewModel = ViewModelProviders.of(this,factory).get(TeamDetailViewModel::class.java)

        val team = activity?.intent?.getParcelableExtra<Teams>("team")

        binding.team = team

        Picasso.get().load(team?.strTeamBadge).into(binding.imgTeamDetail)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}
