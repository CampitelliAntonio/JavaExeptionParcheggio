package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Parcheggio par = new Parcheggio();
        int posizione = 0;
        String azione;
        boolean uscire = false;
        int autoTot = 0;
        long permanenzaTot = 0;
        while (!uscire) {
            System.out.println("\nChe azione vuoi fare? (aggiungere macchina, togliere macchina, macchine nel parcheggio, media di permanenza)");
            azione = in.next().toLowerCase();
            switch (azione){
                case "aggiungere macchina":
                    try {
                        System.out.println("Inserisci la targa");
                        par.aggiungiMacchina(new automobile(in.next(), System.currentTimeMillis()), posizione);
                        posizione ++;
                        autoTot ++;
                    } catch (Exception e) {
                        System.out.println("Errore: " + e.getMessage());
                    }
                    break;
                case "tolgiere macchina":
                    try {
                        System.out.println("Scrivi la targa della macchina da far uscire");
                        long secondi = par.rimuoviMacchina(in.next());
                        System.out.println("Sono passati " + secondi + " secondi dall'entrata nel parcheggio di questa macchina");
                        permanenzaTot += secondi;
                    } catch (Exception e) {
                        System.out.println("Errore: " + e.getMessage());
                    }
                    break;
                case "macchine nel parcheggio":
                    System.out.println(par.macchineInParcheggio());
                    break;
                case "media di permanenza":
                    try {
                        System.out.println("La media di permanenza è di " + permanenzaTot / autoTot);
                    } catch (Exception e) {
                        System.out.println("Nessun auto è ancora entrata nel parcheggio");
                    }
                default:
                    uscire = true;
            }
        }
    }
}