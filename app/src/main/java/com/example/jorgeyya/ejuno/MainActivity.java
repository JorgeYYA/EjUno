package com.example.jorgeyya.ejuno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.jorgeyya.ejuno.R.id.btn_enviar_datos;

public class MainActivity extends AppCompatActivity {
    EditText nombre;
    Button btnEnviar;
    RadioGroup radio;
    int result = 0;
    TextView devuelveDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        devuelveDatos = (TextView)findViewById(R.id.devuelve_datos);

        nombre = (EditText) findViewById(R.id.insert_nombre);
        btnEnviar= (Button) findViewById(R.id.btn_enviar_datos);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                Bundle parametrosActivity2 = new Bundle();
                parametrosActivity2.putCharSequence("insert_nombre", nombre.getText().toString());
                //parametrosActivity2.putInt("radioGroup", radio.getCheckedRadioButtonId());
                i.putExtras(parametrosActivity2);
                startActivityForResult(i,result);


            }



        });



    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        int edad = data.getIntExtra("recoge_edad",0);
        Toast.makeText(this, "Toast", Toast.LENGTH_SHORT).show();
        if (edad>=18 || edad<25){
            devuelveDatos.setText("tu edad está entre 18 y 25");
        };


        if(edad>=25 || edad<35){
            devuelveDatos.setText("tu edad está entre 25 y 35");
        };

        if(edad>=35){
            devuelveDatos.setText("tienes 35 años o más");
        };
        Log.d("edad",""+edad);
        //devuelveDatos.setText(""+edad);
        }

    }

