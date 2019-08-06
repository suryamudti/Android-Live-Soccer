package com.surya.livescoreleague.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.surya.livescoreleague.R
import com.surya.livescoreleague.data.models.StaticLeague
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var items : MutableList<StaticLeague> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        bindUI()
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.ligaName)
        val image = resources.obtainTypedArray(R.array.liga_image)
        val idLiga = resources.getStringArray(R.array.id_liga)

        items.clear()
        for (i in name.indices) {
            items.add(StaticLeague(name[i],image.getResourceId(i, 0),idLiga[i]))
        }
    }

    private fun bindUI() {
        val mAdapter = GroupAdapter<ViewHolder>().apply {
            addAll(items.toItem())
        }

        recycleLeague.apply {
            layoutManager = GridLayoutManager(context,2)
            setHasFixedSize(true)
            adapter = mAdapter
        }

    }

    private fun MutableList<StaticLeague>.toItem() : List<StaticLeagueItem> {
        return this.map {
            StaticLeagueItem(it)
        }
    }
}
