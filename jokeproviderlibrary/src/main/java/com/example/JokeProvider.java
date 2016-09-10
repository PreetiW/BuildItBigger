package com.example;

import java.util.Random;

public class JokeProvider
{
    String[] jokesArray = {"A computer once beat me at chess, but it was no match for me at kick boxing.",
                            "What did one ocean say to the other ocean? Nothing, they just waved.",
                            "A day without sunshine is like, night.",
                            "What is faster Hot or cold? Hot, because you can catch a cold.",
                            "Whenever I find the key to success, someone changes the lock.",
                            "You cannot eat me unless you lick me. -Ice-cream",
                            "I needed a password eight characters long so I picked Snow White and the Seven Dwarfs.",
                            "My dad said, always leave them wanting more. Ironically, that’s how he lost his job in disaster relief.",
                            "I saw a documentary on how ships are kept together. Riveting!",
                            "I'm on a whiskey diet. I've lost three days already."
                            };

    public String getJoke()
    {
        Random rn = new Random();
        int randomNumber = rn.nextInt(10);
        return jokesArray[randomNumber];

    }
}
