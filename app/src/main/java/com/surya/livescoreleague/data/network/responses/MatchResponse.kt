package com.surya.livescoreleague.data.network.responses

import com.surya.livescoreleague.data.db.entities.Event
import com.surya.livescoreleague.data.db.entities.Teams

/**
 * Created by suryamudti on 06/08/2019.
 */
data class MatchResponse(
    val events: List<Event>,
    val event : List<Event>,
    val teams : List<Teams>
)