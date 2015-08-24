package ericqtran.beatthegame;

import android.content.Context;
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

import java.util.Stack;

public class AddGame extends AppCompatActivity {

    Button addGameButt;
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
