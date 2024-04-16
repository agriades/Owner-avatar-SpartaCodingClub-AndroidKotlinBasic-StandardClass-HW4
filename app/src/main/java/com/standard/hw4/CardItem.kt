package com.standard.hw4

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardItem(
    val iName: String,
    val iCardNumber: String,
    val iExpiryDate: String,
    val iBalance: String,
    val iBackground: Int
) : Parcelable
