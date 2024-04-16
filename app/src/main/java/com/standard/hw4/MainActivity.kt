package com.standard.hw4

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.standard.hw4.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //카드 엮어주기
        val dataList = mutableListOf(Cards.cardA, Cards.cardB, Cards.cardC)
        val adapter = CardAdapter(dataList)
        binding.cardRecyclerView.adapter = adapter
        binding.cardRecyclerView.layoutManager = LinearLayoutManager(this)

        //각 카드 클릭 시 DetailActivity로 이동
        adapter.itemClick = object : CardAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intentDetailActivity = Intent(this@MainActivity, DetailActivity::class.java)

                val cardName =  dataList[position].iName
                val cardNumber =  dataList[position].iCardNumber
                val cardExpiryDate =  dataList[position].iExpiryDate
                val cardBalance = dataList[position].iBalance

                intentDetailActivity.putExtra("cardName", dataList[position].iName)
                intentDetailActivity.putExtra("cardNumber", dataList[position].iCardNumber)
                intentDetailActivity.putExtra("cardExpiryDate", dataList[position].iExpiryDate)
                intentDetailActivity.putExtra("cardBalance", dataList[position].iBalance)
                startActivity(intentDetailActivity)
            }
        }
    }



}