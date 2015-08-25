package ericqtran.beatthegame;

import java.io.Serializable;

/**
 * Created by Eric on 8/23/2015.
 */
public class Game implements Serializable {

    private String title;
    private String console;
    private double percentComplete;

    public Game (String theTitle, String theConsole, double thePercentComplete)
    {
        title = theTitle;
        console = theConsole;
        percentComplete = thePercentComplete;
    }

    public String getTitle()
    {
        return this.title;
    }

    

}
