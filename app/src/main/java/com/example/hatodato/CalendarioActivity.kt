package com.example.hatodato

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class CalendarioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario)

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

        // En actividad marketplace
        val bottomNavMarketplace: LinearLayout = findViewById(R.id.bottomNavMarketplace)
        bottomNavMarketplace.setOnClickListener {
            startActivity(Intent(this, MarketplaceViewActivity::class.java))
        }


    }

}