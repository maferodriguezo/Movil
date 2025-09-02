package com.example.hatodato

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView // Importa ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class PerfilActivity : AppCompatActivity() {

    // Lanzador para solicitar el permiso de la cámara
    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                // Permiso concedido, abrir la cámara
                launchCamera()
            } else {
                // Permiso denegado, mostrar un mensaje al usuario
                Toast.makeText(this, "Permiso de cámara denegado", Toast.LENGTH_SHORT).show()
            }
        }

    // Lanzador para obtener el resultado de la cámara
    private val cameraResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val photoBitmap = data?.extras?.get("data") as? Bitmap
                if (photoBitmap != null) {
                    // Obtén el ImageView de tu layout
                    val imageButtonPerfil: ImageView = findViewById(R.id.imageButtonPerfil)
                    // Establece el bitmap de la foto en el ImageView
                    imageButtonPerfil.setImageBitmap(photoBitmap)
                    Toast.makeText(this, "Foto de perfil actualizada", Toast.LENGTH_SHORT).show()
                }
            }
        }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        // Encuentra el ImageView por su ID
        val imageButtonPerfil: ImageView = findViewById(R.id.imageButtonPerfil)

        // Asigna un OnClickListener para manejar el toque
        imageButtonPerfil.setOnClickListener {
            checkCameraPermissionAndLaunch()
        }

        val bottomNavPerfil: LinearLayout = findViewById(R.id.bottomNavPerfil)
        bottomNavPerfil.setOnClickListener {
            // El usuario ya está en la pantalla de perfil, no es necesario hacer nada.
            Toast.makeText(this, "Ya estás en la pantalla de Perfil", Toast.LENGTH_SHORT).show()
        }

        val navIA: LinearLayout = findViewById(R.id.nav_IA)
        navIA.setOnClickListener {
            startActivity(Intent(this, IAActivity::class.java))
        }
        val bottomNavGanadero: LinearLayout = findViewById(R.id.btnGanadero)
        bottomNavGanadero.setOnClickListener {
            val intent = Intent(this, RegistrarGanaderoActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }

    private fun checkCameraPermissionAndLaunch() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            // El permiso ya está concedido, abrir la cámara directamente
            launchCamera()
        } else {
            // El permiso no está concedido, solicitarlo
            requestPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }

    private fun launchCamera() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraResultLauncher.launch(takePictureIntent)
    }
}