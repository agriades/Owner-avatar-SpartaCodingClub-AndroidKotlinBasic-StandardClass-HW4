package com.standard.hw4.data

import android.os.Parcelable
import com.standard.hw4.R
import kotlinx.android.parcel.Parcelize

//@Parcelize
data class Card(
    val iName: String?,
    val iCardNumber: String?,
    val iExpiryDate: String?,
    val iBalance: Double?,
    val iBackground: Int?
) //: Parcelable

class CardRepository {
    fun getCardData(): Card {
        // Fetch weather data from a remote server or local storage
        return Card(
            "DailyExpenses",
            "2423 3581 9503 2412",
            "07 / 24",
            3100.30,
            R.drawable.card_bg_deepblue
        )
    }
}
