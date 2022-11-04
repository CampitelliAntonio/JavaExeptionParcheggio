package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner in = new Scanner(System.in);

        Parcheggio par = new Parcheggio();

        try {
            System.out.println("inserire targa");
            par.aggiungiMacchina(new automobile(in.next(),
                    System.currentTimeMillis()), 0);

            System.out.println("inserire targa");
            par.aggiungiMacchina(new automobile(in.next(),
                    System.currentTimeMillis()), 1);

            System.out.println("inserire targa");
            par.aggiungiMacchina(new automobile(in.next(),
                    System.currentTimeMillis()), 2);
        } catch (Exception e) {
            System.out.println("Errore " + e.getMessage());
        }

        System.out.println("che macchina vuoi far uscire");
        long secondi = par.rimuoviMacchina(in.next());
        System.out.println("sono passati " + secondi);
    }
}