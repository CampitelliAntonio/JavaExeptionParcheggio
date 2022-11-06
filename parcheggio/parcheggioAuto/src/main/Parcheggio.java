package main;

public class Parcheggio {
    private automobile parcheggio[];

    public Parcheggio(){
        parcheggio = new automobile[10];
    }

    public void aggiungiMacchina(automobile auto, int posizione) throws Exception{
        if(parcheggioPieno()){
            throw new ParcheggioPienoExeption("Il parcheggio è pieno");
        }else{
            if (macchinaEntrata(auto.getTarga())) {
                throw new MacchinaPresenteNelParcheggioException("La targa scritta è gia presente nel parcheggio");
            } else{
                parcheggio[posizione] = auto;
            }
        }
    }

    public long rimuoviMacchina(String targa) throws Exception {
        long secondi = 0;
        int i;
        if (parcheggioVuoto()) {
            throw new ParcheggioVuotoException("Il parcheggio è vuoto");
        }else{
            for (i = 0; i < parcheggio.length; i++) {
                if (parcheggio[i] != null) {
                    if (parcheggio[i].getTarga().equals(targa)) {
                        System.out.println("Il veicolo " + parcheggio[i].getTarga() + " al timestamp " + parcheggio[i].getEntrata().getTime());
                        parcheggio[i].setUscita(System.currentTimeMillis());
                        secondi = (parcheggio[i].getUscita().getTime() - parcheggio[i].getEntrata().getTime()) / 1000;
                        break;
                    } else {
                        throw new MacchinaMaiEntrataException("La macchina con questa targa non è mai entrata");
                    }
                }
            }
            parcheggio[i] = null;
        }
        return secondi;
    }

    private boolean parcheggioVuoto(){
        for (int i = 0; i < parcheggio.length; i++) {
            if(parcheggio[i] != null){
                return false;
            }
        }
        return true;
    }

    private boolean parcheggioPieno(){
        for (int i = 0; i < parcheggio.length; i++) {
            if(parcheggio[i] == null){
                return false;
            }
        }
        return true;
    }

    private boolean macchinaEntrata(String targa){
        for (int i = 0; i < parcheggio.length; i++) {
            if (parcheggio[i] != null && parcheggio[i].getTarga().equals(targa)){
                return true;
            }
        }
        return false;
    }

    public int macchineInParcheggio(){
        int macchine = 0;
        for (int i = 0; i < parcheggio.length; i++) {
            if(parcheggio[i] != null){
                macchine ++;
            }
        }
        return macchine;
    }
}