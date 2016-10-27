package io.pello.android.finalcountdown;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mPlayer;
    private TextView countDownNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countDownNumber = (TextView) findViewById(R.id.countdownTextView);
    }

    public void startCountdown (View view) {
        Log.d("PELLODEBUG", "And now it begins");
        CountdownTask countdownTask = new CountdownTask(this);
        countdownTask.execute(10);
        playSound(R.raw.finalcount);
    }


    private void playSound (Integer id) {
        if (null != mPlayer && mPlayer.isPlaying()) {
            mPlayer.stop();
        } else {
            mPlayer = MediaPlayer.create(this, id);
            mPlayer.start();
        }
    }

    public MediaPlayer getMediaPlayer() {
        return mPlayer;
    }

    public TextView getCountDownNumber () {
        return countDownNumber;
    }
}
