package com.surya.livescoreleague.ui.match.standings

import com.surya.livescoreleague.R
import com.surya.livescoreleague.data.db.entities.Table
import com.surya.livescoreleague.databinding.ItemStadingsBinding
import com.xwray.groupie.databinding.BindableItem

/**
 * Created by suryamudti on 07/08/2019.
 */
class StandingsItem(
    private val table: Table
) : BindableItem<ItemStadingsBinding>() {
    override fun getLayout() = R.layout.item_stadings

    override fun bind(viewBinding: ItemStadingsBinding, position: Int) {
        viewBinding.nomorKlasemen.text = "${position+1}"

        viewBinding.gaClub.text = "${table.goalsagainst}"
        viewBinding.gdClub.text = "${table.goalsdifference}"
        viewBinding.nameClub.text = table.name
        viewBinding.gfClub.text = "${table.goalsfor}"
        viewBinding.playedClub.text = "${table.played}"
        viewBinding.ptsClub.text = "${table.total}"
    }
}