package com.example.rafalkie.projekt;

/**
 * Created by rafalkie on 12.06.2017.
 */

public class itm_P {
    private int id;
    private String pytanie;
    private String tresc;


    public itm_P(int id, String pytanie, String tresc) {
        this.id = id;
        this.pytanie = pytanie;
        this.tresc = tresc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPytanie() {
        return pytanie;
    }

    public void setPytanie(String pytanie) {
        this.pytanie = pytanie;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }
}
