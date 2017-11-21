package it_diegoperego.aziendalistview;

import android.text.Editable;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by utente3.academy on 20-Nov-17.
 */

public class Azienda implements Serializable{
    private List<Dipendente> dipendenti;
    private List<Progetto> progetto;

    public Azienda() {
        this.dipendenti = new ArrayList<>();
        this.progetto = new ArrayList<>();
    }

    public Azienda(List<Dipendente> dipendenti, List<Progetto> progetto) {
        this.dipendenti = dipendenti;
        this.progetto = progetto;
    }

    public List<Dipendente> getDipendenti() {
        return dipendenti;
    }

    public void setDipendenti(List<Dipendente> dipendenti) {
        this.dipendenti = dipendenti;
    }

    public List<Progetto> getProgetto() {
        return progetto;
    }

    public void setProgetto(List<Progetto> progetto) {
        this.progetto = progetto;
    }

    public void  init(){

        dipendenti.add(new Dipendente(1, "Antonio", "Neri", "03281392"));
        dipendenti.add(new Dipendente(2, "Giuseppe", "Neri", "72389127"));
        dipendenti.add(new Dipendente(3, "Francesco", "Neri", "48971823"));
        dipendenti.add(new Dipendente(4, "Roberto", "Neri", "239876441"));
        dipendenti.add(new Dipendente(5, "Michele", "Neri", "738921377"));
        dipendenti.add(new Dipendente(6, "Giovanni", "Neri", "782491638"));
        dipendenti.add(new Dipendente(7, "Antonio", "Neri", "7894713435"));


        progetto.add(new Progetto(1,"Gioco"));
        progetto.add(new Progetto(2,"Gioco1"));
        progetto.add(new Progetto(3,"Gioco2"));
        progetto.add(new Progetto(4,"Gioco3"));
        progetto.add(new Progetto(5,"Gioco4"));
        progetto.add(new Progetto(6,"Gioco5"));
        progetto.add(new Progetto(7,"Gioco6"));

    }

    public String[] stampDip(){
        String [] stamp = new String[dipendenti.size()];
        for (int i =0; i<dipendenti.size(); i++){
            stamp [i] = dipendenti.get(i).getNome() + " " + dipendenti.get(i).getCognome();
        }
        return stamp;
    }

    public String[] stampaProg(){
        String [] stamp = new String[progetto.size()];
        for (int i =0; i<progetto.size(); i++){
            stamp[i] = progetto.get(i).getNomeProg();
        }
        return stamp;
    }

    public void removeDip(String id){
        dipendenti.remove(id);
    }

}
