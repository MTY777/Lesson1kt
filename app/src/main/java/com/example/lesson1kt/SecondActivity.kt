package com.example.lesson1kt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.set
import com.example.lesson1kt.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    companion object {
        private const val KEY_ONE: String = "one_key"
        private const val KEY_TWO: String = "two_key"
    }

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.etTwo.setText(intent.getStringExtra(KEY_ONE))
        binding.btnTwo.setOnClickListener {
            setResult(
                RESULT_OK, Intent().putExtra(KEY_TWO, binding.etTwo.text.toString())
            )
            finish()
        }
    }

}
