package com.example.dailyinsperation.presentation.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dailyinsperation.R
import com.example.dailyinsperation.data.local.pref.Pref
import com.example.dailyinsperation.databinding.FragmentOnBoardingBinding
import com.example.dailyinsperation.presentation.onboarding.adapter.Adapter

class OnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingBinding
    private lateinit var adapter: Adapter
    private val pref:Pref by lazy {
     Pref(requireContext())
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter=Adapter (this::onClick)
        binding.viewPager.adapter=adapter
        binding.indicator.setViewPager(binding.viewPager)

    }

    private fun onClick() {
        pref.onOnBoardingShowed()
        findNavController().navigateUp()
    }

}
