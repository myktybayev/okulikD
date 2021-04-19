package kz.informatics.okulik.ui.oiyn;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import kz.informatics.okulik.R;

public class OyinFragment extends Fragment {
    RelativeLayout rl_oyin1, rl_oyin2, rl_oyin3, rl_oyin4;
    View root;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.activity_oiyndar, container, false);
        initViews();

        return root;
    }

    public void initViews(){

        Window window = getActivity().getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.white));

        rl_oyin1 = root.findViewById(R.id.rl_oyin1);
        rl_oyin2 = root.findViewById(R.id.rl_oyin2);
        rl_oyin3 = root.findViewById(R.id.rl_oyin3);
        rl_oyin4 = root.findViewById(R.id.rl_oyin4);
        rl_oyin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), OyinActivity1.class));
            }
        });

        rl_oyin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), OyinActivity2.class));
            }
        });

        rl_oyin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), OiynActivity3.class));
            }
        });
        rl_oyin4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), OyinActivity4.class));
            }
        });

    }
}