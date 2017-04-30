package com.gebeliktakibi;

/**
 * Created by elifnur on 21.04.2017.
 */

public class NoteObjeckt {

    public String baslik;
    public String icerik;

    public NoteObjeckt(String baslik, String icerik) {
        this.baslik = baslik;
        this.icerik = icerik;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public NoteObjeckt(){

    }

    }
