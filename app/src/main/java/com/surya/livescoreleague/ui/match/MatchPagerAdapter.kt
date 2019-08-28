package com.surya.livescoreleague.ui.match

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.surya.livescoreleague.ui.match.next.NextFragment
import com.surya.livescoreleague.ui.match.previous.PreviousFragment
import com.surya.livescoreleague.ui.match.standings.StandingsFragment

/**
 * Created by suryamudti on 06/08/2019.
 */

class MatchPagerAdapter(fragment: FragmentManager) : FragmentPagerAdapter(fragment){
    private val pages:List<Fragment> = listOf(
        PreviousFragment(),
        NextFragment(),
        StandingsFragment()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Previous Match"
            1 -> "Next Match"
            else -> "Standings"
        }
    }


}