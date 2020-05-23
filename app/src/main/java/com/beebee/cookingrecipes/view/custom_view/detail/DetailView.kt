package com.beebee.cookingrecipes.view.custom_view.detail

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.navigation.findNavController
import com.beebee.cookingrecipes.R
import com.beebee.cookingrecipes.model.food.Food
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detail.view.*

class DetailView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    fun initView(food: Food) {
        detail_food_title.text = food.title
        detail_food_description.text = food.description
        detail_food_like.text = food.like.toString()
        detail_food_time.text = food.time.toString()
        renderLikeHeart(food)

        Glide.with(this)
            .load(food.image)
            .into(detail_image)

        back_icon.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun renderLikeHeart(food: Food) {
        if (food.isLike) {
            setHeartLike()
        } else {
            setHeartLikeOutline()
        }
    }

    private fun setHeartLike() {
        detail_heart.setImageResource(R.drawable.ic_heart_fill_white)
        detail_like_icon.setImageResource(R.drawable.ic_heart_fill_brown)
    }

    private fun setHeartLikeOutline() {
        detail_heart.setImageResource(R.drawable.ic_heart)
        detail_like_icon.setImageResource(R.drawable.ic_love_icon)
    }
}