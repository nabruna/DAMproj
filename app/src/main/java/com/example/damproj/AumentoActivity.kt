package com.example.damproj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.damproj.databinding.ActivityAumentoBinding

class AumentoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAumentoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAumentoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.calculateButton.setOnClickListener {
            val wage = binding.wageEditText.text.toString().toDoubleOrNull()
            val raise = binding.raiseEditText.text.toString().toDoubleOrNull()

            val raiseAmount = wage!!.times(raise!!.div(100))
            val newWage = wage + raiseAmount
            binding.raiseResultTextView.text = "R\$ ${String.format("%.2f", newWage)}"
        }
    }
}