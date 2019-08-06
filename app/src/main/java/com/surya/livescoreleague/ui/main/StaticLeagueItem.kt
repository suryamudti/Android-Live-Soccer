package com.surya.livescoreleague.ui.main

import com.squareup.picasso.Picasso
import com.surya.livescoreleague.R
import com.surya.livescoreleague.data.models.StaticLeague
import com.surya.livescoreleague.databinding.ItemLeagueRowBinding
import com.xwray.groupie.databinding.BindableItem

/**
 * Created by suryamudti on 06/08/2019.
 */
class StaticLeagueItem(
    private val staticLeague : StaticLeague
) : BindableItem<ItemLeagueRowBinding>(){
    override fun getLayout() =  R.layout.item_league_row

    override fun bind(viewBinding: ItemLeagueRowBinding, position: Int) {

        viewBinding.staticLeague = staticLeague
        staticLeague.image?.let {
            Picasso.get().load(it).into(viewBinding.imgLiga)
        }
    }
}