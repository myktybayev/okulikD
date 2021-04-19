package kz.informatics.okulik.ui.about;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import kz.informatics.okulik.R;
import kz.informatics.okulik.authen.LoginByEmailPage;
import kz.informatics.okulik.database.StoreDatabase;

import static kz.informatics.okulik.database.StoreDatabase.COLUMN_LOGIN;
import static kz.informatics.okulik.database.StoreDatabase.TABLE_SLOGINS;

public class AboutFragment extends Fragment {

    View root;
    StoreDatabase storeDatabase;
    SQLiteDatabase sqLiteDatabase;
    Button btnLogOut;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.about_us_fragment, container, false);

        storeDatabase = new StoreDatabase(getActivity());
        sqLiteDatabase = storeDatabase.getWritableDatabase();

        Window window = getActivity().getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.user_back));
        btnLogOut = root.findViewById(R.id.btnLogOut);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ContentValues userValue = new ContentValues();
                userValue.put(COLUMN_LOGIN, "no");
                sqLiteDatabase.update(TABLE_SLOGINS, userValue, "login = ?", new String[]{"yes"});

                startActivity(new Intent(getActivity(), LoginByEmailPage.class));
            }
        });

        return root;
    }
}