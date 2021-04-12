package kz.informatics.okulik.authen;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import kz.informatics.okulik.MainActivity;
import kz.informatics.okulik.R;
import kz.informatics.okulik.database.StoreDatabase;
import kz.informatics.okulik.splash.SplashActivity;

import static kz.informatics.okulik.database.StoreDatabase.COLUMN_NAME;
import static kz.informatics.okulik.database.StoreDatabase.COLUMN_SURNAME;
import static kz.informatics.okulik.database.StoreDatabase.COLUMN_EMAIL;
import static kz.informatics.okulik.database.StoreDatabase.COLUMN_PASSWORD;
import static kz.informatics.okulik.database.StoreDatabase.COLUMN_CLASS;
import static kz.informatics.okulik.database.StoreDatabase.TABLE_STUDENTS;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnRegistration;
    TextInputEditText studentName, studentSurname, studentClass, emailToLogin, passwordToLogin;
    ProgressBar progressBar;

    StoreDatabase storeDatabase;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        initWidgets();
        btnRegistration.setOnClickListener(this);
    }

    public void initWidgets() {
        btnRegistration = findViewById(R.id.btnRegistration);

        studentName = findViewById(R.id.studentName);
        studentSurname = findViewById(R.id.studentSurname);
        studentClass = findViewById(R.id.studentClass);
        emailToLogin = findViewById(R.id.emailToLogin);
        passwordToLogin = findViewById(R.id.passwordToLogin);

//        progressBar = findViewById(R.id.progressBarForLogin);


        storeDatabase = new StoreDatabase(this);
        sqLiteDatabase = storeDatabase.getWritableDatabase();

    }

    @Override
    public void onClick(View view) {

        if(TextUtils.isEmpty(studentName.getText())){
            studentName.setError("Толық толтырыңыз");
            return;
        }

        if(TextUtils.isEmpty(studentSurname.getText())){
            studentSurname.setError("Толық толтырыңыз");
            return;
        }

        if(TextUtils.isEmpty(studentClass.getText())){
            studentClass.setError("Толық толтырыңыз");
            return;
        }

        if(TextUtils.isEmpty(emailToLogin.getText())){
            emailToLogin.setError("Толық толтырыңыз");
            return;
        }

        if(TextUtils.isEmpty(passwordToLogin.getText())){
            passwordToLogin.setError("Толық толтырыңыз");
            return;
        }

        ContentValues userValue = new ContentValues();
        userValue.put(COLUMN_NAME, studentName.getText().toString());
        userValue.put(COLUMN_SURNAME, studentSurname.getText().toString());
        userValue.put(COLUMN_CLASS, studentClass.getText().toString());
        userValue.put(COLUMN_EMAIL, emailToLogin.getText().toString());
        userValue.put(COLUMN_PASSWORD, passwordToLogin.getText().toString());

        sqLiteDatabase.insert(TABLE_STUDENTS, null, userValue);

        Toast.makeText(this, "Оқушы аккаунт сәтті тіркелді", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(RegistrationActivity.this, LoginByEmailPage.class));
    }
}
