package com.surya.livescoreleague.util

import java.text.ParseException
import java.text.SimpleDateFormat

/**
 * Created by suryamudti on 03/11/2019.
 */
class DateUtil {

    companion object{
        fun convertDate(date: String?):String{
            val getDate : String? = date

            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
            try {
                val dateOld = simpleDateFormat.parse(getDate)
                val newFormat = SimpleDateFormat("EEEE, MMM dd, yyyy")
                val dateFix = newFormat.format(dateOld)

                return dateFix
            } catch (e: ParseException) {
                e.printStackTrace()
                return ""
            }
        }
    }
}