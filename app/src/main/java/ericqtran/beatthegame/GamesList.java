package ericqtran.beatthegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Stack;

public class GamesList extends AppCompatActivity {

    ArrayList<Game> theGamesList;
    TextView theReplacing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_list);

        theGamesList = new ArrayList<>();

        theGamesList = (ArrayList<Game>)getIntent().getSerializableExtra("theGameList");
        theReplacing = (TextView) findViewById(R.id.theReplaced);

        int index = 0;
        int max = theGamesList.size();

        while(max > 0)
        {
            Game toAdd = theGamesList.get(index);
            index++;
            max--;
            theReplacing.append(toAdd.getTitle());
        }




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_games_list, menu);
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
