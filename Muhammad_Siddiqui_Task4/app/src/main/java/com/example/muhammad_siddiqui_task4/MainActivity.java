package com.example.muhammad_siddiqui_task4;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize and set up the first RatingBar and TextView
        RatingBar ratingBar1 = findViewById(R.id.ratingBar1);
        TextView ratingValue1 = findViewById(R.id.ratingValue1);

        // Set an OnRatingBarChangeListener for the first RatingBar
        ratingBar1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                // Update the associated TextView with the selected rating value
                ratingValue1.setText(String.valueOf(rating));
            }
        });

        // Repeat the above steps for the other RatingBars and TextViews
        RatingBar ratingBar2 = findViewById(R.id.ratingBar2);
        TextView ratingValue2 = findViewById(R.id.ratingValue2);

        ratingBar2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingValue2.setText(String.valueOf(rating));
            }
        });

        RatingBar ratingBar3 = findViewById(R.id.ratingBar3);
        TextView ratingValue3 = findViewById(R.id.ratingValue3);

        ratingBar3.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingValue3.setText(String.valueOf(rating));
            }
        });

        RatingBar ratingBar4 = findViewById(R.id.ratingBar4);
        TextView ratingValue4 = findViewById(R.id.ratingValue4);

        ratingBar4.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingValue4.setText(String.valueOf(rating));
            }
        });

        RatingBar ratingBar5 = findViewById(R.id.ratingBar5);
        TextView ratingValue5 = findViewById(R.id.ratingValue5);

        ratingBar5.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingValue5.setText(String.valueOf(rating));
            }
        });
    }
}
