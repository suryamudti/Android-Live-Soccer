package com.surya.livescoreleague.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.surya.livescoreleague.data.db.MyDatabase
import com.surya.livescoreleague.data.db.entities.Event
import com.surya.livescoreleague.data.db.entities.PlayerResponse
import com.surya.livescoreleague.data.db.entities.Teams
import com.surya.livescoreleague.data.db.models.League
import com.surya.livescoreleague.data.network.MyApi
import com.surya.livescoreleague.data.network.SafeApiRequest
import com.surya.livescoreleague.data.network.responses.LeagueResponse
import com.surya.livescoreleague.data.network.responses.MatchResponse
import com.surya.livescoreleague.data.network.responses.StandingsResponse
import com.surya.livescoreleague.data.network.responses.TeamsResponse
import com.surya.livescoreleague.data.preferences.PreferencesProvider
import com.surya.livescoreleague.util.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by suryamudti on 06/08/2019.
 */
class MatchRepository(
        private val api : MyApi,
        private val db : MyDatabase,
        private val prefs: PreferencesProvider
) : SafeApiRequest() {

    private val leagues = MutableLiveData<List<League>>()

    // SharedPreferences
    fun setLeagueId(id :String){
        prefs.setLeagueId(id)
    }

    fun getLeagueId() : String?{
        return prefs.getLeagueId()
    }

    fun setTeamId(id :String){
        prefs.setTeamId(id)
    }

    fun getTeamId():String?{
        return prefs.getTeamId()
    }

    // Remote
    suspend fun getLeagueDetail() : LeagueResponse{
        return apiRequest {
            api.getDetailLeague(getLeagueId())
        }
    }

    suspend fun getPreviousMatch() : MatchResponse{
        return apiRequest {
            api.getLastMatch(getLeagueId())
        }
    }

    suspend fun getNextMatch() : MatchResponse{
        return apiRequest {
            api.getNextMatch(getLeagueId())
        }
    }

    suspend fun getStandings() : StandingsResponse{
        return apiRequest {
            api.getStandings(getLeagueId())
        }
    }

    suspend fun getDetailTeam(id: String) : MatchResponse{
        return apiRequest {
            api.getDetailTeam(id)
        }
    }

    suspend fun getTeamList(): TeamsResponse{
        return apiRequest {
            api.getListTeams(getLeagueId())
        }
    }

    suspend fun getListPlayer(): PlayerResponse {
        return apiRequest {
            api.getListPlayer(getTeamId())
        }
    }

    suspend fun getDetailPlayer(id: String) : PlayerResponse{
        return apiRequest {
            api.getDetailPlayer(id)
        }
    }

    // Local Storage
    suspend fun getAllTeams() : LiveData<List<Teams>> {
        return withContext(Dispatchers.IO){
            db.getFavoritesDao().getAllTeams()
        }
    }

    suspend fun getSingleTeam(id : Int) : LiveData<Teams>{
        return withContext(Dispatchers.IO){
            db.getFavoritesDao().getSingleTeam(id)
        }
    }

    fun saveTeams(team: Teams){
        Coroutines.io {
            db.getFavoritesDao().insertTeam(team)
        }
    }

    private fun deleteTeams(team: Teams){
        Coroutines.io {
            db.getFavoritesDao().deleteTeam(team)
        }
    }

    // Favorite Events
    suspend fun getAllLocalEvents(isPrevious: Int):List<Event>{
        return withContext(Dispatchers.IO){ db.getFavoritesDao().getAllEvents(isPrevious,getLeagueId()!!)}
    }

    suspend fun getSingleLocalEvents(id: String): Event? {
        return withContext(Dispatchers.IO){db.getFavoritesDao().getSingleEvent(id)}
    }

    fun insertEvent(event: Event){
        Coroutines.io {
            if (event.isPrevious==1) db.getFavoritesDao().insertPreviousEvent(event)
            else db.getFavoritesDao().insertNextEvent(event)
        }
    }

    fun deleteEvent(event: Event){
        Coroutines.io {
            db.getFavoritesDao().deleteEvent(event)
        }
    }

}