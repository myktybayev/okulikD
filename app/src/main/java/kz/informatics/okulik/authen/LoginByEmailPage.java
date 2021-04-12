package kz.informatics.okulik.authen;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import kz.informatics.okulik.MainActivity;
import kz.informatics.okulik.R;
import kz.informatics.okulik.database.StoreDatabase;

import static kz.informatics.okulik.database.StoreDatabase.COLUMN_LOGIN;
import static kz.informatics.okulik.database.StoreDatabase.COLUMN_NAME;
import static kz.informatics.okulik.database.StoreDatabase.COLUMN_SURNAME;
import static kz.informatics.okulik.database.StoreDatabase.COLUMN_EMAIL;
import static kz.informatics.okulik.database.StoreDatabase.COLUMN_PASSWORD;
import static kz.informatics.okulik.database.StoreDatabase.COLUMN_CLASS;
import static kz.informatics.okulik.database.StoreDatabase.TABLE_SLOGINS;
import static kz.informatics.okulik.database.StoreDatabase.TABLE_STUDENTS;

public class LoginByEmailPage extends AppCompatActivity implements View.OnClickListener {
    Button btnLogin, btnRegistration;
    EditText email;
    EditText password;
    ProgressBar progressBar;
    StoreDatabase storeDatabase;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        initWidgets();
        btnRegistration.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }
    
    public void initWidgets() {
        btnRegistration = findViewById(R.id.btnRegistration);
        btnLogin = findViewById(R.id.btnLogin);
        email = findViewById(R.id.emailToLogin);
        password = findViewById(R.id.passwordToLogin);
        progressBar = findViewById(R.id.progressBarForLogin);

        storeDatabase = new StoreDatabase(this);
        sqLiteDatabase = storeDatabase.getWritableDatabase();
        checkLogin();

    }

    /*

    arman@gmail.com
    123123

     */



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:

                String sEmail = email.getText().toString();
                String sPassword = password.getText().toString();

                progressBar.setVisibility(View.VISIBLE);
                btnLogin.setVisibility(View.GONE);

                if(TextUtils.isEmpty(email.getText())){
                    email.setError("Толық толтырыңыз");

                    progressBar.setVisibility(View.GONE);
                    btnLogin.setVisibility(View.VISIBLE);
                    return;
                }

                if(TextUtils.isEmpty(password.getText())){
                    password.setError("Толық толтырыңыз");

                    progressBar.setVisibility(View.GONE);
                    btnLogin.setVisibility(View.VISIBLE);
                    return;
                }


                Cursor loginCursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_STUDENTS +
                        " WHERE " +
                        COLUMN_EMAIL+ "=? AND "+COLUMN_PASSWORD+ "=? ", new String[]{sEmail, sPassword});

                if(loginCursor!=null & loginCursor.getCount() > 0){
                    loginCursor.moveToFirst();

                    String fullName = loginCursor.getString(loginCursor.getColumnIndex(COLUMN_SURNAME))+ " "+
                            loginCursor.getString(loginCursor.getColumnIndex(COLUMN_NAME));

                    Toast.makeText(this, "Қош келдің: "+fullName, Toast.LENGTH_SHORT).show();


                    ContentValues userValue = new ContentValues();
                    userValue.put(COLUMN_EMAIL, sEmail);
                    userValue.put(COLUMN_LOGIN, "yes");

                    sqLiteDatabase.update(TABLE_SLOGINS, userValue, COLUMN_LOGIN+"=?", new String[]{"no"});


                    startActivity(new Intent(LoginByEmailPage.this, MainActivity.class));

                }else{

                    progressBar.setVisibility(View.GONE);
                    btnLogin.setVisibility(View.VISIBLE);

                    Toast.makeText(this, "Қолданушы табылмады!", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btnRegistration:

                startActivity(new Intent(LoginByEmailPage.this, RegistrationActivity.class));
                break;
        }
    }
    public void checkLogin(){
        Cursor loginCursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_SLOGINS + " WHERE " +
                COLUMN_LOGIN+ "=?", new String[]{"yes"});

        if(loginCursor!=null & loginCursor.getCount() > 0){
            startActivity(new Intent(LoginByEmailPage.this, MainActivity.class));
        }
    }
}


/*

    armin@gmail.com
    123123

    public void checkLogin(){

        Cursor loginCursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_SLOGINS + " WHERE " +
                COLUMN_LOGIN+ "=?", new String[]{"yes"});

        if(loginCursor!=null & loginCursor.getCount() > 0){
            startActivity(new Intent(LoginByEmailPage.this, MainActivity.class));
        }

    }


     */