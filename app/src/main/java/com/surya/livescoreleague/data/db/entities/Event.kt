package com.surya.livescoreleague.data.db.entities


import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Event(
    val dateEvent: String?,
    val idAwayTeam: String?,
    @PrimaryKey(autoGenerate = false)
    val idEvent: String?,
    val idHomeTeam: String?,
    val idLeague: String?,
    val idSoccerXML: String?,
    val intAwayScore: String?,
    val intAwayShots: String?,
    val intHomeScore: String?,
    val intHomeShots: String?,
    val intRound: String?,
    val intSpectators: String?,
    val strAwayFormation: String?,
    val strAwayGoalDetails: String?,
    val strAwayLineupDefense: String?,
    val strAwayLineupForward: String?,
    val strAwayLineupGoalkeeper: String?,
    val strAwayLineupMidfield: String?,
    val strAwayLineupSubstitutes: String?,
    val strAwayRedCards: String?,
    val strAwayTeam: String?,
    val strAwayYellowCards: String?,
    val strBanner: String?,
    val strCircuit: String?,
    val strCity: String?,
    val strCountry: String?,
    val strDate: String?,
    val strDescriptionEN: String?,
    val strEvent: String?,
    val strFanart: String?,
    val strFilename: String?,
    val strHomeFormation: String?,
    val strHomeGoalDetails: String?,
    val strHomeLineupDefense: String?,
    val strHomeLineupForward: String?,
    val strHomeLineupGoalkeeper: String?,
    val strHomeLineupMidfield: String?,
    val strHomeLineupSubstitutes: String?,
    val strHomeRedCards: String?,
    val strHomeTeam: String?,
    val strHomeYellowCards: String?,
    val strLeague: String?,
    val strLocked: String?,
    val strMap: String?,
    val strPoster: String?,
    val strResult: String?,
    val strSeason: String?,
    val strSport: String?,
    val strTVStation: String?,
    val strThumb: String?,
    val strTime: String?
) : Parcelable  {
    constructor(parcel: Parcel) : this(
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
        parcel.writeString(dateEvent)
        parcel.writeString(idAwayTeam)
        parcel.writeString(idEvent)
        parcel.writeString(idHomeTeam)
        parcel.writeString(idLeague)
        parcel.writeString(idSoccerXML)
        parcel.writeString(intAwayScore)
        parcel.writeString(intAwayShots)
        parcel.writeString(intHomeScore)
        parcel.writeString(intHomeShots)
        parcel.writeString(intRound)
        parcel.writeString(intSpectators)
        parcel.writeString(strAwayFormation)
        parcel.writeString(strAwayGoalDetails)
        parcel.writeString(strAwayLineupDefense)
        parcel.writeString(strAwayLineupForward)
        parcel.writeString(strAwayLineupGoalkeeper)
        parcel.writeString(strAwayLineupMidfield)
        parcel.writeString(strAwayLineupSubstitutes)
        parcel.writeString(strAwayRedCards)
        parcel.writeString(strAwayTeam)
        parcel.writeString(strAwayYellowCards)
        parcel.writeString(strBanner)
        parcel.writeString(strCircuit)
        parcel.writeString(strCity)
        parcel.writeString(strCountry)
        parcel.writeString(strDate)
        parcel.writeString(strDescriptionEN)
        parcel.writeString(strEvent)
        parcel.writeString(strFanart)
        parcel.writeString(strFilename)
        parcel.writeString(strHomeFormation)
        parcel.writeString(strHomeGoalDetails)
        parcel.writeString(strHomeLineupDefense)
        parcel.writeString(strHomeLineupForward)
        parcel.writeString(strHomeLineupGoalkeeper)
        parcel.writeString(strHomeLineupMidfield)
        parcel.writeString(strHomeLineupSubstitutes)
        parcel.writeString(strHomeRedCards)
        parcel.writeString(strHomeTeam)
        parcel.writeString(strHomeYellowCards)
        parcel.writeString(strLeague)
        parcel.writeString(strLocked)
        parcel.writeString(strMap)
        parcel.writeString(strPoster)
        parcel.writeString(strResult)
        parcel.writeString(strSeason)
        parcel.writeString(strSport)
        parcel.writeString(strTVStation)
        parcel.writeString(strThumb)
        parcel.writeString(strTime)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Event> {
        override fun createFromParcel(parcel: Parcel): Event {
            return Event(parcel)
        }

        override fun newArray(size: Int): Array<Event?> {
            return arrayOfNulls(size)
        }
    }
}