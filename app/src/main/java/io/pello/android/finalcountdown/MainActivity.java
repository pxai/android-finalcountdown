package io.pello.android.finalcountdown;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mPlayer;
    private TextView countDownNumber;
    private EditText editTextNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countDownNumber = (TextView) findViewById(R.id.countdownTextView);
        editTextNumber = (EditText) findViewById(R.id.editTextNumber);

    }

    public void startCountdown (View view) {
        Log.d("PELLODEBUG", "And now it begins");
        countDownNumber.setText(editTextNumber.getText());
        CountdownTask countdownTask = new CountdownTask(this);
        countdownTask.execute(Integer.valueOf(editTextNumber.getText().toString()));
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
