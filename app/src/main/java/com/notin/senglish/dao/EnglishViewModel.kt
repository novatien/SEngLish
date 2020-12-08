package com.notin.senglish.dao

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.notin.senglish.model.English
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EnglishViewModel (application: Application):AndroidViewModel(application){
    val getAllEnglish:LiveData<List<English>>
    private val resp:EnglishResp
    init {
        val englishDao=EnglishDatabase.getDatabase(application).englishDao()
        resp=EnglishResp(englishDao)
        getAllEnglish=resp.getEnglishAll

    }

    fun addEnglish(english:English){
      viewModelScope.launch(Dispatchers.IO){
          resp.addEnglish(english)
      }
    }
    fun updateEnglish(english: English)
    {
        viewModelScope.launch (Dispatchers.IO){
            resp.updateEnglish(english)
        }
    }

    fun deleteEnglish(english: English)
    {
        viewModelScope.launch (Dispatchers.IO){
            resp.deleteEnglish(english)
        }
    }
}