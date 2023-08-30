package com.example.damproj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.damproj.databinding.ActivityIdadeBinding
import java.util.Calendar

class IdadeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIdadeBinding
    private val currentDateCalendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIdadeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.calculateButton.setOnClickListener {
            val birthday = binding.birthdayEditText.text.toString().toDoubleOrNull()
            val dateNow = currentDateCalendar.get(Calendar.YEAR).toString().toDoubleOrNull()

            val currentAge = dateNow!!.minus(birthday!!)
            binding.ageResultTextView.text = "${String.format("%.0f", currentAge)} anos"
        }
    }
}