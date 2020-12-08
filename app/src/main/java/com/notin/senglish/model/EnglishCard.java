package com.notin.senglish.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;
import com.notin.senglish.R;

import java.io.IOException;

@Layout(R.layout.english_card_view)
public class EnglishCard {
    @View(R.id.btn_sound)
    private ImageButton btnSound;

    @View(R.id.btn_close)
    private ImageButton btnClose;

    @View(R.id.btn_love)
    private ImageButton btnLove;

    @View(R.id.txt_name)
    private TextView txtName;

    @View(R.id.txt_type)
    private TextView txtType;

    @View(R.id.txt_spell)
    private TextView txtSpell;

    @View(R.id.txt_mean)
    private TextView txtMean;

    private English mEnglish;
    private Context mContext;
    private SwipePlaceHolderView mSwipeView;
    private MediaPlayer mediaPlayer;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public EnglishCard(Context context, English english, SwipePlaceHolderView swipeView) {
        mContext = context;
        mEnglish = english;
        mSwipeView = swipeView;
        mediaPlayer=new MediaPlayer();
        sharedPreferences = context.getSharedPreferences("SEnglish", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    @Resolve
    private void onResolved(){
        mediaPlayer.reset();
        txtName.setText(mEnglish.getName());
        txtType.setText(mEnglish.getType());
        txtSpell.setText(mEnglish.getSpell());
        txtMean.setText(mEnglish.getMean());

        btnClose.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                mSwipeView.doSwipe(false);
            }
        });
        btnLove.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                String s = sharedPreferences.getString("indexLove","");
                if(s.indexOf(mEnglish.getName())==-1){
                    editor.putString("indexLove",s+","+mEnglish.getName());
                    editor.commit();
                }
                mSwipeView.doSwipe(true);
            }
        });

        btnSound.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                if(mediaPlayer.isPlaying()){
                    Toast.makeText(mContext,"Âm thanh còn phát!",Toast.LENGTH_SHORT).show();
                }else
                {
                    mediaPlayer.start();
                }
            }
        });

        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {

                return false;
            }
        });
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
            }
        });
        try {
            mediaPlayer.setDataSource(mEnglish.getUrlSound());
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    @SwipeOut
    private void onSwipedOut(){
       // mSwipeView.addView(this);
    }

    @SwipeCancelState
    private void onSwipeCancelState(){
        Log.d("EVENT", "onSwipeCancelState");
    }

    @SwipeIn
    private void onSwipeIn(){
        Log.d("EVENT", "onSwipedIn");
    }

    @SwipeInState
    private void onSwipeInState(){
        Log.d("EVENT", "onSwipeInState");
    }

    @SwipeOutState
    private void onSwipeOutState(){
        Log.d("EVENT", "onSwipeOutState");
    }

}
