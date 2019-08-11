package com.surya.livescoreleague.ui.teams.team_detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.surya.livescoreleague.ui.teams.team_detail.player.PlayersFragment

/**
 * Created by suryamudti on 09/08/2019.
 */
class TeamDetailPagerAdapter(
    fragment:FragmentManager
): FragmentPagerAdapter(fragment) {
    private val pages = listOf(
        TeamDetailFragment(),
        PlayersFragment()
    )

    override fun getItem(p0: Int): Fragment {
        return pages[p0] as Fragment
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Team Details"
            else -> "Player List"
        }
    }
}