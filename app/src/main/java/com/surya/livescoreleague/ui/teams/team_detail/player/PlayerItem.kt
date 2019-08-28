package com.surya.livescoreleague.ui.teams.team_detail.player

import android.content.Intent
import com.squareup.picasso.Picasso
import com.surya.livescoreleague.R
import com.surya.livescoreleague.data.db.entities.Player
import com.surya.livescoreleague.databinding.ItemPlayerBinding
import com.surya.livescoreleague.ui.teams.team_detail.player.player_detail.PlayerDetailActivity
import com.surya.livescoreleague.util.toast
import com.xwray.groupie.databinding.BindableItem

/**
 * Created by suryamudti on 14/08/2019.
 */
class PlayerItem(
    private val player: Player
) : BindableItem<ItemPlayerBinding>() {
    override fun getLayout() = R.layout.item_player

    override fun bind(viewBinding: ItemPlayerBinding, position: Int) {

        Picasso.get().load(player.strCutout).into(viewBinding.imgPlayer)

        viewBinding.player = player

        viewBinding.root.setOnClickListener {
            val intent = Intent(it.context, PlayerDetailActivity::class.java)
            intent.putExtra("playerid",player.idPlayer)
            it.context.startActivity(intent)
//            it.context.toast("${player?.idPlayer}")
        }



    }
}