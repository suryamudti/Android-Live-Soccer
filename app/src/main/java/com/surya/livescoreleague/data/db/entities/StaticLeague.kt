package com.surya.livescoreleague.data.db.entities

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StaticLeague (
    val name : String?,
    val image : Int?,
    val idLiga : String?
) : Parcelable