package com.notin.senglish.dao

import androidx.lifecycle.LiveData
import com.notin.senglish.model.English

class EnglishResp (private val englishDao:EnglishDao)
{
  val getEnglishAll:LiveData<List<English>> =englishDao.getEnglishAll()
    suspend fun addEnglish(English:English)
    {
        englishDao.addEnglish(English)
    }

    suspend fun updateEnglish(english: English)
    {
        englishDao.updateEnglish(english)
    }

    suspend fun deleteEnglish(english: English)
    {
        englishDao.deleteEnglish(english)
    }
}