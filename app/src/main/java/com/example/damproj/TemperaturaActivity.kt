package com.example.damproj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.damproj.databinding.ActivityTemperaturaBinding
import java.util.Calendar

class TemperaturaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTemperaturaBinding
    private val currentDateCalendar = Calendar.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTemperaturaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.calculateButton.setOnClickListener {
            val celsius = binding.celsiusEditText.text.toString().toDoubleOrNull()

            val temperature = (celsius!!.times(9.div(5))) + 32
            binding.temperatureResultTextView.text = "${String.format("%.1f", temperature)} °F"
        }
    }
}