package com.example.surya.footballmatch.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by suryamudti on 29/07/2019.
 */
data class Player(
    val dateBorn: String?,
    val dateSigned: Any,
    val idPlayer: String?,
    val idPlayerManager: Any,
    val idSoccerXML: String?,
    val idTeam: String?,
    val idTeamNational: Any,
    val intLoved: String?,
    val intSoccerXMLTeamID: Any,
    val strAgent: Any,
    val strBanner: Any,
    val strBirthLocation: String?,
    val strCollege: Any,
    val strCutout: String?,
    val strDescriptionCN: Any,
    val strDescriptionDE: Any,
    val strDescriptionEN: String?,
    val strDescriptionES: Any,
    val strDescriptionFR: Any,
    val strDescriptionHU: Any,
    val strDescriptionIL: Any,
    val strDescriptionIT: Any,
    val strDescriptionJP: Any,
    val strDescriptionNL: Any,
    val strDescriptionNO: Any,
    val strDescriptionPL: Any,
    val strDescriptionPT: Any,
    val strDescriptionRU: Any,
    val strDescriptionSE: Any,
    val strFacebook: String?,
    val strFanart1: Any,
    val strFanart2: Any,
    val strFanart3: Any,
    val strFanart4: Any,
    val strGender: String?,
    val strHeight: String?,
    val strInstagram: String?,
    val strKit: Any,
    val strLocked: String?,
    val strNationality: String?,
    val strNumber: Any,
    val strOutfitter: Any,
    val strPlayer: String?,
    val strPosition: String?,
    val strRender: Any,
    val strSide: Any,
    val strSigning: String?,
    val strSport: String?,
    val strTeam: String?,
    val strTeamNational: Any,
    val strThumb: String?,
    val strTwitter: String?,
    val strWage: String?,
    val strWebsite: String?,
    val strWeight: String?,
    val strYoutube: String?
) :Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        TODO("dateSigned"),
        parcel.readString(),
        TODO("idPlayerManager"),
        parcel.readString(),
        parcel.readString(),
        TODO("idTeamNational"),
        parcel.readString(),
        TODO("intSoccerXMLTeamID"),
        TODO("strAgent"),
        TODO("strBanner"),
        parcel.readString(),
        TODO("strCollege"),
        parcel.readString(),
        TODO("strDescriptionCN"),
        TODO("strDescriptionDE"),
        parcel.readString(),
        TODO("strDescriptionES"),
        TODO("strDescriptionFR"),
        TODO("strDescriptionHU"),
        TODO("strDescriptionIL"),
        TODO("strDescriptionIT"),
        TODO("strDescriptionJP"),
        TODO("strDescriptionNL"),
        TODO("strDescriptionNO"),
        TODO("strDescriptionPL"),
        TODO("strDescriptionPT"),
        TODO("strDescriptionRU"),
        TODO("strDescriptionSE"),
        parcel.readString(),
        TODO("strFanart1"),
        TODO("strFanart2"),
        TODO("strFanart3"),
        TODO("strFanart4"),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        TODO("strKit"),
        parcel.readString(),
        parcel.readString(),
        TODO("strNumber"),
        TODO("strOutfitter"),
        parcel.readString(),
        parcel.readString(),
        TODO("strRender"),
        TODO("strSide"),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        TODO("strTeamNational"),
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