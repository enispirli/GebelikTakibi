package com.gebeliktakibi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BebekHaftasi extends AppCompatActivity {
    private TextView tvBebekHafta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebek_haftasi);

        tvBebekHafta=(TextView)findViewById(R.id.tvBebekHafta);
        Intent intent=getIntent();
        String hafta=intent.getStringExtra("hafta");
        tvBebekHafta.setText("Bebeğiniz \n artık "+ hafta+" "+"haftalık :)");
    }
}
