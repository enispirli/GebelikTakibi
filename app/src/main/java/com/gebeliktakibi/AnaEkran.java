package com.gebeliktakibi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.Toast;

public class AnaEkran extends AppCompatActivity implements ActionBar.TabListener {

    // action bar
    private android.support.v7.app.ActionBar actionBar;
    private Menu optionsMenu;
    private ViewPager viewPager;
    private TabsPager adapter;
    private TabLayout tabLayout;
  //  private Toolbar toolbar;
    private int haftaSayisi;
    // Tab başlıkları
    private String[] tabs = {"Birinci", "İkinci", "Üçüncü"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_ekran);

      //  toolbar = (Toolbar) findViewById(R.id.toolBar);

        Intent intent = getIntent();
        int gunSayisi = intent.getIntExtra("gun", 0);
        int haftaSayisi = (gunSayisi / 7) + 1;
        Toast.makeText(getApplicationContext(), "Gun Sayisi:" + gunSayisi, Toast.LENGTH_SHORT).show();
        getSupportActionBar().hide();
        //ACTİON BAR İŞLEMLERİ
        //actionBar = getSupportActionBar();

        // Action Bar Başlığı saklar
        //actionBar.setDisplayShowTitleEnabled(false);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);


        //TAB ve SWIPE İŞLEMLERİ

        viewPager = (ViewPager) findViewById(R.id.pager); //xml de tanımladığımız pager alıyoruz
        adapter = new TabsPager(getSupportFragmentManager(), haftaSayisi);//TabsPager objesi oluşturuyoruz

        viewPager.setAdapter(adapter); //pager ımızı oluşturduğumuz objeye bağlıyoruz.
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Birinci");
        tabLayout.getTabAt(1).setText("İkinci");
        tabLayout.getTabAt(2).setText("Ücüncü");
        /*actionBar.setNavigationMode(android.support.v7.app.ActionBar.NAVIGATION_MODE_TABS);//ActionBarı tablı kullanmak için


        for (int i = 0; i < tabs.length; i++) { //Tabları ekliyorum
            actionBar.addTab(actionBar.newTab().setText(tabs[i]).setTabListener(this)); //Action Barlara tabları ekledik
        }*/


        /*viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { //tablar arasındaki geçişleri dinleyen listener

            @Override
            public void onPageSelected(int position) {
                // sayfa değiştiğinde çalışır
                actionBar.setSelectedNavigationItem(position);

                //actionBar.setSelectedNavigationItem(2);//son tab ı seçili hale getirir.
                //1. tab 0 index i ile seçilir
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });*/


    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        // Toast.makeText(getApplicationContext(), "" + tab.getPosition() + ".Tab seçildi", Toast.LENGTH_LONG).show();
        viewPager.setCurrentItem(tab.getPosition(), true);

        //tab.getPosition()  //Hangi tabın seçildiğini anlamak için mesala 1. tab seçildiyse 0 değeri döner 2. tabda 1 ,3.tabda 2 değeri döner
        //tab.setText("deneme"); //seçilen tabın string değerini-adını değiştirmeye yarar
        //tab.setIcon(R.drawable.xx)  tab da icon kullanmak için

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
