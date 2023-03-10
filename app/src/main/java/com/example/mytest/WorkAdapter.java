package com.example.mytest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class WorkAdapter extends ArrayAdapter {
    private Context context;

    private List<Work> works;

    public WorkAdapter(@NonNull Context context, @NonNull List works) {
        super(context, R.layout.nhanvien, works);
        this.context = context;
        this.works = works;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View view = LayoutInflater.from(context).inflate(R.layout.nhanvien, null, true);

        ImageView img = view.findViewById(R.id.imageView);
        TextView noidung = view.findViewById(R.id.textInfo);
//        Button delete = view.findViewById(R.id.btnDelete);
        Work w = (Work) works.get(position);
        img.setImageResource(w.getGioitinh().equalsIgnoreCase("Nam") ? R.drawable.male : R.drawable.female);
        noidung.setText(w.getTen() + "-" + w.getNoidung() + "-" + w.getNgayhoanthanh());

//        Delete
//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                works.remove(position);
//                notifyDataSetChanged();
//            }
//        });

        return view;
    }

}
