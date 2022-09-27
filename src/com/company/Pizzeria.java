package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Pizzeria{

    public static void main(String[] args){
        GregorianCalendar date = new GregorianCalendar();
        PrintWriter out = null;
        String file = "franchino.log";
        try{
            out = new PrintWriter(new FileOutputStream(file, true));
        }catch(FileNotFoundException e){
            System.out.println("il notaio ha scioperato e oggi non scrive il file di log");
        }
        out.println("\n\n" + "Apertura: " + date.getTime() + "\n");
        Scanner tastiera = new Scanner(System.in);

        int scelta = 0;
        while(scelta == 0){
            System.out.print("0. Entra famiglia\n1. Chiudi\nscelta: ");
            scelta = tastiera.nextInt();

            switch (scelta){
                case 0:
                    tastiera.nextLine();
                    System.out.print("Inserisci il cognome della famiglia: ");
                    String cognome = tastiera.nextLine();

                    System.out.print("Inserisci il numero di componenti della famiglia: ");
                    int nComponenti = tastiera.nextInt();
                    System.out.print("preparazione");
                    for (int i = 0; i<nComponenti; i++){
                        System.out.print(" . ");
                        try {
                            Thread.sleep(500);
                        }catch (InterruptedException e){
                            System.out.println("il pizzaiolo ha avuro un crauma tranico");
                        }
                    }
                    System.out.println("\n");
                    Famiglia f = new Famiglia(cognome, nComponenti);
                    break;
                case 1:
                    date = new GregorianCalendar();
                    System.out.println("La pizzeria da franchino chiude");
                    date = new GregorianCalendar();
                    out.println("\n" + "Chiusura: " + date.getTime());
                    out.close();
                    break;
            }
        }
    }
}
