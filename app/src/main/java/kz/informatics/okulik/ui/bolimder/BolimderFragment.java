package kz.informatics.okulik.ui.bolimder;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import kz.informatics.okulik.R;

public class BolimderFragment extends Fragment implements View.OnClickListener {

    View root;
    CardView bolim1, bolim2, bolim3, bolim4, bolim5;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_home, container, false);
//        getActivity().setTitle("Бөлімдер");
        bolim1 = root.findViewById(R.id.bolim1);
        bolim2 = root.findViewById(R.id.bolim2);
        bolim3 = root.findViewById(R.id.bolim3);
        bolim4 = root.findViewById(R.id.bolim4);
        bolim5 = root.findViewById(R.id.bolim5);

        bolim1.setOnClickListener(this);
        bolim2.setOnClickListener(this);
        bolim3.setOnClickListener(this);
        bolim4.setOnClickListener(this);
        bolim5.setOnClickListener(this);


        Window window = getActivity().getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.red));

        return root;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), TakyrayptarActivity.class);

        switch (view.getId()){
            case R.id.bolim1:
                intent.putExtra("bolim", "1");
            break;
            case R.id.bolim2:
                intent.putExtra("bolim", "2");
            break;
            case R.id.bolim3:
                intent.putExtra("bolim", "3");
            break;
            case R.id.bolim4:
                intent.putExtra("bolim", "4");
            break;
            case R.id.bolim5:
                intent.putExtra("bolim", "5");
            break;

        }
        startActivity(intent);
    }
}