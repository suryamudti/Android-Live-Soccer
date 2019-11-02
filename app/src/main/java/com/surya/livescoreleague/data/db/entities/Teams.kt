package com.surya.livescoreleague.data.db.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Teams (
                   @PrimaryKey
                   val id: Int,
                   val idLeague: String?,
                   val idSoccerXML: String?,
                   val idTeam: String?,
                   val intFormedYear: String?,
                   val intStadiumCapacity: String?,
                   val strAlternate: String?,
                   val strCountry: String?,
                   val strDescriptionEN: String?,
                   val strDescriptionES: String?,
                   val strDescriptionSE: String?,
                   val strFacebook: String?,
                   val strGender: String?,
                   val strInstagram: String?,
                   val strKeywords: String?,
                   val strLeague: String?,
                   val strLocked: String?,
                   val strManager: String?,
                   val strRSS: String?,
                   val strSport: String?,
                   val strStadium: String?,
                   val strStadiumDescription: String?,
                   val strStadiumLocation: String?,
                   val strStadiumThumb: String?,
                   val strTeam: String?,
                   val strTeamBadge: String?,
                   val strTeamBanner: String?,
                   val strTeamFanart1: String?,
                   val strTeamFanart2: String?,
                   val strTeamFanart3: String?,
                   val strTeamFanart4: String?,
                   val strTeamJersey: String?,
                   val strTeamLogo: String?,
                   val strTwitter: String?,
                   val strWebsite: String?,
                   val strYoutube: String?
): Parcelable
