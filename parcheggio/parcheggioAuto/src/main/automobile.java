package main;
import java.sql.Timestamp;

public class automobile {
    private String targa;
    private Timestamp entrata;
    private Timestamp uscita;

    public automobile() {
        this.targa = "";
        this.entrata = null;
    }

    public automobile(String targa, long entrata) {
        this.targa = targa;
        this.entrata = new Timestamp(entrata);
        System.out.println("Il Timestamp di entrata della macchina " + this.targa + ": " + this.entrata.getTime());
    }

    public void setUscita(long uscita) {
        this.uscita = new Timestamp(uscita);
        System.out.println("Il Timestamp di uscita della macchina " + this.targa + ": " + this.uscita.getTime());
        this.targa = "";
    }

     public String getTarga(){
        return targa;
     }

    public Timestamp getEntrata() {
        return entrata;
    }

    public Timestamp getUscita() {
        return uscita;
    }
}
