package com.example.hatodato

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Agregar el click listener al botón Ganadero
        val btnGanadero = findViewById<View>(R.id.btnGanadero)
        btnGanadero.setOnClickListener {
            val intent = Intent(this, RegistrarGanaderoActivity::class.java)
            startActivity(intent)
        }

        val btnVendedor: LinearLayout = findViewById(R.id.btnVendedor)
        btnVendedor.setOnClickListener {
            startActivity(Intent(this, MarketplaceActivity::class.java))
        }
    }
}