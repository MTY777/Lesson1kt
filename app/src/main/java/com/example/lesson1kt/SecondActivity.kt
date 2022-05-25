package com.example.lesson1kt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.set
import com.example.lesson1kt.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
       binding.etTwo.setText(intent.getStringExtra("one_key"))
        binding.btnTwo.setOnClickListener{
            setResult(
                RESULT_OK, Intent().putExtra("two_key", binding.etTwo.text.toString())
            )
            finish()
        }
    }
}
