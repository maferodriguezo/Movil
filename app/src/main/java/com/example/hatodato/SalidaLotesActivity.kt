package com.example.hatodato

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SalidaLotesActivity : AppCompatActivity() {

    private val lotes = listOf("Lote 1", "Lote 2", "Lote 3", "Lote 4")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salida_lotes)

        val containerLotes: LinearLayout = findViewById(R.id.containerLotes)

        // Crear dinámicamente cada lote con su botón de salida
        for (lote in lotes) {
            val row = LinearLayout(this)
            row.orientation = LinearLayout.HORIZONTAL
            row.setPadding(0, 16, 0, 16)

            val textView = TextView(this)
            textView.text = lote
            textView.textSize = 18f
            textView.layoutParams = LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1f
            )

            val button = Button(this)
            button.text = "Salir"
            button.setOnClickListener {
                Toast.makeText(this, "$lote eliminado", Toast.LENGTH_SHORT).show()
            }

            row.addView(textView)
            row.addView(button)

            containerLotes.addView(row)
        }
    }
}
