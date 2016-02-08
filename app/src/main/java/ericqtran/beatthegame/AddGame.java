package ericqtran.beatthegame;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.cognito.CognitoSyncManager;
import com.amazonaws.mobileconnectors.cognito.Dataset;
import com.amazonaws.mobileconnectors.cognito.DefaultSyncCallback;
import com.amazonaws.regions.Regions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AddGame extends AppCompatActivity {

    Button addGameButt;
    Button viewGameListButt;
    TextView gameTitleInput;
    Spinner consoleSpin;
    Spinner percentSpin;
    RelativeLayout touchScreen;
    Game addedGame;
    Stack<Game> gameStack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_game);







        //initialize global variables
        addGameButt = (Button) findViewById(R.id.addGameButton);
        viewGameListButt = (Button) findViewById(R.id.viewGamesListButton);
        gameTitleInput = (TextView) findViewById(R.id.gameBox);
        consoleSpin = (Spinner) findViewById(R.id.consoleSelection);
        percentSpin = (Spinner) findViewById(R.id.percentSpinner);
        gameStack = new Stack<>();
        touchScreen = (RelativeLayout) findViewById(R.id.touch);

        //Toast message
        Context context = getApplicationContext();
        CharSequence prompt = "Game added!";
        int duration = Toast.LENGTH_SHORT;
        final Toast message = Toast.makeText(context, prompt, duration);


        addGameButt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String titleGame = gameTitleInput.getEditableText().toString();
                String consoleTitle = consoleSpin.getSelectedItem().toString();
                String percentCom = percentSpin.getSelectedItem().toString();
                double parsedPercent = Double.parseDouble(percentCom);

                addedGame = new Game(titleGame, consoleTitle,parsedPercent);
                gameStack.push(addedGame);
                message.show();

            }
        });
    }

    public void onGetNameClick(View view)
    {
        ArrayList<Game> theList = new ArrayList<>();

        Context context = getApplicationContext();
        Intent getNameScreenIntent = new Intent(context,GamesList.class);

        while(!gameStack.empty()) {
            Game gameToBePassed = gameStack.pop();
            theList.add(gameToBePassed);
        }
        Bundle info = new Bundle();
        info.putSerializable("theGameList", theList);
        getNameScreenIntent.putExtras(info);
        startActivity(getNameScreenIntent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
