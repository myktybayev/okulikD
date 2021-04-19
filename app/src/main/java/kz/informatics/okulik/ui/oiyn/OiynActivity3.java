package kz.informatics.okulik.ui.oiyn;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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

public class OiynActivity3 extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3 , btn4, btn5;
    Button btnCheck, btnBitiru;
    TextView tv_result, tvUpai, textView;
    boolean firstClick = false;
    ArrayList<String> nameList, serverList, selectList;
    int clickCount = 0;
    String correct;
    int upai = 0;
    Animation bounceAnimation;
    StoreDatabase storeDatabase;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oiyn3);

        tv_result = findViewById(R.id.tv_result);
        tvUpai = findViewById(R.id.tvUpai);
        textView = findViewById(R.id.textView);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btnCheck = findViewById(R.id.btnCheck);
        btnBitiru = findViewById(R.id.btnBitiru);

        nameList = new ArrayList<>();
        serverList = new ArrayList<>();
        selectList = new ArrayList<>();
        bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce);

        addList();
        initVariantsView();
        storeDatabase = new StoreDatabase(this);
        sqLiteDatabase = storeDatabase.getWritableDatabase();

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btnCheck.setOnClickListener(this);
        btnBitiru.setOnClickListener(this);
    }

    @SuppressLint("DefaultLocale")
    public void addList(){

        nameList.add("arman");
        nameList.add("dias-2010");
        nameList.add("kirmizi11");
        nameList.add("orken07");

        serverList.add("mail.ru");
        serverList.add("yandex.ru");
        serverList.add("gmail.com");
        serverList.add("yahoo.com");


    }

    public void initVariantsView(){

        Collections.shuffle(nameList);
        Collections.shuffle(serverList);

        String serverFull = serverList.get(0); // gmail.com
        String serverName = serverFull.substring(0, serverFull.indexOf(".")); // gmail.com
        String serverLang = serverFull.substring(serverFull.indexOf(".")+1);

        selectList.clear();
        selectList.add(nameList.get(0));
        selectList.add("@");
        selectList.add(".");
        selectList.add(serverName);
        selectList.add(serverLang);

        Collections.shuffle(selectList);

        correct = String.format("%s@%s.%s", nameList.get(0), serverName, serverLang);

        btn1.setText(selectList.get(0));
        btn2.setText(selectList.get(1));
        btn3.setText(selectList.get(2));
        btn4.setText(selectList.get(3));
        btn5.setText(selectList.get(4));
    }

    public void setVisibleAll(){

        initVariantsView();
        clickCount = 0;
        tv_result.setText("");
        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);
        btn4.setVisibility(View.VISIBLE);
        btn5.setVisibility(View.VISIBLE);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        clickCount++;


        if(!firstClick){
            tv_result.setText("");
            tv_result.setTextColor(getResources().getColor(R.color.black));

            firstClick = true;
        }

        switch (view.getId()){
            case R.id.btn1:
                btn1.setVisibility(View.INVISIBLE);
                tv_result.setText(tv_result.getText().toString()+btn1.getText());
                break;

            case R.id.btn2:
                btn2.setVisibility(View.INVISIBLE);
                tv_result.setText(tv_result.getText().toString()+btn2.getText());

                break;

            case R.id.btn3:
                btn3.setVisibility(View.INVISIBLE);
                tv_result.setText(tv_result.getText().toString()+btn3.getText());

                break;

            case R.id.btn4:
                btn4.setVisibility(View.INVISIBLE);
                tv_result.setText(tv_result.getText().toString()+btn4.getText());

                break;

            case R.id.btn5:
                btn5.setVisibility(View.INVISIBLE);
                tv_result.setText(tv_result.getText().toString()+btn5.getText());

                break;

            case R.id.btnCheck:
                setVisibleAll();

                break;

            case R.id.btnBitiru:

                finishGame();

                break;

        }

        checkAnswer();
    }

    public void finishGame(){
        Cursor loginCursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_SLOGINS + " WHERE " +
                COLUMN_LOGIN+ "=?", new String[]{"yes"});

        if(loginCursor!=null & loginCursor.getCount() > 0) {
            loginCursor.moveToFirst();
            String email = loginCursor.getString(loginCursor.getColumnIndex(COLUMN_EMAIL));


            ContentValues userValue = new ContentValues();
            userValue.put(COLUMN_EMAIL, email);
            userValue.put(COLUMN_GAME_NUMBER, "oiyn3");
            userValue.put(COLUMN_UPAI, "" + upai);

            sqLiteDatabase.insert(TABLE_GAMES, null, userValue);
        }
        onBackPressed();
    }

    public void checkAnswer(){

        if(clickCount == 5){
            clickCount = 0;
            Log.i("resres", ""+tv_result.getText());

            if(correct.equals(tv_result.getText().toString())){
                upai = upai + 10;
                animateIncreasePoint();

            }else{

                upai = upai - 5;

                animateDecreasePoint();
            }

            tvUpai.setText("Ұпай: "+upai);
        }
    }

    private void animateIncreasePoint(){
        textView.setVisibility(View.VISIBLE);
        textView.setTextColor(getResources().getColor(R.color.dark_green));
        textView.setText("Дұрыс \nұпай +10");
        textView.startAnimation(bounceAnimation);
        startAnimToHide();
    }

    public void startAnimToHide(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                textView.setTextColor(getResources().getColor(R.color.white));
            }
        }, 2000);
    }

    private void animateDecreasePoint(){
        textView.setVisibility(View.VISIBLE);
        textView.setTextColor(getResources().getColor(R.color.dark_red));
        textView.setText("Дұрыс емес \nұпай -5");
        textView.startAnimation(bounceAnimation);
        startAnimToHide();
    }
}