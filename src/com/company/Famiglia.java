package com.company;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

public class Famiglia implements Runnable{
    private String cognome;
    private int nComponenti;


    public Famiglia(String cognome, int nComponenti) {
        setCognome(cognome);
        setnComponenti(nComponenti);
        Thread t = new Thread(this, cognome);
        t.start();
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getnComponenti() {
        return nComponenti;
    }

    public void setnComponenti(int nComponenti) {
        this.nComponenti = nComponenti;
    }

    @Override
    public void run() {

        PrintWriter out = null;
        String file = "franchino.log";
        try{
            out = new PrintWriter(new FileOutputStream(file, true));
        }catch(FileNotFoundException e){
            System.out.println("errore");
            out.println("err");
        }

        GregorianCalendar date = new GregorianCalendar();
        out.println("entra " + cognome + "(" + date.getTime() + ")");
        try {
            for (int i = nComponenti; i > 0; i--) {
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread figlio interrotto");
            out.println("err");
        }
        date = new GregorianCalendar();
        out.println("esce " + cognome + "(" + date.getTime() + ")");
        System.out.println("esce la famiglia " + cognome);
        out.close();
    }
}
