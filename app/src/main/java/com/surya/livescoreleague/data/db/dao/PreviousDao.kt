package com.surya.livescoreleague.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.surya.livescoreleague.data.db.entities.Event

/**
 * Created by suryamudti on 06/08/2019.
 */

@Dao
interface PreviousDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllPrevious(data : List<Event>)

//    @Query("SELECT * FROM Event")

}