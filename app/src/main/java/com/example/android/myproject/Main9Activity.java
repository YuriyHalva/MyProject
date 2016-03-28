package com.example.android.myproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Main9Activity extends AppCompatActivity {

    int grade = 0;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        //ImageButton and Button Id's
        final Button button1 = (Button) findViewById(R.id.back8Activity);
        final Button button2 = (Button) findViewById(R.id.backToStart);
        final Button button3 = (Button) findViewById(R.id.minus_button);
        final Button button4 = (Button) findViewById(R.id.plus_button);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    //This will start the transition to the previous Activitity
                    case R.id.back8Activity:
                        Intent intent = new Intent(Main9Activity.this, Main8Activity.class);
                        startActivity(intent);
                        break;
                    //This will start the transition to the start Activitity
                    case R.id.backToStart:
                        Intent intent1 = new Intent(Main9Activity.this, MainActivity.class);
                        startActivity(intent1);
                        break;
                    //This  called when the minus button is clicked.
                    case R.id.minus_button:
                        if (grade == 0) {
                            // Show an error message as a toast
                            Toast.makeText(Main9Activity.this, "You cannot have less than 0 grade", Toast.LENGTH_SHORT).show();
                            // Exit this method early because there's nothing left to do
                            return;
                        }
                        grade = grade - 1;
                        displayGrade(grade);
                        break;
                    //This  called when the plus button is clicked.
                    case R.id.plus_button:
                        if (grade == 5) {
                            // Show an error message as a toast
                            Toast.makeText(Main9Activity.this, "You cannot have more than 5 grade", Toast.LENGTH_SHORT).show();
                            // Exit this method early because there's nothing left to do
                            return;
                        }
                        grade = grade + 1;
                        displayGrade(grade);
                        break;
                }

            }
        };

        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
    }

    /**
     * This method is called when the send feedback button is clicked.
     */
    public void sendFeedback(View view) {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        EditText commentsField = (EditText) findViewById(R.id.comments_field);
        String comments = commentsField.getText().toString();

        CheckBox lvivCheckBox = (CheckBox) findViewById(R.id.lviv_checkbox);
        boolean hasLviv = lvivCheckBox.isChecked();

        CheckBox terebovlaCheckBox = (CheckBox) findViewById(R.id.terebovla_checkbox);
        boolean hasTerebovla = terebovlaCheckBox.isChecked();

        CheckBox otherCheckBox = (CheckBox) findViewById(R.id.other_checkbox);
        boolean hasOther = otherCheckBox.isChecked();

        String messege = feedback(hasLviv, hasTerebovla, hasOther, comments, name);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"yuri.galva@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Beautiful Ternopil - Feedback ");
        intent.putExtra(Intent.EXTRA_TEXT, messege);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method creates a message for email.
     */
    private String feedback(boolean addLviv, boolean addTerebovla, boolean addOther, String comments, String name) {
        String number = "Hi my name is " + name;
        number += "\nwhat I choise? ";
        number += "\nChoise Lviv? " + addLviv;
        number += "\nChoise Terebovla? " + addTerebovla;
        number += "\nChoise Other? " + addOther;
        number += "\nHere is my rating " + grade;
        number += "\n" + comments;
        return number;
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

    /**
     * This method displays the given grade value on the screen.
     */
    private void displayGrade(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.grade_text_view);
        quantityTextView.setText("" + number);
    }


}
