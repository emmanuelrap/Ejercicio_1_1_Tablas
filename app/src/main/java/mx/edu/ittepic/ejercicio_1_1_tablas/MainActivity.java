package mx.edu.ittepic.ejercicio_1_1_tablas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    TextView avance;
    Button boton;

    int seleccion,res;

    String concatenar,total;
    ListView lista;
    String [] arreglo = new String[21];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);

        boton = findViewById(R.id.button);

        avance = findViewById(R.id.textView);

        lista = findViewById(R.id.listView);

        seleccion=0;
        concatenar="";
        total="";

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arreglo);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                total="";
                concatenar="";
                avance.setText(""+progress);
                seleccion = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i=0;i<=20;i++){
                    res=seleccion*i;
                    arreglo[i]=""+seleccion+"X"+i+"="+res;
                }
                lista.setAdapter(adapter);

            }
        });



    }
}


