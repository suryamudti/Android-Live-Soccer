package com.surya.livescoreleague.ui.favorite

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.surya.livescoreleague.ui.favorite.favorite_next.FavoriteNextFragment
import com.surya.livescoreleague.ui.favorite.favorite_players.FavoritePlayerFragment
import com.surya.livescoreleague.ui.favorite.favorite_previous.FavoritePreviousFragment
import com.surya.livescoreleague.ui.favorite.favorite_teams.FavoriteTeamsFragment

/**
 * Created by suryamudti on 09/08/2019.
 */
class PagerFavoriteAdapter(fragment: FragmentManager): FragmentPagerAdapter(fragment) {
    private val pages = listOf(
        FavoritePreviousFragment(),
        FavoriteNextFragment(),
        FavoriteTeamsFragment(),
        FavoritePlayerFragment()
    )


    override fun getItem(p0: Int): Fragment {
        return pages[p0] as Fragment
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Previous Match"
            1 -> "Next Match"
            2 -> "Teams"
            else -> "Players"
        }
    }
}