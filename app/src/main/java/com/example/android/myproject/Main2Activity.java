package com.example.android.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Main2Activity extends AppCompatActivity {

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //ImageButton  Id's
        final ImageButton button1 = (ImageButton) findViewById(R.id.go3Activity);
        final ImageButton button2 = (ImageButton) findViewById(R.id.backActivity);
        //onClickListener for all for all my application buttons
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    //This will start the transition to the next Activitity
                    case R.id.go3Activity:
                        Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                        startActivity(intent);
                        break;
                    //This will start the transition to the previous Activitity
                    case R.id.backActivity:
                        Intent intent1 = new Intent(Main2Activity.this, MainActivity.class);
                        startActivity(intent1);
                        break;
                }

            }
        };

        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
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

}

