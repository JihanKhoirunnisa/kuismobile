package com.example.kuismobile;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.kuismobile.R;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Mahasiswa> movieItems;

    public CustomListAdapter(Activity activity, List<Mahasiswa> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return  movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView jurusan = (TextView) convertView.findViewById(R.id.text_jurusan);
        TextView angkatan = (TextView) convertView.findViewById(R.id.text_ANGKATAN);
        Mahasiswa m = movieItems.get(position);
        nama.setText("Nama : "+ m.get_nama());
        jurusan.setText("jurusan : "+ m.get_jurusan());
        angkatan.setText("angkatan : "+ m.get_angkatan());
        return convertView;
    }
}