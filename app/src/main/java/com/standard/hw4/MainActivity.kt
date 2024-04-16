package com.standard.hw4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.standard.hw4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(binding.root)

        binding.test.setOnClickListener{
            binding.test.text = "hello"
        }

    }

}