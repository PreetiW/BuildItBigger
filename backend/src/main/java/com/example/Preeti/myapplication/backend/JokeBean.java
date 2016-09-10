package com.example.Preeti.myapplication.backend;

import com.example.JokeProvider;

/** The object model for the data we are sending through endpoints */
public class JokeBean {

    private JokeProvider jokeProvider;

    public JokeBean()
    {
        jokeProvider = new JokeProvider();
    }

    public String getData()
    {
        return jokeProvider.getJoke();
    }


}