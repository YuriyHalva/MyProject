package com.example.android.myproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

public class Main7Activity extends AppCompatActivity {

    RatingBar ratingBar;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        //ImageButton and Button Id's
        final ImageButton button1 = (ImageButton) findViewById(R.id.go8Activity);
        final ImageButton button2 = (ImageButton) findViewById(R.id.back6Activity);
        final Button button3 = (Button) findViewById(R.id.santecnick);
        //onClickListener for all for all my application buttons
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    //This will start the transition to the next Activitity
                    case R.id.go8Activity:
                        Intent intent = new Intent(Main7Activity.this, Main8Activity.class);
                        startActivity(intent);
                        break;
                    //This will start the transition to the previous Activitity
                    case R.id.back6Activity:
                        Intent intent1 = new Intent(Main7Activity.this, Main6Activity.class);
                        startActivity(intent1);
                        break;
                    //This launches the google maps app and will show the location of Boast Monuments.
                    case R.id.santecnick:
                        Intent navigate = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/dir/49.551673,25.591211/49.551674,25.591210"));
                        navigate.setClassName("com.google.android.apps.maps",
                                "com.google.android.maps.MapsActivity");
                        startActivity(navigate);
                        break;
                }

            }
        };

        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);

        //Ratingbar for its content
        ratingBar = (RatingBar) findViewById(R.id.rating_bar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingBar.setRating(rating);

                Toast.makeText(getApplicationContext(), "Rating" + String.valueOf(rating), Toast.LENGTH_LONG).show();

            }
        });
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
