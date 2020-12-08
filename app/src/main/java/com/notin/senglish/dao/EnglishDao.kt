package com.notin.senglish.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.notin.senglish.model.English

@Dao
interface EnglishDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEnglish(english:English)

    @Delete
    suspend fun deleteEnglish(english: English)

    @Update
    suspend fun updateEnglish(english: English)

    @Query("SELECT * FROM english ORDER BY ID ASC")
    fun getEnglishAll():LiveData<List<English>>

}