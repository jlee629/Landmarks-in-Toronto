package com.example.jungyulee_comp304sec001_lab3_ex01.utils

import android.content.Context
import com.example.jungyulee_comp304sec001_lab3_ex01.model.LandmarkType
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun loadLandmarksFromAssets(context: Context): List<LandmarkType> {
    val jsonString = context.assets.open("landmarks.json").bufferedReader().use { it.readText() }
    val type = object : TypeToken<List<LandmarkType>>() {}.type
    return Gson().fromJson(jsonString, type)
}