package com.surya.livescoreleague.data.db.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
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
    @Query("SELECT * FROM Event WHERE idEvent = :id")
    fun getSingleEvent(id: String) : LiveData<Event>

    @Delete
    suspend fun deleteEvent(event:Event)

    // Favorite Previous Events
    @Insert
    suspend fun insertPreviousEvent(event: Event)

    @Query("SELECT * FROM Event WHERE isPrevious = 1")
    suspend fun getAllPrevious() : LiveData<List<Event>>

    // Favorite Next Events
    @Insert
    suspend fun insertNextEvent(event: Event)

    @Query("SELECT * FROM Event WHERE isPrevious = 0")
    suspend fun getAllNext() : LiveData<List<Event>>


}