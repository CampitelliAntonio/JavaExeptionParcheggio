package main;

public class Parcheggio {
    private automobile parcheggio[];

    public Parcheggio(){
        parcheggio = new automobile[10];
    }

    public void aggiungiMacchina(automobile auto, int posizione) throws Exception{
        if(parcheggioPieno()){
            throw new ParcheggioPienoExeption("Il parcheggio è pieno");
        }
        parcheggio[posizione] = auto;
    }

    public long rimuoviMacchina(String targa){
        long secondi = 0;
        int i;
        for (i = 0; i < parcheggio.length; i++) {
            if (parcheggio[i] != null) {
                System.out.println("In posizione " + i + " veicolo " + parcheggio[i].getTarga() +
                        " al timestamp " + parcheggio[i].getEntrata().getTime());
                if (parcheggio[i].getTarga().equals(targa)) {
                    parcheggio[i].setUscita(System.currentTimeMillis());
                    secondi = (parcheggio[i].getUscita().getTime() - parcheggio[i].getEntrata().getTime()) / 1000;
                    break;
                }
            }
        }
        parcheggio[i] = null;
        return secondi;
    }

    private boolean parcheggioPieno(){
        for (int i = 0; i < parcheggio.length; i++) {
            if(parcheggio[i] == null){
                return false;
            }
        }
        return true;
    }
}