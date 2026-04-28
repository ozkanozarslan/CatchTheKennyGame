package com.example.catchthekennygame;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView timeText;
    TextView scoreText;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //initialize ederek istediğimiz yerde çağırabiliriz.
        timeText=findViewById(R.id.timeText);
        timeText.setText("10");
        scoreText=findViewById(R.id.scoreText);
        score=0;
        new CountDownTimer(10000,1000) {
            public void onTick(long millisUntilFinished) {
                timeText.setText("Time : "+millisUntilFinished/1000);
            }

            public void onFinish() {
            }
        }.start();

    };
    public void increaseScore(View view){
        score++;
        scoreText.setText("Score : "+score);

    }
}