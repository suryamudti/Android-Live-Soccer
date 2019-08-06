package com.surya.livescoreleague.data.network.responses

import com.surya.livescoreleague.data.db.entities.Table

/**
 * Created by suryamudti on 27/07/2019.
 */
data class StandingsResponse(
    val table: List<Table>
)