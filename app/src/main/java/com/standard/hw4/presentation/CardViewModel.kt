package com.standard.hw4.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.standard.hw4.R
import com.standard.hw4.data.Card
import com.standard.hw4.data.CardRepository
import com.standard.hw4.data.DataSource
import com.standard.hw4.data.cardList
import java.lang.IllegalArgumentException

//https://velog.io/@dldmswo1209/Android-MVVM-Pattern-%EC%A0%81%EC%9A%A9-%EC%98%88%EC%A0%9C 잘안됨
//https://medium.com/@jecky999/mvvm-architecture-in-android-using-kotlin-a-practical-guide-73f8de1d9c58 시도중
class CardViewModel: ViewModel() {
    private var cardRepository = CardRepository()
    private val _cardData = MutableLiveData<Card>()
    val cardData: LiveData<Card> = _cardData //얘를 불러옴
    fun refreshCardData() {
        val card = cardRepository.getCardData()
        _cardData.value = card
    }

}

