package com.gebeliktakibi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NoteIcerikActivity extends AppCompatActivity {

    private TextView tvIcerik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_icerik);
        tvIcerik=(TextView)findViewById(R.id.tvIcerik);
        Intent intent=getIntent();
        String message=intent.getStringExtra("içerik");
        tvIcerik.setText(message);
    }
}
