package com.surya.livescoreleague.data.db.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by suryamudti on 29/07/2019.
 */

data class Player(
    val dateBorn: String?,
    val dateSigned: String?,
    val idPlayer: String?,
    val idSoccerXML: String?,
//    @PrimaryKey
    val idTeam: String?,
    val intLoved: String?,
    val strBirthLocation: String?,
    val strCutout: String?,
    val strDescriptionEN: String?,
    val strFacebook: String?,
    val strGender: String?,
    val strHeight: String?,
    val strInstagram: String?,
    val strLocked: String?,
    val strNationality: String?,
    val strPlayer: String?,
    val strPosition: String?,
    val strSigning: String?,
    val strSport: String?,
    val strTeam: String?,
    val strThumb: String?,
    val strTwitter: String?,
    val strWage: String?,
    val strWebsite: String?,
    val strWeight: String?,
    val strYoutube: String?
) :Parcelable{
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
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(dateBorn)
        parcel.writeString(idPlayer)
        parcel.writeString(idSoccerXML)
        parcel.writeString(idTeam)
        parcel.writeString(intLoved)
        parcel.writeString(strBirthLocation)
        parcel.writeString(strCutout)
        parcel.writeString(strDescriptionEN)
        parcel.writeString(strFacebook)
        parcel.writeString(strGender)
        parcel.writeString(strHeight)
        parcel.writeString(strInstagram)
        parcel.writeString(strLocked)
        parcel.writeString(strNationality)
        parcel.writeString(strPlayer)
        parcel.writeString(strPosition)
        parcel.writeString(strSigning)
        parcel.writeString(strSport)
        parcel.writeString(strTeam)
        parcel.writeString(strThumb)
        parcel.writeString(strTwitter)
        parcel.writeString(strWage)
        parcel.writeString(strWebsite)
        parcel.writeString(strWeight)
        parcel.writeString(strYoutube)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Player> {
        override fun createFromParcel(parcel: Parcel): Player {
            return Player(parcel)
        }

        override fun newArray(size: Int): Array<Player?> {
            return arrayOfNulls(size)
        }
    }
}