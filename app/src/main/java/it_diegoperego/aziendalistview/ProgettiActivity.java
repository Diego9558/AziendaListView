package it_diegoperego.aziendalistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ProgettiActivity extends AppCompatActivity {


    private String prog;
    private ListView listProg;
    private Azienda azienda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progetti);

        prog = getIntent().getStringExtra("PROG");
        azienda = (Azienda) getIntent().getSerializableExtra("Azienda");

        setListProg();

    }

    public void setListProg(){

        String [] progetti = azienda.stampaProg();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,progetti);

        listProg = (ListView) findViewById(R.id.listProg);

        listProg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String str = listProg.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),""+str, Toast.LENGTH_SHORT).show();
            }
        });

        listProg.setAdapter(adapter);
    }
}
