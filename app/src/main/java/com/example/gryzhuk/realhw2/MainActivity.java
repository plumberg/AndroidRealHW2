package com.example.gryzhuk.realhw2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
            private Button clickedButton;
            private Random mGenerator;
            private int mWinningNumber;
            private View mSB_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mGenerator = new Random();
        mSB_container = findViewById(R.id.activity_main);
        startGame();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame();
            }
        });
    }

    public void startGame(){

        mWinningNumber = mGenerator.nextInt(3);

        Snackbar mySnackbar = Snackbar.make(mSB_container, "Welcome to a new game...", Snackbar.LENGTH_LONG);
        mySnackbar.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void checkIfWinner(View view) {

        clickedButton = (Button) view;


        int n ;



        n = Integer.parseInt(clickedButton.getText().toString());
        n-=1;
        if (n==mWinningNumber){
            Snackbar.make(mSB_container, "Hoooray! Winner!", Snackbar.LENGTH_LONG).show();
        } else {
            Snackbar.make(mSB_container, "Oooops...", Snackbar.LENGTH_LONG).show();
        }


    }
}
