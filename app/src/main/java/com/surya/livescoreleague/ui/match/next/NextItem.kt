package com.surya.livescoreleague.ui.match.next

import android.content.Intent
import android.util.EventLog
import com.surya.livescoreleague.R
import com.surya.livescoreleague.data.db.entities.Event
import com.surya.livescoreleague.databinding.ItemMatchBinding
import com.surya.livescoreleague.ui.match.match_detail.MatchDetailActivity
import com.xwray.groupie.databinding.BindableItem
import java.text.ParseException
import java.text.SimpleDateFormat

/**
 * Created by suryamudti on 06/08/2019.
 */
class NextItem(private val event: Event) : BindableItem<ItemMatchBinding>() {
    override fun getLayout() = R.layout.item_match

    override fun bind(viewBinding: ItemMatchBinding, position: Int) {
        val getDate : String? = event.dateEvent

        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
        try {
            val date = simpleDateFormat.parse(getDate)
            val newFormat = SimpleDateFormat("EEEE, MMM dd, yyyy")
            val dateFix = newFormat.format(date)
            viewBinding.dateMatch.text = dateFix
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        viewBinding.root.setOnClickListener {
            val intent = Intent(it.context, MatchDetailActivity::class.java)
            intent.putExtra("event",this.event)
            it.context.startActivity(intent)
        }

        viewBinding.event = event
    }
}