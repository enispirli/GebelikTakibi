package com.gebeliktakibi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPager extends FragmentPagerAdapter {

    public TabsPager(FragmentManager fm) {

        super(fm);
    }

    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub
        switch (arg0) {
            case 0:
                // BirinciFragment fragment activity
                return new BirinciFragment();
            case 1:
                // IkinciFragment fragment activity
                return new IkinciFragment();
            case 2:
                // UcuncuFragment fragment activity
                return new UcuncuFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 3; //Tab sayısı
    }


}
