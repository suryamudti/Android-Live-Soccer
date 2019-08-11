package com.surya.livescoreleague.data.network.responses

import com.surya.livescoreleague.data.db.entities.Teams

/**
 * Created by suryamudti on 09/08/2019.
 */
data class TeamsResponse(
    val teams: List<Teams>
)