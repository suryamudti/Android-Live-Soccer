package com.surya.livescoreleague.data.db.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey


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
                   val strYoutube: String?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(idLeague)
        parcel.writeString(idSoccerXML)
        parcel.writeString(idTeam)
        parcel.writeString(intFormedYear)
        parcel.writeString(intStadiumCapacity)
        parcel.writeString(strAlternate)
        parcel.writeString(strCountry)
        parcel.writeString(strDescriptionEN)
        parcel.writeString(strDescriptionES)
        parcel.writeString(strDescriptionSE)
        parcel.writeString(strFacebook)
        parcel.writeString(strGender)
        parcel.writeString(strInstagram)
        parcel.writeString(strKeywords)
        parcel.writeString(strLeague)
        parcel.writeString(strLocked)
        parcel.writeString(strManager)
        parcel.writeString(strRSS)
        parcel.writeString(strSport)
        parcel.writeString(strStadium)
        parcel.writeString(strStadiumDescription)
        parcel.writeString(strStadiumLocation)
        parcel.writeString(strStadiumThumb)
        parcel.writeString(strTeam)
        parcel.writeString(strTeamBadge)
        parcel.writeString(strTeamBanner)
        parcel.writeString(strTeamFanart1)
        parcel.writeString(strTeamFanart2)
        parcel.writeString(strTeamFanart3)
        parcel.writeString(strTeamFanart4)
        parcel.writeString(strTeamJersey)
        parcel.writeString(strTeamLogo)
        parcel.writeString(strTwitter)
        parcel.writeString(strWebsite)
        parcel.writeString(strYoutube)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Teams> {
        override fun createFromParcel(parcel: Parcel): Teams {
            return Teams(parcel)
        }

        override fun newArray(size: Int): Array<Teams?> {
            return arrayOfNulls(size)
        }
    }
}