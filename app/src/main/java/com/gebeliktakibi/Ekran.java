package com.gebeliktakibi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Ekran extends AppCompatActivity {

    private Button haftaHaftaGebelik;
    private Button bebegimeNot;
    private Button takvim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ekran);

        haftaHaftaGebelik=(Button)findViewById(R.id.haftaHaaftaGebelik);
        bebegimeNot=(Button)findViewById(R.id.bebegimeNotlar);
        takvim=(Button)findViewById(R.id.takvim);

        haftaHaftaGebelik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),BirinciEkran.class);
                startActivity(intent);
            }
        });


    }

}
