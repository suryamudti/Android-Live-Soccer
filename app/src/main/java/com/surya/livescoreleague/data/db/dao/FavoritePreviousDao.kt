package com.surya.livescoreleague.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.surya.livescoreleague.data.db.entities.FavoritePrevious

/**
 * Created by suryamudti on 06/08/2019.
 */

@Dao
interface FavoritePreviousDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(favoritePrevious: FavoritePrevious): Long
}