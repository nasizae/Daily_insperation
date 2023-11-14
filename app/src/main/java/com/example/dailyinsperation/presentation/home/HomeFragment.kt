package com.example.dailyinsperation.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dailyinsperation.R
import com.example.dailyinsperation.core.base.BaseFragment
import com.example.dailyinsperation.databinding.FragmentHomeBinding
import com.example.dailyinsperation.presentation.home.adapter.CategoryAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding,HomeViewModel>(R.layout.fragment_home) {
    override val viewModel: HomeViewModel
        get() = HomeViewModel()

    private var categoryAdapter = CategoryAdapter()

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun initView() {
        binding.rvCategory.adapter=categoryAdapter
    }
}