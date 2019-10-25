package com.surya.livescoreleague.data.preferences

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * Created by suryamudti on 06/08/2019.
 */


class PreferencesProvider(context: Context) {

    private val LEAGUE_ID = "LEAGUE_ID"
    private val TEAM_ID = "TEAM_ID"


    private val appContext = context.applicationContext

    private val preferences : SharedPreferences
        get() = PreferenceManager.getDefaultSharedPreferences(appContext)

    fun setLeagueId(leagueId : String){
        preferences.edit().putString(LEAGUE_ID,leagueId).apply()
    }

    fun getLeagueId(): String?{
        return preferences.getString(LEAGUE_ID,null)
    }

    fun setTeamId(teamId : String){
        preferences.edit().putString(TEAM_ID,teamId).apply()
    }

    fun getTeamId(): String?{
        return preferences.getString(TEAM_ID,null)
    }





}