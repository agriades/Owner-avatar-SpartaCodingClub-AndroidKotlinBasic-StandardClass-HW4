package com.standard.hw4.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Card(
    val iName: String?,
    val iCardNumber: String?,
    val iExpiryDate: String?,
    val iBalance: Double?,
    val iBackground: Int?
) : Parcelable
