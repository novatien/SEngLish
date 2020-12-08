package com.notin.senglish.database.api

import android.app.Application
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.GsonBuilder
import com.notin.senglish.dao.EnglishDatabase
import com.notin.senglish.dao.EnglishViewModel
import com.notin.senglish.model.English
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.function.Consumer


class RetrofitClient: Callback<List<English>> {
    var context : Context? = null
    fun start(context: Context) {
        this.context = context
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://youlovecode.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val englishApi: EnglishApi = retrofit.create(EnglishApi::class.java)
        val call: Call<List<English>> =
            englishApi.listEnglish
        call.enqueue(this)
    }

    override fun onFailure(call: Call<List<English>>, t: Throwable) {
        println("999hello");
        t.printStackTrace();
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onResponse(call: Call<List<English>>, response: Response<List<English>>) {
        if (response.isSuccessful) {
             EnglishDatabase.getDatabase(context!!)
            var englishModel = EnglishViewModel(context!!.applicationContext as Application)
            val englishList: List<English>? = response.body()
            englishList!!.forEach(Consumer { english: English ->
                englishModel.addEnglish(english)
            })
        } else {
            println(response.errorBody())
            println("999--")
        }
    }


}
