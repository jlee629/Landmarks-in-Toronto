package com.example.jungyulee_comp304sec001_lab3_ex01.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Landmark(
    val name: String,
    val address: String,
    val latitude: Double,
    val longitude: Double
) : Parcelable