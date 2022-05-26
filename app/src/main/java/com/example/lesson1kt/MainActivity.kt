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

    companion object{
        private const val KEY_ONE: String = "one_key"
        private const val KEY_TWO: String = "two_key"
    }

    private lateinit var binding: ActivityMainBinding

    val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            binding.et.setText(result.data?.getStringExtra(KEY_TWO))
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.btn.setOnClickListener {
            if (binding.et.text.toString().isEmpty()) {
                showToast(getString(R.string.empty))
            } else {
                Intent(this, SecondActivity::class.java).apply {
                    putExtra(KEY_ONE, binding.et.text.toString())
                    startForResult.launch(this)
                }

            }
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}


