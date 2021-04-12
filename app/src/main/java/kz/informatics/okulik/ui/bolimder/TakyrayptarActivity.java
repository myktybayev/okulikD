package kz.informatics.okulik.ui.bolimder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import kz.informatics.okulik.R;

public class TakyrayptarActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager linearLayoutManager;
    String tList1[]= {"§1. Айнымалылар", "§ 2. Кейіпкердің костюмін өзгерту", "§ 3. Кейіпкердің костюмін өзгерту. Жоба құру", "§ 4. Өз ойынының сценарийі", "§ 5. Логикалық операторлар", "§ 6. Салыстыру операторлары", "§ 7. Өз ойыным", "§ 8. Өз ойыным. Жоба құру"};
    String tList2[]= {"§ 9. Түс датчигі", "§ 10. Бағдаршам-робот", "§ 11. Ультрадыбыс датчигі", "§ 12. Ультрадыбыс датчигі. Жоба құру", "§ 13. Лабиринттен шығу", "§ 14. Кегельринг", "§ 15. Кегельринг. Жоба құру"};
    String tList3[]= {"§ 16. Видеожазба", "§ 17. VideoPad редакторының мүмкіндіктері", "§ 18. Видеоны өңдеу", "§ 19. Видеоны өңдеу. Жоба құру"};
    String tList4[]= {"§ 20. Презентацияларға арналған ақпарат", "§ 21. Презентацияға арналған ақпарат. Жоба құру", "§ 22. Презентация слайдының макеті", "§ 23. Презентациядағы дыбыстар", "§ 24. Презентациядағы видео", "§ 25. Презентациядағы видео. Жоба құру", "§ 26. Презентациядағы анимация"};
    String tList5[]= {"§ 27. Интернетке деректер жіберу", "§ 28. Электронды поштамен файлдарды қабылдау және жіберу", "§ 29. Пароль сенімділігі", "§ 30. Интернетке деректер жіберу. Жоба құру", "§ 31. Пароль сенімділігі. Жоба құру", "§ 32. Болашақтағы компьютерлер"};

    TakyrypListAdapter takyrypListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takyrayptar);

        Intent intent = getIntent();
        String bolimNum = intent.getStringExtra("bolim");
        setTitle("Бөлім "+bolimNum+" тақырыптары");

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView =  findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        if(bolimNum.equals("1")){
            takyrypListAdapter = new TakyrypListAdapter(this, tList1);

        }else if(bolimNum.equals("2")){
            takyrypListAdapter = new TakyrypListAdapter(this, tList2);

        }else if(bolimNum.equals("3")){
            takyrypListAdapter = new TakyrypListAdapter(this, tList3);

        }else if(bolimNum.equals("4")){
            takyrypListAdapter = new TakyrypListAdapter(this, tList4);

        }else if(bolimNum.equals("5")){
            takyrypListAdapter = new TakyrypListAdapter(this, tList5);
        }


        recyclerView.setAdapter(takyrypListAdapter);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, final int pos) {

                        Intent intent = new Intent(TakyrayptarActivity.this, OiyndarActivity.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onLongItemClick(View view, int pos) {

                    }
                })
        );

    }
}