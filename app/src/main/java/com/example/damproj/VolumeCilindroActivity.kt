package com.example.damproj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.damproj.databinding.ActivityVolumeCilindroBinding
import kotlin.math.PI

class VolumeCilindroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVolumeCilindroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVolumeCilindroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.calculateButton.setOnClickListener {
            val height = binding.heightEditText.text.toString().toDoubleOrNull()
            val base = binding.baseEditText.text.toString().toDoubleOrNull()

            val cilinderVolume = (PI.times(squared(base!!))).times(height!!)
            binding.volumeResultTextView.text = "${String.format("%.2f", cilinderVolume)} l"
        }
    }
    private fun squared(number: Double): Double {
        return number * number
    }
}