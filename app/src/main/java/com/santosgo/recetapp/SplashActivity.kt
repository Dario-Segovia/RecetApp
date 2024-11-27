package com.santosgo.recetapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash) // Aquí pones el layout de tu splash

        // Usamos un Handler para retrasar la transición a MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
            // Iniciamos la MainActivity después de 2 segundos
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Terminamos la SplashActivity para que no se quede en el stack
        }, 2000) // 2000ms = 2 segundos
    }
}
