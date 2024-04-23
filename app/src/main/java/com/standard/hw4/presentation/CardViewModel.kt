package com.standard.hw4.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.standard.hw4.data.Card
import com.standard.hw4.data.DataSource
import java.lang.IllegalArgumentException

class CardViewModel(val dataSource: DataSource): ViewModel() { //[question] 여기서 들어가는 DataSource가 무슨 값인지?
    val cardsLiveData = dataSource.getCardList() //[answer]아하! 이거 하려고 이렇게 썼구나.
    fun getCardForId(id: Long): Card {
        return cardsLiveData.get(id.toInt())
    }
}

//뷰모델 생성
class CardViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CardViewModel::class.java)) {
            return CardViewModel(dataSource = DataSource.getDataSource()) as T //뭔말이지
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
}
