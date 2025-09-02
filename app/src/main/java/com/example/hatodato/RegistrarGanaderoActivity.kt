package com.example.hatodato

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

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


        val navIA: LinearLayout = findViewById(R.id.nav_IA)
        navIA.setOnClickListener {
            startActivity(Intent(this, IAActivity::class.java))
        }

        val bottomNavPerfil: LinearLayout = findViewById(R.id.bottomNavPerfil)
        bottomNavPerfil.setOnClickListener {
            val intent = Intent(this, PerfilActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            }
            startActivity(intent)
        }

        // En actividad calendario
        val bottomNavCalendar: LinearLayout = findViewById(R.id.bottomNavCalendar)
        bottomNavCalendar.setOnClickListener {
            startActivity(Intent(this, CalendarioActivity::class.java))
        }

        // En actividad marketplace
        val bottomNavMarketplace: LinearLayout = findViewById(R.id.bottomNavMarketplace)
        bottomNavMarketplace.setOnClickListener {
            startActivity(Intent(this, MarketplaceViewActivity::class.java))
        }


    }
}
