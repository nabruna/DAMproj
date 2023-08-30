package com.example.damproj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.damproj.databinding.ActivityConsumoBinding

class ConsumoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConsumoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConsumoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.calculateButton.setOnClickListener {
            val distance = binding.distanceEditText.text.toString().toDoubleOrNull()
            val gas = binding.gasEditText.text.toString().toDoubleOrNull()

            val gasResult = distance!!.div(gas!!)
            binding.gasResultTextView.text = "${String.format("%.2f", gasResult)} km/l"
        }
    }
}