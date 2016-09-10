package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

/**
 * Created by Preeti on 10-09-2016.
 */
public class NonEmptyJokeTest extends AndroidTestCase implements GetJokeInterface
{
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        new JokesEndpointAsyncTask(this).execute();
    }

    @Override
    public void onReceivedJoke(String joke)
    {
        assertNotNull(joke);
    }
}
