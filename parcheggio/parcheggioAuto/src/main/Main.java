package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Parcheggio par = new Parcheggio();
        int posizione = 0;
        String azione;
        boolean uscire = false;
        while (!uscire) {
            System.out.println("\nChe azione vuoi fare? (aggiungere, uscire)");
            azione = in.next().toLowerCase();
            switch (azione){
                case "aggiungere":
                    try {
                        System.out.println("Inserisci la targa");
                        par.aggiungiMacchina(new automobile(in.next(), System.currentTimeMillis()), posizione);
                        posizione ++;
                    } catch (Exception e) {
                        System.out.println("Errore: " + e.getMessage());
                    }
                    break;
                case "uscire":
                    try {
                        System.out.println("Scrivi la targa della macchina da far uscire");
                        long secondi = par.rimuoviMacchina(in.next());
                        System.out.println("Sono passati " + secondi + " secondi dall'entrata nel parcheggio di questa macchina");
                    } catch (Exception e) {
                        System.out.println("Errore: " + e.getMessage());
                    }
                    break;
                default:
                    uscire = true;
            }
        }
    }
}