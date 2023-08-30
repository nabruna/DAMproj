package com.example.damproj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.damproj.databinding.ActivityAumentoBinding
import com.example.damproj.databinding.ActivityVolumeCaixaBinding

class VolumeCaixaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVolumeCaixaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVolumeCaixaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.calculateButton.setOnClickListener {
            val height = binding.heightEditText.text.toString().toDoubleOrNull()
            val width = binding.widthEditText.text.toString().toDoubleOrNull()
            val depth = binding.depthEditText.text.toString().toDoubleOrNull()

            val boxVolume = height!!.times(width!!.times(depth!!))
            binding.volumeResultTextView.text = "${String.format("%.2f", boxVolume)} m³"
        }
    }
}