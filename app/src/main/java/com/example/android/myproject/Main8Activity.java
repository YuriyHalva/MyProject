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

public class Main8Activity extends AppCompatActivity {

    RatingBar ratingBar;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        //ImageButton and Button Id's
        final ImageButton button1 = (ImageButton) findViewById(R.id.go9Activity);
        final ImageButton button2 = (ImageButton) findViewById(R.id.back7Activity);
        final Button button3 = (Button) findViewById(R.id.field);
        //onClickListener for all for all my application buttons
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    //This will start the transition to the next Activitity
                    case R.id.go9Activity:
                        Intent intent = new Intent(Main8Activity.this, Main9Activity.class);
                        startActivity(intent);
                        break;
                    //This will start the transition to the previous Activitity
                    case R.id.back7Activity:
                        Intent intent1 = new Intent(Main8Activity.this, Main7Activity.class);
                        startActivity(intent1);
                        break;
                    //This launches the google maps app and will show the location of Champs Elysees.
                    case R.id.field:
                        Intent navigate = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/dir/49.552430,25.586687/49.552431,25.586688"));
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
