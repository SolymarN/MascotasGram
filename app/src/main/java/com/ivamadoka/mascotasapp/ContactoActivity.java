package com.ivamadoka.mascotasapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContactoActivity extends AppCompatActivity {
    private Button enviar;
    private EditText nombre;
    private EditText correo;
    private EditText mensaje;
    private Toolbar miActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        miActionBar = findViewById(R.id.miActionBar);
        nombre = (EditText) findViewById(R.id.tietNombre);
        correo = (EditText) findViewById(R.id.tietCorreo);
        mensaje = (EditText) findViewById(R.id.tietMensaje);
        enviar = (Button) findViewById(R.id.btnEnviar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("onclick", "onClick: nombre  "+nombre.getText().toString());
                sendMail();
            }
        });

    }

    private void sendMail() {
        String mEmail = correo.getText().toString();
        String mMensaje = mensaje.getText().toString();
        String mNombre = nombre.getText().toString();

        JavaMailAPI javaMailAPI = new JavaMailAPI(this,mEmail,mNombre,mMensaje);
        javaMailAPI.execute();

    }
}