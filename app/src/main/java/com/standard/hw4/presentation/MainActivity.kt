package com.standard.hw4.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.standard.hw4.data.cardList
import com.standard.hw4.databinding.ActivityMainBinding
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    //숫자 표현 방식
    var format: DecimalFormat = DecimalFormat("#,##,##0.00")

    //0. 바인딩
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    //1. 뷰모델과 연결
//private val cardViewModel by viewModels<CardViewModel> { 뷰모델 생성 코드 }
    //2. 어댑터 연결. 어댑터가 뷰(메인 액티비티)가 아닌 뷰모델에서 정보를 가져와야?
    //[question] ViewModel이 data가 아닌 presentation으로 분류되는 이유가 뭔가요?


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //전체 잔고 decimal format
        var availableBalance: Double = 285856.20
        binding.midBalance.text = "$" + format.format(availableBalance)

        //카드 엮어주기
        val dataList = cardList()
        val adapter = CardAdapter(dataList)
        binding.cardRecyclerView.adapter = adapter
        binding.cardRecyclerView.layoutManager = LinearLayoutManager(this)

        //뒤로가기 버튼 누르면 바로 종료
        binding.backBtn.setOnClickListener {
            finish()
        }


        //각 카드 클릭 시 DetailActivity로 이동
        adapter.itemClick = object : CardAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intentDetailActivity = Intent(this@MainActivity, DetailActivity::class.java)

                //Parcelize와 Bundle 사용하는 법을 모르겠다 흑흑.
                val cardName =  dataList[position].iName
                val cardNumber =  dataList[position].iCardNumber
                val cardExpiryDate =  dataList[position].iExpiryDate
                val cardBalance = dataList[position].iBalance

                intentDetailActivity.putExtra("cardName", dataList[position].iName)
                intentDetailActivity.putExtra("cardNumber", dataList[position].iCardNumber)
                intentDetailActivity.putExtra("cardExpiryDate", dataList[position].iExpiryDate)
                intentDetailActivity.putExtra("cardBalance", format.format(dataList[position].iBalance))
                //decimal format
                startActivity(intentDetailActivity)
            }
        }
    }



}