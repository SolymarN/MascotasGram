package com.ivamadoka.mascotasapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ConfigCuentaActivity extends AppCompatActivity {

    private Button btnGuardar;
    private EditText edCuenta;
    private Toolbar miActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_cuenta);
        miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        edCuenta = (EditText) findViewById(R.id.tilCuenta);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        

    }
}