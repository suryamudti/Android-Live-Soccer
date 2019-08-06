package com.surya.livescoreleague.ui.match.standings

import com.surya.livescoreleague.data.db.entities.Table

/**
 * Created by suryamudti on 07/08/2019.
 */
interface StandingsListener {

    fun onStarted()
    fun onSuccess(data: List<Table>)
    fun onFailure(message: String)
}