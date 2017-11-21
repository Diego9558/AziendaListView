package it_diegoperego.aziendalistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class DipendentiActivity extends AppCompatActivity {

    private String dip;
    private ListView listDip;
    private Azienda azienda;
    private Button bDelete;
    private Button bAdd;
    private EditText nome;
    private EditText cognome;
    private EditText numTel;
    private EditText idDip;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dipendenti);

        dip = getIntent().getStringExtra("DIP");
        azienda = (Azienda) getIntent().getSerializableExtra("Azienda");

        customAdapter = new CustomAdapter(getApplicationContext(),R.layout.dipendente,azienda.getDipendenti());
        listDip = (ListView) findViewById(R.id.listDip);

        listDip.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = listDip.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), ""+str,Toast.LENGTH_SHORT).show();
            }
        });

        listDip.setAdapter(customAdapter);
        idDip = findViewById(R.id.editId);
        bDelete = findViewById(R.id.bDelete);

        bDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(idDip.getVisibility()!= View.VISIBLE ){
                    idDip.setVisibility(View.VISIBLE);
                }else{
                    if(!idDip.getText().toString().equals("")){
                        customAdapter.removeDip(Integer.parseInt(idDip.getText().toString()));
                        Toast.makeText(getApplicationContext(),"Dipendente Licenziato!", Toast.LENGTH_SHORT).show();
                        customAdapter.notifyDataSetChanged();
                        idDip.setText("");
                        idDip.setVisibility(View.GONE);
                    }else{
                        idDip.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(),"Inserisci Id dipendente!", Toast.LENGTH_SHORT).show();
                    }
                }
                //customAdapter.removeDipByName("Antonio");
                //azienda.removeDip(2);

            }
        });

        bAdd = findViewById(R.id.bAdd);
        nome = findViewById(R.id.editName);
        cognome = findViewById(R.id.editCognome);
        numTel = findViewById(R.id.editPhone);

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nome.getVisibility()!= View.VISIBLE ){
                    nome.setVisibility(View.VISIBLE);
                    cognome.setVisibility(View.VISIBLE);
                    numTel.setVisibility(View.VISIBLE);
                }else{
                    if(!(nome.getText().toString().equals("")||cognome.getText().toString().equals("")||numTel.getText().toString().equals(""))){
                        customAdapter.addDip(nome.getText().toString(), cognome.getText().toString(), numTel.getText().toString());
                        Toast.makeText(getApplicationContext(),"Dipendente Aggiunto!", Toast.LENGTH_SHORT).show();
                        customAdapter.notifyDataSetChanged();
                        nome.setText("");
                        cognome.setText("");
                        numTel.setText("");
                    }else{
                        nome.setVisibility(View.GONE);
                        cognome.setVisibility(View.GONE);
                        numTel.setVisibility(View.GONE);
                        Toast.makeText(getApplicationContext(),"Inserisci tutti i campi!", Toast.LENGTH_SHORT).show();
                    }
                }
                //customAdapter.addDip("Antonio", "Perrone", "438294741");

            }
        });

        //setListDip();

    }

    /*public void setListDip(){

        String [] dipendenti = azienda.stampDip();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,dipendenti);

        listDip = (ListView) findViewById(R.id.listDip);

        listDip.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String str = listDip.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),""+str,Toast.LENGTH_SHORT).show();
            }
        });

        listDip.setAdapter(adapter);
    }*/

}
