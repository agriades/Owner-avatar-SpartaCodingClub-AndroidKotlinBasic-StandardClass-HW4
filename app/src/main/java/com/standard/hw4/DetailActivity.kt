package com.standard.hw4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.standard.hw4.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var initName = binding.name.text.toString()
        binding.name.text = initName + intent.getStringExtra("cardInfo")

    }
}