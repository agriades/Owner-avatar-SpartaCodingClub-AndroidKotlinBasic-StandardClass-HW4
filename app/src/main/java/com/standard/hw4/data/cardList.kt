package com.standard.hw4.data

import com.standard.hw4.R

fun cardList(): List<Card> {
    return listOf(
        Card("DailyExpenses", "2423 3581 9503 2412", "07 / 24", 3100.30, R.drawable.card_bg_deepblue),
        Card("Katie", "1234 5678 9101 1121", "12 / 28", 999.99, R.drawable.card_bg_deeporange),
        Card("Anderson", "7777 7777 7777 7777", "01 / 26", 1000.00, R.drawable.card_bg_lightblue)
    )
}

/* [question] 이미 적혀져 있는 코드를 바꿀 수는 없으니까 동적으로 처리해야 하므로... 이렇게 귀찮아 진다고 우선 받아들이고 있다.
원래는 그냥 object Cards {val cardA ... } 이런 식으로 구현해서, main에서 Card.cardA 이런 식으로 불러온 후 화면 전환 시 Intent로 넘겼다. */