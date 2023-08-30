package com.example.damproj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.damproj.databinding.ActivityMediaBinding

class MediaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMediaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMediaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.calculateButton.setOnClickListener {
            calculateAvg()
        }
    }

    private fun calculateAvg() {
        val n1 = binding.n1EditText.text.toString().toDoubleOrNull()
        val n2 = binding.n2EditText.text.toString().toDoubleOrNull()
        val n3 = binding.n3EditText.text.toString().toDoubleOrNull()
        val n4 = binding.n4EditText.text.toString().toDoubleOrNull()

        if (n1 == null
            || n2 == null
            || n3 == null
            || n4 == null) {
            showToast("Insira todas as notas.")
            return
        } else if (n1 < 0
            || n1 > 10
            || n1 < 0
            || n2 > 10
            || n2 < 0
            || n3 > 10
            || n4 < 0
            || n4 > 10) {
            showToast("Notas devem estar entre 0 e 10.")
            return
        } else {
            val average = (n1 + n2 + n3 + n4) / 4
            binding.avgResultTextView.text = "${String.format("%.2f", average)}"
        }
    }

    private fun showToast(message : String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}