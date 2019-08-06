package com.surya.livescoreleague.data.db

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.surya.livescoreleague.data.db.entities.FavoritePrevious

/**
 * Created by suryamudti on 06/08/2019.
 */


@Database(
    entities = [FavoritePrevious::class],
    version = 1
)
abstract class MyDatabase : RoomDatabase() {

    companion object{
        @Volatile
        private var instance: MyDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance?:buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =  Room.databaseBuilder(
            context.applicationContext,
            MyDatabase::class.java,
            "livescore.db"
        ).build()
    }
}