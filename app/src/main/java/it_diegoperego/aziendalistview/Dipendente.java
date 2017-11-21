package it_diegoperego.aziendalistview;

import java.io.Serializable;

/**
 * Created by utente3.academy on 20-Nov-17.
 */

public class Dipendente implements Serializable{

    private static int id;
    private String nome;
    private String cognome;
    private String numTel;

    public Dipendente() {

        this.id = 8;
        this.nome = null;
        this.cognome = null;
        this.numTel = null;
    }

    public Dipendente(String nome, String cognome, String numTel) {
        this.nome = nome;
        this.cognome = cognome;
        this.numTel = numTel;
    }

    public Dipendente(int id, String nome, String cognome, String numTel) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.numTel = numTel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public static int getId() {
        return id++;
    }

    public void setId(int id) {
        this.id = id;
    }
}
