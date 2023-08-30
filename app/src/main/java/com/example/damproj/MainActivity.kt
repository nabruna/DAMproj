package com.example.damproj

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.damproj.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var screen: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            screen = AumentoActivity()
            navigate(screen)
        }

        binding.btn2.setOnClickListener {
            screen = VolumeCaixaActivity()
            navigate(screen)
        }

        binding.btn3.setOnClickListener {
            screen = IdadeActivity()
            navigate(screen)
        }

        binding.btn4.setOnClickListener {
            screen = ConsumoActivity()
            navigate(screen)
        }

        binding.btn5.setOnClickListener {
            screen = MediaActivity()
            navigate(screen)
        }

        binding.btn6.setOnClickListener {
            screen = TemperaturaActivity()
            navigate(screen)
        }

        binding.btn7.setOnClickListener {
            screen = VolumeCilindroActivity()
            navigate(screen)
        }
    }

    private fun navigate(screen : Activity) {
        val intent = Intent(this, screen::class.java)
        startActivity(intent)
        finish()
    }
}