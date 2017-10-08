package com.example.jorgeyya.ejuno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    Button btnContinuar;
    EditText recogeEdad;
    EditText devuelveDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        TextView tx_saluda = (TextView)findViewById(R.id.tx_saluda);


        Intent i = getIntent();
        Bundle parametrosRecibidos = i.getExtras();
        if(parametrosRecibidos!=null){

            String nombre = parametrosRecibidos.getString("insert_nombre");
            tx_saluda.setText("Hola, "+nombre+", introduce tu edad:");
            recogeEdad = (EditText) findViewById(R.id.recoge_edad);
        }
        btnContinuar= (Button) findViewById(R.id.btn_continuar);

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int edad = Integer.parseInt(recogeEdad.getText().toString());
                Intent i = getIntent();
                //Bundle parametrosActivity = new Bundle();
                //parametrosActivity.putFloat("recoge_edad", Integer.parseInt(recogeEdad.getText().toString()));
                i.putExtra("recoge_edad", edad);
                setResult(MainActivity.RESULT_OK,i);
                finish();

            }

        });

    }
}
