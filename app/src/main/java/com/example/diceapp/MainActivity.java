package com.example.diceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnroll;
    ImageView diceimage1;
    ImageView diceimage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnroll=(Button)findViewById(R.id.btnroll);
        diceimage1=(ImageView)findViewById(R.id.diceimage1);
        diceimage2=(ImageView)findViewById(R.id.diceimage2);

        final MediaPlayer mp=MediaPlayer.create(this,R.raw.dice_sound);

        final int [] diceimages={R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};

        btnroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random rndObject=new Random();
                int randomObject=rndObject.nextInt(6);
                diceimage1.setImageResource(diceimages[randomObject]);

                randomObject=rndObject.nextInt(6);
                diceimage2.setImageResource(diceimages[randomObject]);

                YoYo.with(Techniques.FlipInX)
                        .duration(500)
                        .repeat(0)
                        .playOn(diceimage1);
                YoYo.with(Techniques.FlipInX)
                        .duration(500)
                        .repeat(0)
                        .playOn(diceimage2);
                mp.start();

            }
        });
    }
}
