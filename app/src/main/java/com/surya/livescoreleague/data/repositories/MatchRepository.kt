package com.surya.livescoreleague.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.surya.footballmatch.model.PlayerResponse
import com.surya.livescoreleague.data.db.MyDatabase
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


    fun setLeagueId(id :String){
        prefs.setLeagueId(id)
    }

    fun getLeagueId() : String?{
        return prefs.getLeagueId()
    }

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

    suspend fun getListPlayer(id: String): PlayerResponse{
        return apiRequest {
            api.getListPlayer(id)
        }
    }
}