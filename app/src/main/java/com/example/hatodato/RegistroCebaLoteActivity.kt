package com.example.hatodato

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RegistroCebaLoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_lote_ceba)

        // Botón que ya tienes en activity_registro_lote_ceba.xml
        val btnRegistrarSalud: Button = findViewById(R.id.btnRegistrarSalud)
        btnRegistrarSalud.setOnClickListener {
            startActivity(Intent(this, RegistroSaludActivity::class.java))
        }

        val btnActualizarSalud: Button = findViewById(R.id.btnActualizarSalud)
        btnActualizarSalud.setOnClickListener {
            startActivity(Intent(this, ActualizarSaludActivity::class.java))
        }

        // Nuevo botón para historial de salud
        val btnHistorialSalud: Button = findViewById(R.id.btnHistorialSalud)
        btnHistorialSalud.setOnClickListener {
            startActivity(Intent(this, HistorialSaludActivity::class.java))
        }
    }
}