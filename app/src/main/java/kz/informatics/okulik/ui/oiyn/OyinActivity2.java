package kz.informatics.okulik.ui.oiyn;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import kz.informatics.okulik.R;
import kz.informatics.okulik.database.StoreDatabase;

import static kz.informatics.okulik.database.StoreDatabase.COLUMN_EMAIL;
import static kz.informatics.okulik.database.StoreDatabase.COLUMN_GAME_NUMBER;
import static kz.informatics.okulik.database.StoreDatabase.COLUMN_LOGIN;
import static kz.informatics.okulik.database.StoreDatabase.COLUMN_UPAI;
import static kz.informatics.okulik.database.StoreDatabase.TABLE_GAMES;
import static kz.informatics.okulik.database.StoreDatabase.TABLE_SLOGINS;

public class OyinActivity2 extends AppCompatActivity implements View.OnClickListener {
    TextView tv_userName, tv_symbol, tv_server;
    TextView tv_res1, tv_res2, tv_res3;
    TextView tv_choice1, tv_choice2, tvUpai;
    Button btnCheck, btnBitiru;

    MediaPlayer correct, incorrect;

    int colors[] = {R.color.color1, R.color.color2, R.color.color3};
    int colorIndex = 0;

    int resIndex = 0;
    int resChoice1, resChoice2, resChoice3 = 0, upaiSan = 0;
    ArrayList<String> namesList, symbolList, serverList, selectList;

    StoreDatabase storeDatabase;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyin2);
        tv_userName = findViewById(R.id.tv_userName);
        tv_symbol = findViewById(R.id.tv_symbol);
        tv_server = findViewById(R.id.tv_server);
        tv_res1 = findViewById(R.id.tv_userNameRes);
        tv_res2 = findViewById(R.id.tv_symbolRes);
        tv_res3 = findViewById(R.id.tv_serverRes);
        tvUpai = findViewById(R.id.tvUpai);

        tv_choice1 = findViewById(R.id.tv_choise1);
        tv_choice2 = findViewById(R.id.tv_choise2);

        btnCheck = findViewById(R.id.btnCheck);
        btnBitiru = findViewById(R.id.btnBitiru);
        namesList = new ArrayList<>();
        symbolList = new ArrayList<>();
        serverList = new ArrayList<>();
        selectList = new ArrayList<>();

        storeDatabase = new StoreDatabase(this);
        sqLiteDatabase = storeDatabase.getWritableDatabase();

        correct = MediaPlayer.create(getApplicationContext(), R.raw.correct_audio);
        incorrect = MediaPlayer.create(getApplicationContext(), R.raw.incorrect);
        addDataList();
        shuffleList();

        tv_userName.setOnClickListener(this);
        tv_symbol.setOnClickListener(this);
        tv_server.setOnClickListener(this);
        tv_res1.setOnClickListener(this);
        tv_res2.setOnClickListener(this);
        tv_res3.setOnClickListener(this);
        btnCheck.setOnClickListener(this);
        btnBitiru.setOnClickListener(this);
    }

    public void addDataList() {
        namesList.add("arman");
        namesList.add("dias-2010");
        namesList.add("kirmizi11");
        namesList.add("orken07");
        namesList.add("almas");
        namesList.add("asen101");
        namesList.add("usen15");

        symbolList.add("@");

        serverList.add("mail.ru");
        serverList.add("gmail.com");
        serverList.add("yandex.ru");
        serverList.add("yahoo.com");
    }

    public void shuffleList() {
        setDefault();
        Collections.shuffle(namesList);
        Collections.shuffle(serverList);

        selectList.clear();
        selectList.add(namesList.get(0));
        selectList.add(symbolList.get(0));
        selectList.add(serverList.get(0));

        Collections.shuffle(selectList);

        tv_res1.setText(selectList.get(0));
        tv_res2.setText(selectList.get(1));
        tv_res3.setText(selectList.get(2));
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_userName:
                setBackgroundColor(tv_userName, colorIndex);
                setEnableGroup(1);
                resIndex = 1;
                break;

            case R.id.tv_symbol:
                setBackgroundColor(tv_symbol, colorIndex);
                setEnableGroup(1);
                resIndex = 2;

                break;
            case R.id.tv_server:
                setBackgroundColor(tv_server, colorIndex);
                setEnableGroup(1);
                resIndex = 3;

                break;
            case R.id.tv_userNameRes:
                setBackgroundColor(tv_res1, colorIndex);

                colorIndex = (colorIndex == 2) ? 0 : ++colorIndex;
                setEnableGroup(2);
                resChoice1 = resIndex;

                break;
            case R.id.tv_symbolRes:
                setBackgroundColor(tv_res2, colorIndex);

                colorIndex = (colorIndex == 2) ? 0 : ++colorIndex;
                setEnableGroup(2);
                resChoice2 = resIndex;

                break;
            case R.id.tv_serverRes:
                setBackgroundColor(tv_res3, colorIndex);

                colorIndex = (colorIndex == 2) ? 0 : ++colorIndex;
                setEnableGroup(2);
                resChoice3 = resIndex;

                break;

            case R.id.btnBitiru:

                Cursor loginCursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_SLOGINS + " WHERE " +
                        COLUMN_LOGIN+ "=?", new String[]{"yes"});

                if(loginCursor!=null & loginCursor.getCount() > 0) {
                    loginCursor.moveToFirst();
                    String email = loginCursor.getString(loginCursor.getColumnIndex(COLUMN_EMAIL));


                    ContentValues userValue = new ContentValues();
                    userValue.put(COLUMN_EMAIL, email);
                    userValue.put(COLUMN_GAME_NUMBER, "oiyn2");
                    userValue.put(COLUMN_UPAI, "" + upaiSan);

                    sqLiteDatabase.insert(TABLE_GAMES, null, userValue);
                }
                onBackPressed();

                break;

            case R.id.btnCheck:
                if(checker()){
                    correct.start();
                    Toast.makeText(this, "Дұрысс!", Toast.LENGTH_SHORT).show();
                    upaiSan = upaiSan + 10;
                    tvUpai.setText("Ұпай: "+upaiSan);
                    restartGame();

                }else{
                    incorrect.start();
                    Toast.makeText(this, "Қате шықты!", Toast.LENGTH_SHORT).show();
                    restartGame();

                }

                break;
        }
    }

    public void restartGame(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                shuffleList();
            }
        }, 1500);
    }

    public boolean checker(){
        if(resChoice1 == 1){
            if(!namesList.contains(tv_res1.getText().toString())){
                return false;
            }
        }else if(resChoice1 == 2){
            if(!namesList.contains(tv_res2.getText().toString())){
                return false;
            }
        }else if(resChoice1 == 3){
            if(!namesList.contains(tv_res3.getText().toString())){
                return false;
            }
        }

        if(resChoice2 == 1){
            if(!symbolList.contains(tv_res1.getText().toString())){
                return false;
            }
        }else if(resChoice2 == 2){
            if(!symbolList.contains(tv_res2.getText().toString())){
                return false;
            }
        }else if(resChoice2 == 3){
            if(!symbolList.contains(tv_res3.getText().toString())){
                return false;
            }
        }

        if(resChoice3 == 1){
            if(!serverList.contains(tv_res1.getText().toString())){
                return false;
            }
        }else if(resChoice3 == 2){
            if(!serverList.contains(tv_res2.getText().toString())){
                return false;
            }
        }else if(resChoice3 == 3){
            if(!serverList.contains(tv_res3.getText().toString())){
                return false;
            }
        }

        return true;
    }
    public void setEnableGroup(int groupNumber) {
        if (groupNumber == 1) {

            tv_userName.setEnabled(false);
            tv_symbol.setEnabled(false);
            tv_server.setEnabled(false);

            tv_res1.setEnabled(true);
            tv_res2.setEnabled(true);
            tv_res3.setEnabled(true);

            tv_choice1.setVisibility(View.INVISIBLE);
            tv_choice2.setVisibility(View.VISIBLE);

        } else if (groupNumber == 2) {

            tv_res1.setEnabled(false);
            tv_res2.setEnabled(false);
            tv_res3.setEnabled(false);

            tv_userName.setEnabled(true);
            tv_symbol.setEnabled(true);
            tv_server.setEnabled(true);

            tv_choice1.setVisibility(View.VISIBLE);
            tv_choice2.setVisibility(View.INVISIBLE);

        }

    }

    public void setTextColorWhite(TextView tv) {
        tv.setTextColor(getResources().getColor(R.color.white));
    }

    public void setDefault() {
        tv_userName.setBackgroundColor(getResources().getColor(R.color.white));
        tv_symbol.setBackgroundColor(getResources().getColor(R.color.white));
        tv_server.setBackgroundColor(getResources().getColor(R.color.white));
        tv_res1.setBackgroundColor(getResources().getColor(R.color.white));
        tv_res2.setBackgroundColor(getResources().getColor(R.color.white));
        tv_res3.setBackgroundColor(getResources().getColor(R.color.white));

        tv_userName.setTextColor(getResources().getColor(R.color.black));
        tv_symbol.setTextColor(getResources().getColor(R.color.black));
        tv_server.setTextColor(getResources().getColor(R.color.black));
        tv_res1.setTextColor(getResources().getColor(R.color.black));
        tv_res2.setTextColor(getResources().getColor(R.color.black));
        tv_res3.setTextColor(getResources().getColor(R.color.black));
    }

    public void setBackgroundColor(TextView tv, int colorIndex) {
        tv.setBackgroundColor(getResources().getColor(colors[colorIndex]));
        setTextColorWhite(tv);
    }

}