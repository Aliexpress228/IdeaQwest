package com.company;

public class Situation {
    Situation[] dir;
    String subject,text;
    int dH,dR,dI;
    public Situation (String subject, String text, int variants, int dh,int dr,int di) {
        this.subject=subject;
        this.text=text;
        dH=dh;
        dR=dr;
        dI=di;
        dir=new Situation[variants];
    }
}