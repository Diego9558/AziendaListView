package it_diegoperego.aziendalistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Azienda azienda;
    private Button dipendenti;
    private Button progetto;
    private Intent dip;
    private Intent prog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        azienda = new Azienda();
        azienda.init();
        dipendenti = findViewById(R.id.bDip);
        progetto = findViewById(R.id.bProg);
        dip = new Intent(getApplicationContext(),DipendentiActivity.class);
        prog = new Intent(getApplicationContext(),ProgettiActivity.class);

        dipendenti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dip.putExtra("DIP", "dipendenti");
                dip.putExtra("Azienda", azienda);
                startActivity(dip);
            }
        });

        progetto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prog.putExtra("PROG", "progetti");
                prog.putExtra("Azienda", azienda);
                startActivity(prog);
            }
        });

    }

}
