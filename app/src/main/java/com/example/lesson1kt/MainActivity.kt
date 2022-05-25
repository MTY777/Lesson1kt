package com.example.lesson1kt

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.lesson1kt.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            binding.et.setText(result.data?.getStringExtra("two_key"))
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
init()
    }
    private fun init(){
        binding.et.setText(intent.getStringExtra("two_key"))
        binding.btn.setOnClickListener {
            if (binding.et.text.toString().isEmpty()) {
                showToast("Пусто")
            } else {
                Intent(this, SecondActivity::class.java).apply {
                    putExtra("one_key", binding.et.text.toString())
                    startForResult.launch(this)
                }

            }
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}


