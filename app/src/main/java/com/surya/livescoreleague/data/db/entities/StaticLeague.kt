package com.surya.livescoreleague.data.db.entities

import android.os.Parcel
import android.os.Parcelable

data class StaticLeague (val name : String?, val image : Int?, val idLiga : String? ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeValue(image)
        parcel.writeString(idLiga)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StaticLeague> {
        override fun createFromParcel(parcel: Parcel): StaticLeague {
            return StaticLeague(parcel)
        }

        override fun newArray(size: Int): Array<StaticLeague?> {
            return arrayOfNulls(size)
        }
    }

}