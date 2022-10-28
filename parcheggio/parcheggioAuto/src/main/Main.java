package main;

import java.util.Scanner;

//        long differenza = macchine[0].getUscita().getTime() - macchine[0].getEntrata().getTime();
//        System.out.println("La differenza di Timestamp tra l'entrata e l'uscita è " + differenza);
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        automobile[] macchine = new automobile[10];
        for (int i = 0; i < macchine.length; i++) {
            macchine[i] = new automobile();
        }
        String azione;
        long media = 0;
        int autoTot = 0;
        while (true) {
            System.out.println("Vuoi inserire un'altra macchina, farne uscire una o la media degli orari di permanenza (inserire, uscire, media)");
            azione = in.next();
            switch (azione) {
                case "inserire":
                    for (int i = 0; i < macchine.length; i++) {
                        if (macchine[i].getTarga().equals("")) {
                            System.out.println("Scrivi la targa della macchina");
                            macchine[i] = new automobile(in.next(), System.currentTimeMillis());
                            i = macchine.length;
                        } else if (i == macchine.length - 1) {
                            System.out.println("Il parcheggio è pieno");
                        }
                    }
                    break;
                case "uscire":
                    long differenza = 0;
                    System.out.println("Inserisci la targa della macchina che vuoi far uscire");
                    String targa = in.next();
                    for (int i = 0; i < macchine.length; i++) {
                        try {
                            if (macchine[i].getTarga().equals(targa)) {
                                macchine[i].setUscita(System.currentTimeMillis());
                                i = macchine.length;
                                differenza = (macchine[0].getUscita().getTime() - macchine[0].getEntrata().getTime()) / 1000;
                                System.out.println("La differenza di Timestamp tra l'entrata e l'uscita è " + differenza);
                            } else if (i == macchine.length - 1) {
                                System.out.println("Non esiste una macchina con questa targa: " + targa);
                            }
                        } catch (Exception e) {
                            System.out.println("Non esiste una macchina con questa targa: " + targa);
                            i = macchine.length;
                        }
                    }
                    media += differenza;
                    autoTot++;
                    break;
                case "media":
                    System.out.println("La media è " + media / autoTot);
            }
        }
    }
}