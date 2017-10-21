package com.example.dell.coundowner;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    TextView textView;
    public void updateTimer(int secondsLeft )
    {
        int minutes = (int) secondsLeft / 60;
        int seconds = secondsLeft - minutes * 60;
        textView.setText(Integer.toString(minutes) + ":" + Integer.toString(seconds));
    }
public void coundownbegin(View view)
{
     new CountDownTimer(seekBar.getProgress()*1000, 1000) {
                    @Override
                    public void onTick(long l) {
                        updateTimer((int)l/1000);

                    }

                    @Override
                    public void onFinish() {
                        textView.setText("0:00");
                        MediaPlayer mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.horn);
                        mediaPlayer.start();

                    }
                }.start();
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar=(SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(600);
        seekBar.setProgress(30);
        textView=(TextView) findViewById(R.id.textView3);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                updateTimer(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
