package kz.informatics.okulik.ui.bolimder;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kz.informatics.okulik.R;

public class TakyrypListAdapter extends RecyclerView.Adapter<TakyrypListAdapter.MyTViewHolder> {

    private Context context;
    private String[] groupList;

    public class MyTViewHolder extends RecyclerView.ViewHolder{
        public TextView info;

        public MyTViewHolder(View view) {
            super(view);
            info = view.findViewById(R.id.info);

        }
    }

    public TakyrypListAdapter(Context context, String[] groupList) {
        this.context = context;
        this.groupList = groupList;
    }

    @Override
    public MyTViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_takyryp, parent, false);

        return new MyTViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyTViewHolder holder, int position) {
        String item = groupList[position];
        holder.info.setText(item);
    }

    @Override
    public int getItemCount() {
        return groupList.length;
    }

}