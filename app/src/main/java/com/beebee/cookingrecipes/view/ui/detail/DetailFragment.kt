package com.beebee.cookingrecipes.view.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs

import com.beebee.cookingrecipes.R
import com.beebee.cookingrecipes.model.food.Food
import com.beebee.cookingrecipes.view.custom_view.detail.DetailView
import com.beebee.cookingrecipes.viewmodel.home.HomeViewModel

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {
    val args: DetailFragmentArgs by navArgs()

    private lateinit var contentView: DetailView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false).apply {
            contentView = this as DetailView
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val food = args.food
        renderContent(food)
    }

    private fun renderContent(food: Food) {
        contentView.initView(food)
    }
}
