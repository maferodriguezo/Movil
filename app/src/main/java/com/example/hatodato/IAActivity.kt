package com.example.hatodato

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class IAActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ia_alimentacion)

        val bottomNavHome: LinearLayout = findViewById(R.id.bottomNavHome)
        bottomNavHome.setOnClickListener {
            startActivity(Intent(this, RegistrarGanaderoActivity::class.java))
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

    }
}