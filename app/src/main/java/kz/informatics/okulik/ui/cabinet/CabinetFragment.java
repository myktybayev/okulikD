package kz.informatics.okulik.ui.cabinet;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import kz.informatics.okulik.MainActivity;
import kz.informatics.okulik.R;
import kz.informatics.okulik.authen.LoginByEmailPage;
import kz.informatics.okulik.database.StoreDatabase;

import static kz.informatics.okulik.database.StoreDatabase.COLUMN_CLASS;
import static kz.informatics.okulik.database.StoreDatabase.COLUMN_EMAIL;
import static kz.informatics.okulik.database.StoreDatabase.COLUMN_GAME_NUMBER;
import static kz.informatics.okulik.database.StoreDatabase.COLUMN_LOGIN;
import static kz.informatics.okulik.database.StoreDatabase.COLUMN_NAME;
import static kz.informatics.okulik.database.StoreDatabase.COLUMN_PASSWORD;
import static kz.informatics.okulik.database.StoreDatabase.COLUMN_SURNAME;
import static kz.informatics.okulik.database.StoreDatabase.COLUMN_UPAI;
import static kz.informatics.okulik.database.StoreDatabase.TABLE_GAMES;
import static kz.informatics.okulik.database.StoreDatabase.TABLE_SLOGINS;
import static kz.informatics.okulik.database.StoreDatabase.TABLE_STUDENTS;

public class CabinetFragment extends Fragment {

    View root;
    StoreDatabase storeDatabase;
    SQLiteDatabase sqLiteDatabase;
    TextView sInfo, sEmail, sClass;
    Button btn_oyin1, btn_oyin2, btn_oyin3;
    String oiynUpai1 = "0", oiynUpai2 = "0", oiynUpai3 = "0", oiynUpai4 = "0", oiynUpai5 = "0", oiynUpai6 = "0";

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_cabinet, container, false);

        sEmail = root.findViewById(R.id.sEmail);
        sInfo = root.findViewById(R.id.sInfo);
        sClass = root.findViewById(R.id.sClass);
        btn_oyin1 = root.findViewById(R.id.btn_oyin1);
        btn_oyin2 = root.findViewById(R.id.btn_oyin2);
        btn_oyin3 = root.findViewById(R.id.btn_oyin3);

        storeDatabase = new StoreDatabase(getActivity());
        sqLiteDatabase = storeDatabase.getWritableDatabase();

        Window window = getActivity().getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.purple_700));

        initStudent();


        return root;
    }

    public void initStudent() {

        Cursor loginCursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_SLOGINS + " WHERE " +
                COLUMN_LOGIN + "=?", new String[]{"yes"});

        if (loginCursor != null & loginCursor.getCount() > 0) {
            loginCursor.moveToFirst();

            String email = loginCursor.getString(loginCursor.getColumnIndex(COLUMN_EMAIL));
            sEmail.setText(email);


            Cursor userCursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_STUDENTS + " WHERE " +
                    COLUMN_EMAIL + "=?", new String[]{email});

            if (userCursor != null & userCursor.getCount() > 0) {
                userCursor.moveToFirst();
                String name = userCursor.getString(userCursor.getColumnIndex(COLUMN_NAME));
                String surname = userCursor.getString(userCursor.getColumnIndex(COLUMN_SURNAME));
                String sGetClass = userCursor.getString(userCursor.getColumnIndex(COLUMN_CLASS));

                sInfo.setText("Қош келдің, " + surname + " " + name);
                sClass.setText(sGetClass + " сыныбы");

                /*

                Cursor gameCursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_GAMES + " WHERE " +
                        COLUMN_EMAIL + "=? AND " + COLUMN_GAME_NUMBER + "=?", new String[]{email, "oiyn1"});

                Cursor gameCursor2 = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_GAMES + " WHERE " +
                        COLUMN_EMAIL + "=? AND " + COLUMN_GAME_NUMBER + "=?", new String[]{email, "oiyn2"});

                if (gameCursor2 != null & gameCursor2.getCount() > 0) {
                    gameCursor2.moveToLast();
                    String testUpai = gameCursor2.getString(gameCursor2.getColumnIndex(COLUMN_UPAI));
                    btn_oyin2.setText("Почтаны сәйкестендіру ойыны: " + testUpai + " ұпай");
                }

//                    String testUpai = gameCursor.getString(gameCursor.getColumnIndex(COLUMN_UPAI));
//                    btn_oyin1.setText("Танымал браузерлермен танысу ойыны: " + testUpai + " ұпай");
                 */
                Cursor gameCursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_GAMES, null);

                if (gameCursor != null & gameCursor.getCount() > 0) {
                    while (gameCursor.moveToNext()) {

                        String oiynName = gameCursor.getString(gameCursor.getColumnIndex(COLUMN_GAME_NUMBER));
                        String testUpai = gameCursor.getString(gameCursor.getColumnIndex(COLUMN_UPAI));

                        if (oiynName.equals("oiyn1")) {
                            oiynUpai1 = testUpai;

                        } else if (oiynName.equals("oiyn2")) {
                            oiynUpai2 = testUpai;

                        } else if (oiynName.equals("oiyn3")) {
                            oiynUpai3 = testUpai;

                        } else if (oiynName.equals("oiyn4")) {
                            oiynUpai4 = testUpai;

                        } else if (oiynName.equals("oiyn5")) {
                            oiynUpai5 = testUpai;

                        } else if (oiynName.equals("oiyn6")) {
                            oiynUpai6 = testUpai;
                        }

                        Log.i("oiyn_db", "oiynName: " + oiynName);
                        Log.i("oiyn_db", "testUpai: " + testUpai);
                    }

                }


                btn_oyin1.setText("Танымал браузерлермен танысу ойыны: \n" + oiynUpai1 + " ұпай");
                btn_oyin2.setText("Почтаны сәйкестендіру ойыны: \n" + oiynUpai2 + " ұпай");
                btn_oyin3.setText("Почтаны дұрыс жина ойыны: \n" + oiynUpai3 + " ұпай");

            }


        }
    }
}