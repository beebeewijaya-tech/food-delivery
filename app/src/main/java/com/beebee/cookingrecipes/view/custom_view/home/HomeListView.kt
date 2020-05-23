package com.beebee.cookingrecipes.view.custom_view.home

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.beebee.cookingrecipes.model.food.Food
import com.beebee.cookingrecipes.view.ui.home.HomeAdapter
import com.beebee.cookingrecipes.view.ui.home.HomeTaskInterface
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private lateinit var adapter: HomeAdapter
    private lateinit var daDelegate: HomeTaskInterface

    fun initView(daDelegate: HomeTaskInterface) {
        this.daDelegate = daDelegate
        renderList()
    }

    fun renderList() {
        food_container.layoutManager = LinearLayoutManager(context)
        adapter = HomeAdapter(daDelegate = this.daDelegate)
        food_container.adapter = adapter
    }

    fun updateList(food: List<Food>) {
        adapter.updateList(food)
    }
}