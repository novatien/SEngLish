package com.notin.senglish.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.notin.senglish.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.fragment)
        val appbarConfig = AppBarConfiguration(setOf(
            R.id.studyFragment,
            R.id.examFragment,
            R.id.favouriteFragment
        ))
        setupActionBarWithNavController(navController,appbarConfig)
        bottomNavigationView.setupWithNavController(navController)

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
}