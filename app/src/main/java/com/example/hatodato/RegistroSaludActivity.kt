package com.example.hatodato

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

// Para Kotlin
class RegistroSaludActivity : AppCompatActivity() {
    private lateinit var etFecha: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_salud)

        etFecha = findViewById(R.id.etFecha)

        // Configurar el selector de fecha
        etFecha.setOnClickListener { mostrarSelectorFecha() }
    }

    private fun mostrarSelectorFecha() {
        val calendario = Calendar.getInstance()
        val año = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)
        val dia = calendario.get(Calendar.DAY_OF_MONTH)

        val selectorFecha = DatePickerDialog(this,
            { _, añoSeleccionado, mesSeleccionado, diaSeleccionado ->
                val fechaSeleccionada = "$diaSeleccionado/${mesSeleccionado + 1}/$añoSeleccionado"
                etFecha.setText(fechaSeleccionada)
            }, año, mes, dia)

        selectorFecha.show()
    }
}
