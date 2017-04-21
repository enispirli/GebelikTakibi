package com.gebeliktakibi;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Smsung on 20.4.2017.
 */

public class BirinciEkran extends AppCompatActivity {
    TextView textViewGelenKelimeler, textViewAnlami;
    Button buttonOnceki, buttonSonraki;

    ArrayList<datastructure> dataList = new ArrayList<>();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.birinci_ekran);

        Fragment fragment = new Fragment();
        new Handler().postDelayed(new Runnable() {//program çalıştığı anda çalışır
            @Override
            public void run() {
                getAllKeyValue();
            }
        }, 0);


        textViewGelenKelimeler = (TextView) findViewById(R.id.textViewGelenKelimeler);
        textViewAnlami = (TextView) findViewById(R.id.textViewAnlami);
        buttonOnceki = (Button) findViewById(R.id.buttonOnceki);
        buttonSonraki = (Button) findViewById(R.id.buttonSonraki);
        buttonSonraki.setEnabled(false);
        buttonOnceki.setEnabled(false);
    }

    public void getAllKeyValue() {
        /*
        proje başladığında veritabanından nesneleri çekmek için kullanılan yapı
        */
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("gebelikBilgileri");
        dbRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                        datastructure data = new datastructure();
                        data.key = dsp.getKey();
                        data.value = dsp.getValue().toString();
                        dataList.add(data);
                        // dataList.ensureCapacity(dataList.size());
                    }
                    Convert x = new Convert();
                    buttonOnceki.setEnabled(true);
                    buttonSonraki.setEnabled(true);
                    textViewGelenKelimeler.setText(x.dbToString(dataList.get(0).key));
                    textViewAnlami.setText(dataList.get(0).value);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            }
        );

        buttonOnceki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oncekikelime();
            }
        });

        buttonSonraki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonrakikelime();
            }
        });


    }

    int index = 0;

    public void sonrakikelime() {
        Convert x=new Convert();
        index++;
        textViewGelenKelimeler.setText(x.dbToString(dataList.get(index).key));
        textViewAnlami.setText(dataList.get(index).value);

    }

    public void oncekikelime() {
        Convert x=new Convert();
        --index;
        textViewGelenKelimeler.setText(x.dbToString(dataList.get(index).key));
        textViewAnlami.setText(dataList.get(index).value);

    }

   /* @Override
    public void onClick(View v) {
        if (v == buttonOnceki) {
            oncekikelime();
        }
        if (v == buttonSonraki) {
            sonrakikelime();
        }

    } */
}
