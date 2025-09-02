package com.example.hatodato

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegistrarGanaderoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_ganadero)

        // Botón que abre la pantalla de Lotes de Ceba
        val btnLotesCeba: Button = findViewById(R.id.btnLotesCeba)
        btnLotesCeba.setOnClickListener {
            val intent = Intent(this, RegistroCebaLoteActivity::class.java)
            startActivity(intent)
        }

        // Botón que abre la pantalla de Registrar Ceba (ajusta a la Activity que corresponda)
        val btnRegistrarCeba: Button = findViewById(R.id.btnRegistrarCeba)
        btnRegistrarCeba.setOnClickListener {
            val intent = Intent(this, RegistroCebaActivity::class.java)
            startActivity(intent)
        }

        val btnSalida: Button = findViewById(R.id.btnSalidaCeba)
        btnSalida.setOnClickListener {
            val intent = Intent(this, SalidaLotesActivity::class.java)
            startActivity(intent)
        }

    }
}
