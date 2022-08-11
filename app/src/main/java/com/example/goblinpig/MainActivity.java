package com.example.goblinpig;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int MAX_SOUND_POOL_STREAMS = 1;
    private int mySoundId;
    private SoundPool soundPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonOink = (Button) findViewById(R.id.button);
        //MediaPlayer mPlayer = MediaPlayer.create(FakeCallScreen.this, R.raw.oink);
        //mPlayer.start();

        this.soundPool = new SoundPool(MAX_SOUND_POOL_STREAMS,
                AudioManager.STREAM_MUSIC, 100);
        this.mySoundId = this.soundPool.load(this.getApplicationContext(),
                R.raw.oink, 1);

    }

    public void onClickToOink(View view) {
        this.soundPool.play(this.mySoundId, 1, 1, 10, 0, 1);
    }
}