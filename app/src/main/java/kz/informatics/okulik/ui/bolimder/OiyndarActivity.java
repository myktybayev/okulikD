package kz.informatics.okulik.ui.bolimder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import kz.informatics.okulik.R;
import kz.informatics.okulik.ui.oiyn.OiynActivity3;
import kz.informatics.okulik.ui.oiyn.OyinActivity1;
import kz.informatics.okulik.ui.oiyn.OyinActivity2;
import kz.informatics.okulik.ui.oiyn.OyinActivity4;

public class OiyndarActivity extends AppCompatActivity {

    RelativeLayout rl_oyin1, rl_oyin2, rl_oyin3, rl_oyin4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oiyndar);

        rl_oyin1 = findViewById(R.id.rl_oyin1);
        rl_oyin2 = findViewById(R.id.rl_oyin2);
        rl_oyin3 = findViewById(R.id.rl_oyin3);
        rl_oyin4 = findViewById(R.id.rl_oyin4);

        rl_oyin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OiyndarActivity.this, OyinActivity1.class));
            }
        });

        rl_oyin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OiyndarActivity.this, OyinActivity2.class));
            }
        });

        rl_oyin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OiyndarActivity.this, OiynActivity3.class));
            }
        });
        rl_oyin4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OiyndarActivity.this, OyinActivity4.class));
            }
        });
    }
}