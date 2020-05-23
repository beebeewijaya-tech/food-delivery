package com.beebee.cookingrecipes.model.food

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Food(
    val image: String,
    val title: String,
    val description: String,
    var like: Int,
    val time: Int,
    var isLike: Boolean
): Parcelable