package com.surya.livescoreleague.data.network.responses

import com.surya.livescoreleague.data.db.models.League

data class LeagueResponse(
    val leagues: List<League>
)