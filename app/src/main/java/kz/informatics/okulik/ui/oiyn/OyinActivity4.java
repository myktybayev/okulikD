package kz.informatics.okulik.ui.oiyn;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import kz.informatics.okulik.R;
import kz.informatics.okulik.database.StoreDatabase;

import static kz.informatics.okulik.database.StoreDatabase.COLUMN_EMAIL;
import static kz.informatics.okulik.database.StoreDatabase.COLUMN_GAME_NUMBER;
import static kz.informatics.okulik.database.StoreDatabase.COLUMN_LOGIN;
import static kz.informatics.okulik.database.StoreDatabase.COLUMN_UPAI;
import static kz.informatics.okulik.database.StoreDatabase.TABLE_GAMES;
import static kz.informatics.okulik.database.StoreDatabase.TABLE_SLOGINS;

public class OyinActivity4 extends AppCompatActivity implements View.OnClickListener {

    TextView tv_upai, card_front1, card_back1, card_front2, card_back2, card_front3, card_back3, card_front4, card_back4, card_front5, card_back5, card_front6, card_back6, card_front7, card_back7, card_front8, card_back8;
    boolean isCardOpen1, isCardOpen2, isCardOpen3, isCardOpen4 , isCardOpen5, isCardOpen6, isCardOpen7, isCardOpen8 = false;
    AnimatorSet front1, back1, front2, back2, front3, back3, front4, back4, front5, back5, front6, back6, front7, back7, front8, back8;
    int upaiCount = 0;
    MediaPlayer mp, applause;

    StoreDatabase storeDatabase;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oiyn4);
        initViews();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.card_back:

                openCard(1);
                isCardOpen1 = true;

                if(isCardOpen2){
                    startTimerToClose2(2, 1);

                }else if(isCardOpen3){
                    startTimerToClose2(3, 1);

                }else if(isCardOpen4){
                    startTimerToClose2(4, 1);

                }else if(isCardOpen5){
                    startTimerToClose2(5, 1);

                }else if(isCardOpen6){
                    startTimerToClose2(6, 1);

                }else if(isCardOpen7){
                    startTimerToClose2(7, 1);

                }else if(isCardOpen8){
                    startTimerToClose2(8, 1);

                }

                break;

            case R.id.card_back2:
                openCard(2);
                isCardOpen2 = true;

                if(isCardOpen1){
                    startTimerToClose2(1, 2);
                }else if(isCardOpen3){
                    startTimerToClose2(3, 2);

                }else if(isCardOpen4){
                    startTimerToClose2(4, 2);

                }else if(isCardOpen5){
                    startTimerToClose2(5, 2);

                }else if(isCardOpen6){
                    startTimerToClose2(6, 2);

                }else if(isCardOpen7){
                    startTimerToClose2(7, 2);

                }else if(isCardOpen8){
                    startTimerToClose2(8, 2);

                }

                break;


            case R.id.card_back3:
                openCard(3);
                isCardOpen3 = true;

                if(isCardOpen1){
                    startTimerToClose2(1, 3);

                }else if(isCardOpen2){
                    startTimerToClose2(2, 3);

                }else if(isCardOpen4){
                    startTimerToClose2(4, 3);

                }else if(isCardOpen5){
                    startTimerToClose2(5, 3);

                }else if(isCardOpen6){
                    startTimerToClose2(6, 3);

                }else if(isCardOpen7){
                    startTimerToClose2(7, 3);

                }else if(isCardOpen8){
                    startTimerToClose2(8, 3);

                }

                break;

            case R.id.card_back4:
                openCard(4);
                isCardOpen4 = true;

                if(isCardOpen1){
                    startTimerToClose2(1, 4);

                }else if(isCardOpen2){
                    startTimerToClose2(2, 4);

                }else if(isCardOpen3){
                    startTimerToClose2(3, 4);

                }else if(isCardOpen5){
                    startTimerToClose2(5, 4);

                }else if(isCardOpen6){
                    startTimerToClose2(6, 4);
                }else if(isCardOpen7){
                    startTimerToClose2(7, 4);

                }else if(isCardOpen8){
                    startTimerToClose2(8, 4);

                }

                break;

            case R.id.card_back5:
                openCard(5);
                isCardOpen5 = true;

                if(isCardOpen1){
                    startTimerToClose2(1, 5);

                }else if(isCardOpen2){
                    startTimerToClose2(2, 5);

                }else if(isCardOpen3){
                    startTimerToClose2(3, 5);

                }else if(isCardOpen4){
                    startTimerToClose2(4, 5);

                }else if(isCardOpen6){
                    startTimerToClose2(6, 5);

                }else if(isCardOpen7){
                    startTimerToClose2(7, 5);

                }else if(isCardOpen8){
                    startTimerToClose2(8, 5);

                }

                break;

            case R.id.card_back6:
                openCard(6);
                isCardOpen6 = true;

                if(isCardOpen1){
                    startTimerToClose2(1, 6);

                }else if(isCardOpen2){
                    startTimerToClose2(2, 6);

                }else if(isCardOpen3){
                    startTimerToClose2(3, 6);

                }else if(isCardOpen4){
                    startTimerToClose2(4, 6);

                }else if(isCardOpen5){
                    startTimerToClose2(5, 6);

                }else if(isCardOpen7){
                    startTimerToClose2(7, 6);

                }else if(isCardOpen8){
                    startTimerToClose2(8, 6);

                }

                break;

            case R.id.card_back7:
                openCard(7);
                isCardOpen7 = true;

                if(isCardOpen1){
                    startTimerToClose2(1, 7);

                }else if(isCardOpen2){
                    startTimerToClose2(2, 7);

                }else if(isCardOpen3){
                    startTimerToClose2(3, 7);

                }else if(isCardOpen4){
                    startTimerToClose2(4, 7);

                }else if(isCardOpen5){
                    startTimerToClose2(5, 7);

                }else if(isCardOpen6){
                    startTimerToClose2(6, 7);

                }else if(isCardOpen8){
                    startTimerToClose2(8, 7);

                }

                break;

            case R.id.card_back8:
                openCard(8);
                isCardOpen8 = true;

                if(isCardOpen1){
                    startTimerToClose2(1, 8);

                }else if(isCardOpen2){
                    startTimerToClose2(2, 8);

                }else if(isCardOpen3){
                    startTimerToClose2(3, 8);

                }else if(isCardOpen4){
                    startTimerToClose2(4, 8);

                }else if(isCardOpen5){
                    startTimerToClose2(5, 8);

                }else if(isCardOpen6){
                    startTimerToClose2(6, 8);

                }else if(isCardOpen7){
                    startTimerToClose2(7, 8);

                }

                break;


        }
    }

    public void initViews(){
        tv_upai = findViewById(R.id.tv_upai);
        card_front1 = findViewById(R.id.card_front);
        card_back1 = findViewById(R.id.card_back);
        card_front2 = findViewById(R.id.card_front2);
        card_back2 = findViewById(R.id.card_back2);
        card_front3 = findViewById(R.id.card_front3);
        card_back3 = findViewById(R.id.card_back3);
        card_front4 = findViewById(R.id.card_front4);
        card_back4 = findViewById(R.id.card_back4);
        card_front5 = findViewById(R.id.card_front5);
        card_back5 = findViewById(R.id.card_back5);
        card_front6 = findViewById(R.id.card_front6);
        card_back6 = findViewById(R.id.card_back6);
        card_front7 = findViewById(R.id.card_front7);
        card_back7 = findViewById(R.id.card_back7);
        card_front8 = findViewById(R.id.card_front8);
        card_back8 = findViewById(R.id.card_back8);

        card_back1.setOnClickListener(this);
        card_back2.setOnClickListener(this);
        card_back3.setOnClickListener(this);
        card_back4.setOnClickListener(this);
        card_back5.setOnClickListener(this);
        card_back6.setOnClickListener(this);
        card_back7.setOnClickListener(this);
        card_back8.setOnClickListener(this);

        storeDatabase = new StoreDatabase(this);
        sqLiteDatabase = storeDatabase.getWritableDatabase();

        mp = MediaPlayer.create(getApplicationContext(), R.raw.correct_audio);
        applause = MediaPlayer.create(getApplicationContext(), R.raw.applause);

        front1 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.front);
        back1 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.back);

        front2 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.front);
        back2 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.back);

        front3 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.front);
        back3 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.back);

        front4 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.front);
        back4 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.back);

        front5 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.front);
        back5 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.back);

        front6 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.front);
        back6 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.back);

        front7 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.front);
        back7 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.back);

        front8 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.front);
        back8 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.back);

    }

    public void checkAnnswer(int cardNumber1, int cardNumber2){
        String cardText1 = "0", cardText2 = "9";

        if(cardNumber1 == 1){
            cardText1 = card_front1.getText().toString();

        }else if(cardNumber1 == 2){
            cardText1 = card_front2.getText().toString();

        }else if(cardNumber1 == 3){
            cardText1 = card_front3.getText().toString();

        }else if(cardNumber1 == 4){
            cardText1 = card_front4.getText().toString();

        }else if(cardNumber1 == 5){
            cardText1 = card_front5.getText().toString();

        }else if(cardNumber1 == 6){
            cardText1 = card_front6.getText().toString();

        }else if(cardNumber1 == 7){
            cardText1 = card_front7.getText().toString();

        }else if(cardNumber1 == 8){
            cardText1 = card_front8.getText().toString();
        }

        if(cardNumber2 == 1){
            cardText2 = card_front1.getText().toString();

        }else if(cardNumber2 == 2){
            cardText2 = card_front2.getText().toString();

        }else if(cardNumber2 == 3){
            cardText2 = card_front3.getText().toString();

        }else if(cardNumber2 == 4){
            cardText2 = card_front4.getText().toString();

        }else if(cardNumber2 == 5){
            cardText2 = card_front5.getText().toString();

        }else if(cardNumber2 == 6){
            cardText2 = card_front6.getText().toString();

        }else if(cardNumber2 == 7){
            cardText2 = card_front7.getText().toString();

        }else if(cardNumber2 == 8){
            cardText2 = card_front8.getText().toString();
        }

        if(cardText1.equals(cardText2)){
            upaiCount = upaiCount + 10;
            tv_upai.setText("Ұпай: "+upaiCount);
            mp.start();

            if(upaiCount == 40){


                Cursor loginCursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_SLOGINS + " WHERE " +
                        COLUMN_LOGIN+ "=?", new String[]{"yes"});

                if(loginCursor!=null & loginCursor.getCount() > 0) {
                    loginCursor.moveToFirst();
                    String email = loginCursor.getString(loginCursor.getColumnIndex(COLUMN_EMAIL));

                    ContentValues userValue = new ContentValues();
                    userValue.put(COLUMN_EMAIL, email);
                    userValue.put(COLUMN_GAME_NUMBER, "oiyn4");
                    userValue.put(COLUMN_UPAI, "40");

                    sqLiteDatabase.insert(TABLE_GAMES, null, userValue);

                    Cursor test = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_GAMES, null);

                    if (test != null & test.getCount() > 0) {
                        test.moveToFirst();
                        String testEmail = test.getString(test.getColumnIndex(COLUMN_EMAIL));
                        String testGN = test.getString(test.getColumnIndex(COLUMN_GAME_NUMBER));
                        String testUpai = test.getString(test.getColumnIndex(COLUMN_UPAI));
                    }

                    applause.start();
                    Toast.makeText(this, "Сіз ұттыңыз, құтты болсын!", Toast.LENGTH_LONG).show();

                    new CountDownTimer(2500, 1000) {

                        public void onTick(long millisUntilFinished) {

                        }

                        public void onFinish() {
                            onBackPressed();
                        }

                    }.start();
                }


            }

            if(cardNumber1 == 1) {
                card_front1.setVisibility(View.INVISIBLE);
                card_back1.setVisibility(View.INVISIBLE);
            }else if(cardNumber1 == 2) {
                card_front2.setVisibility(View.INVISIBLE);
                card_back2.setVisibility(View.INVISIBLE);
            }else if(cardNumber1 == 3) {
                card_front3.setVisibility(View.INVISIBLE);
                card_back3.setVisibility(View.INVISIBLE);
            }else if(cardNumber1 == 4) {
                card_front4.setVisibility(View.INVISIBLE);
                card_back4.setVisibility(View.INVISIBLE);
            }else if(cardNumber1 == 5) {
                card_front5.setVisibility(View.INVISIBLE);
                card_back5.setVisibility(View.INVISIBLE);

            }else if(cardNumber1 == 6) {
                card_front6.setVisibility(View.INVISIBLE);
                card_back6.setVisibility(View.INVISIBLE);

            }else if(cardNumber1 == 7) {
                card_front7.setVisibility(View.INVISIBLE);
                card_back7.setVisibility(View.INVISIBLE);

            }else if(cardNumber1 == 8) {
                card_front8.setVisibility(View.INVISIBLE);
                card_back8.setVisibility(View.INVISIBLE);
            }

            if(cardNumber2 == 1) {
                card_front1.setVisibility(View.INVISIBLE);
                card_back1.setVisibility(View.INVISIBLE);

            }else if(cardNumber2 == 2) {
                card_front2.setVisibility(View.INVISIBLE);
                card_back2.setVisibility(View.INVISIBLE);

            }else if(cardNumber2 == 3) {
                card_front3.setVisibility(View.INVISIBLE);
                card_back3.setVisibility(View.INVISIBLE);

            }else if(cardNumber2 == 4) {
                card_front4.setVisibility(View.INVISIBLE);
                card_back4.setVisibility(View.INVISIBLE);

            }else if(cardNumber2 == 5) {
                card_front5.setVisibility(View.INVISIBLE);
                card_back5.setVisibility(View.INVISIBLE);

            }else if(cardNumber2 == 6) {
                card_front6.setVisibility(View.INVISIBLE);
                card_back6.setVisibility(View.INVISIBLE);

            }else if(cardNumber2 == 7) {
                card_front7.setVisibility(View.INVISIBLE);
                card_back7.setVisibility(View.INVISIBLE);

            }else if(cardNumber2 == 8) {
                card_front8.setVisibility(View.INVISIBLE);
                card_back8.setVisibility(View.INVISIBLE);
            }
        }

    }


    public void startTimerToClose2(int cardNumber1, int cardNumber2){

        card_back1.setEnabled(false);
        card_back2.setEnabled(false);
        card_back3.setEnabled(false);
        card_back4.setEnabled(false);
        card_back5.setEnabled(false);
        card_back6.setEnabled(false);
        card_back7.setEnabled(false);
        card_back8.setEnabled(false);

        new CountDownTimer(1500, 1000) {

            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                closeCard(cardNumber1);
                closeCard(cardNumber2);

                checkAnnswer(cardNumber1, cardNumber2);
                card_back1.setEnabled(true);
                card_back2.setEnabled(true);
                card_back3.setEnabled(true);
                card_back4.setEnabled(true);
                card_back5.setEnabled(true);
                card_back6.setEnabled(true);
                card_back7.setEnabled(true);
                card_back8.setEnabled(true);
            }

        }.start();
    }

    public void openCard(int cardNumber){

        if(cardNumber == 1){

            front1.setTarget(card_back1);
            back1.setTarget(card_front1);
            front1.start();
            back1.start();

        }else if(cardNumber == 2){

            front2.setTarget(card_back2);
            back2.setTarget(card_front2);
            front2.start();
            back2.start();

        }else if(cardNumber == 3){

            front3.setTarget(card_back3);
            back3.setTarget(card_front3);
            front3.start();
            back3.start();

        }else if(cardNumber == 4){

            front4.setTarget(card_back4);
            back4.setTarget(card_front4);
            front4.start();
            back4.start();

        }else if(cardNumber == 5){

            front5.setTarget(card_back5);
            back5.setTarget(card_front5);
            front5.start();
            back5.start();

        }else if(cardNumber == 6){

            front6.setTarget(card_back6);
            back6.setTarget(card_front6);
            front6.start();
            back6.start();

        }else if(cardNumber == 7){

            front7.setTarget(card_back7);
            back7.setTarget(card_front7);
            front7.start();
            back7.start();

        }else if(cardNumber == 8){

            front8.setTarget(card_back8);
            back8.setTarget(card_front8);
            front8.start();
            back8.start();
        }
    }

    public void closeCard(int cardNumber){

        if(cardNumber == 1) {
            front1.setTarget(card_front1);
            back1.setTarget(card_back1);
            front1.start();
            back1.start();
            isCardOpen1 = false;
        }else if(cardNumber == 2) {
            front2.setTarget(card_front2);
            back2.setTarget(card_back2);
            front2.start();
            back2.start();
            isCardOpen2 = false;
        }else if(cardNumber == 3) {
            front3.setTarget(card_front3);
            back3.setTarget(card_back3);
            front3.start();
            back3.start();
            isCardOpen3 = false;
        }else if(cardNumber == 4) {
            front4.setTarget(card_front4);
            back4.setTarget(card_back4);
            front4.start();
            back4.start();
            isCardOpen4 = false;

        }else if(cardNumber == 5) {
            front5.setTarget(card_front5);
            back5.setTarget(card_back5);
            front5.start();
            back5.start();
            isCardOpen5 = false;

        }else if(cardNumber == 6) {
            front6.setTarget(card_front6);
            back6.setTarget(card_back6);
            front6.start();
            back6.start();
            isCardOpen6 = false;

        }else if(cardNumber == 7) {
            front7.setTarget(card_front7);
            back7.setTarget(card_back7);
            front7.start();
            back7.start();
            isCardOpen7 = false;

        }else if(cardNumber == 8) {
            front8.setTarget(card_front8);
            back8.setTarget(card_back8);
            front8.start();
            back8.start();
            isCardOpen8 = false;
        }

    }
}