package com.surya.livescoreleague.data.network

import com.surya.livescoreleague.data.network.responses.LeagueResponse
import com.surya.livescoreleague.data.network.responses.MatchResponse
import com.surya.livescoreleague.data.network.responses.StandingsResponse
import com.surya.livescoreleague.util.Constants
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by suryamudti on 06/08/2019.
 */
interface MyApi{

    @GET("api/v1/json/1/lookupleague.php")
    suspend fun getDetailLeague(@Query("id") league_id: String?) : Response<LeagueResponse>

    @GET("api/v1/json/1/eventspastleague.php")
    suspend fun getLastMatch(@Query("id") league_id : String?) : Response<MatchResponse>

    @GET("api/v1/json/1/eventsnextleague.php")
    suspend fun getNextMatch(@Query("id") league_id : String?) : Response<MatchResponse>

    @GET("api/v1/json/1/lookuptable.php")
    suspend fun getStandings(@Query("l") league_id: String?) : Response<StandingsResponse>

    companion object{
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ) : MyApi{

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}