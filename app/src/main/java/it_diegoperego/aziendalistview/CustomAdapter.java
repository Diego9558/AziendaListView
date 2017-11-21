package it_diegoperego.aziendalistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by utente3.academy on 20-Nov-17.
 */

public class CustomAdapter extends ArrayAdapter<Dipendente> {

    private int resource;
    private LayoutInflater inflater;
    private List<Dipendente> dipendenti;

    public CustomAdapter(Context context, int resourceId, List<Dipendente> objects) {
        super(context, resourceId, objects);
        this.resource = resourceId;
        this.dipendenti = objects;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        if(v==null){
            Log.d("Debug","Inflating view");
            v = inflater.inflate(R.layout.dipendente, null);
        }

        Dipendente dipendente = getItem(position);

        Log.d("Debug", "dipendente dip ="+ dipendente);

        TextView nome;
        TextView cognome;
        TextView numTel;

        nome = (TextView) v.findViewById(R.id.textNome);
        cognome = v.findViewById(R.id.textCognome);
        numTel = v.findViewById(R.id.textNumTel);

        nome.setText(dipendente.getNome());
        cognome.setText(dipendente.getCognome());
        numTel.setText(dipendente.getNumTel());

        return v;

    }

    public void removeDipByName(String nome){
        for (int i=0; i<dipendenti.size(); i++){
            if(dipendenti.get(i).getNome().equals(nome)){
                dipendenti.remove(i);
            }
        }
    }

    public void addDip(String nome, String cognome, String numTel){
        Dipendente dip = new Dipendente(nome, cognome, numTel);
        dipendenti.add(dip);
    }


    public void removeDip(int num){
        dipendenti.remove(num);
    }
}
