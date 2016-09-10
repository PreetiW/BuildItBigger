package com.demo.displayjokelibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    public final static String JOKE_KEY = "joke_key";
    TextView jokeTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        jokeTextview = (TextView) findViewById(R.id.joke_textview);

        if(getIntent().getExtras() != null)
        {
            jokeTextview.setText(getIntent().getExtras().getString(JOKE_KEY));
        }
    }
}
