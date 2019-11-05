package com.surya.livescoreleague.data.db.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * Created by suryamudti on 29/07/2019.
 */

@Parcelize
@Entity
data class Player(
    @PrimaryKey
    val idPlayer: String,
    val idTeam: String?,
    val dateBorn: String?,
    val dateSigned: String?,
    val idSoccerXML: String?,
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
) :Parcelable