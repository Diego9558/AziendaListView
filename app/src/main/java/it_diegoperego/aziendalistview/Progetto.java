package it_diegoperego.aziendalistview;

import java.io.Serializable;

/**
 * Created by utente3.academy on 20-Nov-17.
 */

public class Progetto implements Serializable{
    private int idProg;
    private String nomeProg;

    public Progetto() {
        this.idProg = 0;
        this.nomeProg = null;
    }

    public Progetto(int idProg, String nomeProg) {
        this.idProg = idProg;
        this.nomeProg = nomeProg;
    }

    public int getIdProg() {
        return idProg;
    }

    public void setIdProg(int idProg) {
        this.idProg = idProg;
    }

    public String getNomeProg() {
        return nomeProg;
    }

    public void setNomeProg(String nomeProg) {
        this.nomeProg = nomeProg;
    }
}
