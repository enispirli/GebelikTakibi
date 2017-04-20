package com.gebeliktakibi;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Calendar;

public class GebelikTarihi extends AppCompatActivity {


    private DatePicker dpResult;
    private Button btnTarih;

    private int year;
    private int month;
    private int day;


    static final int DATE_DIALOG_ID = 999;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gebelik_tarihi);

        dpResult = (DatePicker) findViewById(R.id.dpResult);
        setCurrentDateOnView();

        dpResult.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Toast.makeText(GebelikTarihi.this, year + " " + monthOfYear + " " + dayOfMonth, Toast.LENGTH_SHORT).show();

            }
        });

        btnTarih = (Button) findViewById(R.id.btnTarih);


        btnTarih.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(dpResult.getYear(), dpResult.getMonth(), dpResult.getDayOfMonth());
                int gunSayisi= calculate(calendar);


                if(gunSayisi>280){
                    Toast.makeText(GebelikTarihi.this,"40 haftadan fazla gebelik olamaz",Toast.LENGTH_SHORT).show();
                }

                if(gunSayisi<0){
                    Toast.makeText(GebelikTarihi.this,"Geçerli bir tarih giriniz",Toast.LENGTH_SHORT).show();
                }

                Intent intent=new Intent(GebelikTarihi.this,TabsPager.class);
                intent.putExtra("gun",gunSayisi);
                startActivity(intent);
            }

        });

    }



    public Calendar setCurrentDateOnView() {
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        return  c;
    }


    public int calculate(Calendar selected_calendar)



    {

        Calendar today = Calendar.getInstance();

        long diff = today.getTimeInMillis() - selected_calendar.getTimeInMillis();
        long days = diff / (24 * 60 * 60 * 1000);

        return (int)days;


    }


}

