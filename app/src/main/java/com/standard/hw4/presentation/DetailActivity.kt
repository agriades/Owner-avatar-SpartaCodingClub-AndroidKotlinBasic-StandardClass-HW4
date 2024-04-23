package com.standard.hw4.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.standard.hw4.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.name.text = "이름: " + intent.getStringExtra("cardName")
        binding.cardNumber.text = "카드 번호: " + intent.getStringExtra("cardNumber")
        binding.expiryDate.text = "유효기간: " + intent.getStringExtra("cardExpiryDate")
        binding.balance.text = "잔고: " + intent.getStringExtra("cardBalance")

    }
}