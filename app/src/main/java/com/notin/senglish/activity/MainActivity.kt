package com.notin.senglish.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.notin.senglish.R
import com.notin.senglish.database.api.EnglishApi
import com.notin.senglish.database.api.RetrofitClient
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : AppCompatActivity() {
    private lateinit var navigation: NavigationView
    private lateinit var drawLayout: DrawerLayout
    var englishApi: EnglishApi? = null
    var compositeDisposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        listener()
        var retrofitClient = RetrofitClient()
        retrofitClient.start(this)
//        swipeView.getBuilder<SwipePlaceHolderView, SwipeViewBuilder<SwipePlaceHolderView>>()
//            .setDisplayViewCount(3)
//            .setSwipeDecor(
//                SwipeDecor()
//                    .setPaddingTop(20)
//                    .setRelativeScale(0.01f)
//                    .setSwipeInMsgLayoutId(R.layout.swipe_in_view)
//                    .setSwipeOutMsgLayoutId(R.layout.swipe_out_view)
//            )
//
//        for (english in Utils.loadEnglish(this.applicationContext)) {
//            swipeView.addView(EnglishCard(applicationContext,english, swipeView))
//        }


    }
    fun init(){
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_main_menu)
        supportActionBar!!.title="English-Vietnamese"

        val navController = findNavController(R.id.fragment)
        val appbarConfig = AppBarConfiguration(setOf(
            R.id.personalFragment,
            R.id.studyFragment,
            R.id.examFragment,
            R.id.favouriteFragment
        ))
        setupActionBarWithNavController(navController,appbarConfig)
        bottomNavigationView.setupWithNavController(navController)
        navigation = findViewById(R.id.navigation)
        drawLayout = findViewById(R.id.drawer_layout)
    }

    fun listener(){
        navigation.setNavigationItemSelectedListener(object: NavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(p0: MenuItem): Boolean {
                when(p0.itemId){
                    R.id.nav_logout->{
                        FirebaseAuth.getInstance().signOut()
                        val intent= Intent(this@MainActivity,LoginActivity::class.java)
                        intent.flags= Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                    }
                }
                drawLayout.closeDrawer(GravityCompat.START)
                return false
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            android.R.id.home->{
                drawer_layout.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }




}