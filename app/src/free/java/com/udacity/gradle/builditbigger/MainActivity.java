package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.demo.displayjokelibrary.DisplayJokeActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends ActionBarActivity implements GetJokeInterface
{

    InterstitialAd mInterstitialAd;
    Intent displayJokeIntent;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportFragmentManager().beginTransaction().
                add(R.id.fragment,new MainActivityFragment()).commit();

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed()
            {

                startActivity(displayJokeIntent);

            }
        });

        requestNewInterstitial();
    }

    private void requestNewInterstitial()
    {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }


    public void tellJoke(View view)
    {
        //Toast.makeText(this, new JokeProvider().getJoke(), Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.VISIBLE);
        new JokesEndpointAsyncTask(MainActivity.this).execute();
    }


    @Override
    public void onReceivedJoke(String joke)
    {
        progressBar.setVisibility(View.GONE);
        displayJokeIntent =  new Intent(MainActivity.this, DisplayJokeActivity.class);
        displayJokeIntent.putExtra(DisplayJokeActivity.JOKE_KEY, joke);

        if (mInterstitialAd.isLoaded())
        {
            mInterstitialAd.show();
        }
        else
        {
            startActivity(displayJokeIntent);
        }
    }
}
