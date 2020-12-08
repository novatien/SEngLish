package com.notin.senglish.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.notin.senglish.model.English

@Database(entities = [English::class],version = 1,exportSchema = false)
abstract class EnglishDatabase:RoomDatabase() {
    abstract fun englishDao():EnglishDao
    companion object{
        @Volatile
        private var INSTANCE:EnglishDatabase?=null

        fun getDatabase(context: Context):EnglishDatabase{
            val temp= INSTANCE
            if(temp!=null)
            {
                return temp
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    EnglishDatabase::class.java,
                    "SEnglish"
                ).build()
                INSTANCE=instance
                return instance
            }
        }
    }


}