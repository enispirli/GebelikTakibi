package com.gebeliktakibi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NoteAdapter extends  ArrayAdapter<NoteObjeckt> {

    Context context;
    List<NoteObjeckt> notlar;
    int layoutResID;

    public NoteAdapter(Context context, int layoutResID, List<NoteObjeckt> notlar)
    {
        super(context, layoutResID, notlar);
        this.context = context;
        this.notlar = notlar;
        this.layoutResID=layoutResID;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);


        inflater = ((Activity) context).getLayoutInflater();

        view = inflater.inflate(layoutResID, parent, false);

        TextView konuAdi = (TextView)view.findViewById(R.id.konuTv);
        konuAdi.setText(notlar.get(position).getBaslik());

        return view;

    }
}