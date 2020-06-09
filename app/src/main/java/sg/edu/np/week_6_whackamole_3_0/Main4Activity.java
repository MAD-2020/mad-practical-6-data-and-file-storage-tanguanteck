package sg.edu.np.week_6_whackamole_3_0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Main4Activity extends AppCompatActivity {

    /* Hint:
        1. This creates the Whack-A-Mole layout and starts a countdown to ready the user
        2. The game difficulty is based on the selected level
        3. The levels are with the following difficulties.
            a. Level 1 will have a new mole at each 10000ms.
                - i.e. level 1 - 10000ms
                       level 2 - 9000ms
                       level 3 - 8000ms
                       ...
                       level 10 - 1000ms
            b. Each level up will shorten the time to next mole by 100ms with level 10 as 1000 second per mole.
            c. For level 1 ~ 5, there is only 1 mole.
            d. For level 6 ~ 10, there are 2 moles.
            e. Each location of the mole is randomised.
        4. There is an option return to the login page.
     */
    private static final String FILENAME = "Main4Activity.java";
    private static final String TAG = "Whack-A-Mole3.0!";
    CountDownTimer readyTimer;
    CountDownTimer newMolePlaceTimer;
    int advScore;
    Button buttontopLeft;
    Button buttontopMiddle;
    Button buttontopRight;
    Button buttonmidLeft;
    Button buttonmidMiddle;
    Button buttonmidRight;
    Button buttonbotLeft;
    Button buttonbotMiddle;
    Button buttonbotRight;
    TextView ViewScore;

    CountDownTimer sCountdown;
    CountDownTimer zCountdown;
    private void readyTimer(){
        /*  HINT:
            The "Get Ready" Timer.
            Log.v(TAG, "Ready CountDown!" + millisUntilFinished/ 1000);
            Toast message -"Get Ready In X seconds"
            Log.v(TAG, "Ready CountDown Complete!");
            Toast message - "GO!"
            belongs here.
            This timer countdown from 10 seconds to 0 seconds and stops after "GO!" is shown.
         */
        sCountdown = new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long l) {
                Toast.makeText(Main4Activity.this, "Get Ready in " + l/1000 + " seconds.", Toast.LENGTH_SHORT).show();
                Log.v(TAG, "Ready CountDown!" + l/ 1000);
            }

            @Override
            public void onFinish() {
                Toast.makeText(Main4Activity.this,"Go",Toast.LENGTH_SHORT).show();
                Log.v(TAG, "Ready CountDown Complete!");
                sCountdown.cancel();

                placeMoleTimer();
            }
        };
        sCountdown.start();
    }
    private void placeMoleTimer(){
        /* HINT:
           Creates new mole location each second.
           Log.v(TAG, "New Mole Location!");
           setNewMole();
           belongs here.
           This is an infinite countdown timer.
         */
        zCountdown = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long l) {
                setNewMole();
                Log.v(TAG, "New Mole Location!");
            }

            @Override
            public void onFinish() {
                zCountdown.start();

            }
        };
        zCountdown.start();
    }
    private static final int[] BUTTON_IDS = {
            /* HINT:
                Stores the 9 buttons IDs here for those who wishes to use array to create all 9 buttons.
                You may use if you wish to change or remove to suit your codes.*/
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        buttontopLeft = (Button) findViewById(R.id.buttontop_left);
        buttontopMiddle = (Button) findViewById(R.id.buttontop_middle);
        buttontopRight = (Button) findViewById(R.id.buttontop_right);
        buttonmidLeft = (Button) findViewById(R.id.buttonmiddle_left);
        buttonmidMiddle = (Button) findViewById(R.id.buttonmiddle_left);
        buttonmidRight = (Button) findViewById(R.id.buttonmiddle_left);
        buttonbotLeft = (Button) findViewById(R.id.buttonbot_left);
        buttonbotMiddle = (Button) findViewById(R.id.buttonbot_middle);
        buttonbotRight = (Button) findViewById(R.id.buttonbot_right);
        ViewScore = (TextView) findViewById(R.id.textView3);

        buttontopLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doCheck(buttontopLeft);
            }
        });
        buttontopMiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doCheck(buttontopMiddle);
            }
        });
        buttontopRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doCheck(buttontopRight);
            }
        });
        buttonmidLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doCheck(buttonmidLeft);
            }
        });
        buttonmidMiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doCheck(buttonmidLeft);
            }
        });
        buttonmidRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doCheck(buttonmidRight);
            }
        });
        buttonbotLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doCheck(buttonbotLeft);
            }
        });
        buttonbotMiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doCheck(buttonbotMiddle);
            }
        });
        buttonbotRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doCheck(buttonbotRight);
            }
        });


        Log.v(TAG, "Current User Score: " + String.valueOf(advScore));
        /*Hint:
            This starts the countdown timers one at a time and prepares the user.
            This also prepares level difficulty.
            It also prepares the button listeners to each button.
            You may wish to use the for loop to populate all 9 buttons with listeners.
            It also prepares the back button and updates the user score to the database
            if the back button is selected.
         */


        for(final int id : BUTTON_IDS){
            /*  HINT:
            This creates a for loop to populate all 9 buttons with listeners.
            You may use if you wish to remove or change to suit your codes.
            */
        }
    }
    @Override
    protected void onStart(){
        super.onStart();
        Intent receivingEnd = getIntent();
        int message = receivingEnd.getIntExtra("Scores", 0);
        advScore = message;
        ViewScore.setText(String.valueOf(message));
        readyTimer();
    }
    private void doCheck(Button checkButton)
    {
        /* Hint:
            Checks for hit or miss
            Log.v(TAG, FILENAME + ": Hit, score added!");
            Log.v(TAG, FILENAME + ": Missed, point deducted!");
            belongs here.
        */
        if (checkButton.getText() == "*"){
            advScore++;
            Log.v(TAG, "Hit Score added!");
        }
        else{
            advScore--;
            Log.v(TAG, "Missed, score deducted!");
        }
        ViewScore.setText(Integer.toString(advScore));
        setNewMole();
    }

    public void setNewMole() {
        /* Hint:
            Clears the previous mole location and gets a new random location of the next mole location.
            Sets the new location of the mole. Adds additional mole if the level difficulty is from 6 to 10.
         */
        Random ran = new Random();
        int randomLocation = ran.nextInt(9);
        buttontopLeft.setText("O");
        buttontopMiddle.setText("O");
        buttontopRight.setText("O");
        buttonmidLeft.setText("O");
        buttonmidMiddle.setText("O");
        buttonmidRight.setText("O");
        buttonbotLeft.setText("O");
        buttonbotMiddle.setText("O");
        buttonbotRight.setText("O");
        if (randomLocation == 0) {
            buttontopLeft.setText("*");
        } else if (randomLocation == 1) {
            buttontopMiddle.setText("*");
        } else if (randomLocation == 2) {
            buttontopRight.setText("*");
        } else if (randomLocation == 3) {
            buttonmidLeft.setText("*");
        } else if (randomLocation == 4) {
            buttonmidMiddle.setText("*");
        } else if (randomLocation == 5) {
            buttonmidRight.setText("*");
        } else if (randomLocation == 6) {
            buttonbotLeft.setText("*");
        } else if (randomLocation == 7) {
            buttonbotMiddle.setText("*");
        } else if (randomLocation == 8) {
            buttonbotRight.setText("*");
        }

//        private void updateUserScore ()
//        {
//
//     /* Hint:
//        This updates the user score to the database if needed. Also stops the timers.
//        Log.v(TAG, FILENAME + ": Update User Score...");
//      */
//            newMolePlaceTimer.cancel();
//            readyTimer.cancel();
//        }
    }
}
