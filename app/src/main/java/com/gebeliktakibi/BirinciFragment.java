package com.gebeliktakibi;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BirinciFragment extends Fragment {

    private int haftaSayisi;
    private TextView kacinciHafta;
    private TextView haftaAciklama;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String hafta  = "";
        if (haftaSayisi < 10) {
            hafta = "0" + haftaSayisi;
        }else {
            hafta = String.valueOf(haftaSayisi);
        }
        View rootView = inflater.inflate(R.layout.birinci_fragment, container, false);
        kacinciHafta = (TextView) rootView.findViewById(R.id.txtKacinciHafta);
        haftaAciklama = (TextView) rootView.findViewById(R.id.txtHaftaAciklama);
        kacinciHafta.setText(hafta  + ". Hafta");
        haftaAciklama.setText(getHaftaAciklama(hafta));
        return rootView;
    }

    public void setHaftaSayisi(int haftaSayisi) {


        this.haftaSayisi = haftaSayisi;
    }

    private String getHaftaAciklama(String hafta) {
        String key = hafta + "_Hafta";
        return null;
    }

}