package com.surya.livescoreleague.util

import android.content.Context
import android.widget.Toast

/**
 * Created by suryamudti on 06/08/2019.
 */

fun Context.toast(message: String){
    Toast.makeText(this,message, Toast.LENGTH_LONG).show()
}