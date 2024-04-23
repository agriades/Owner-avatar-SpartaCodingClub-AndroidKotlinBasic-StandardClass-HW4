package com.standard.hw4.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.standard.hw4.data.DataSource

class CardViewModel(val dataSource: DataSource): ViewModel() { //[question] 여기서 들어가는 DataSource가 무슨 값인지?
    val cardsLiveData = dataSource.getCardList() //[answer]아하! 이거 하려고 이렇게 썼구나.
}
