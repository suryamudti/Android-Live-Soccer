package com.surya.livescoreleague.data.db.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.surya.livescoreleague.data.db.entities.Event
import com.surya.livescoreleague.data.db.entities.Teams

/**
 * Created by suryamudti on 21/08/2019.
 */

@Dao
interface FavoriteDao {

    // Favorite Teams
    @Insert
    suspend fun insertTeam(team: Teams):Long

    @Query("SELECT * FROM Teams")
    fun getAllTeams() :  LiveData<List<Teams>>

    @Query("SELECT * FROM Teams WHERE id = :id")
    fun getSingleTeam(id: Int) : LiveData<Teams>

    @Delete
    suspend fun deleteTeam(team: Teams)

    // Favorite Events
    @Query("SELECT * FROM Event WHERE idEvent = :idEvent")
    fun getSingleEvent(idEvent: String) : LiveData<Event>

    @Delete
    suspend fun deleteEvent(event:Event)

    @Query("SELECT * FROM Event WHERE isPrevious = :isPrevious")
    fun getAllEvents(isPrevious:Int) : LiveData<List<Event>>

    // Favorite Previous Events
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPreviousEvent(event: Event)

    // Favorite Next Events
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNextEvent(event: Event)

}