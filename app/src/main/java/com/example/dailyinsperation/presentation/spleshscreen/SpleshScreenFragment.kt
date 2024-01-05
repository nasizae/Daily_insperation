package com.example.dailyinsperation.presentation.spleshscreen

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dailyinsperation.R
import com.example.dailyinsperation.data.local.pref.Pref
import com.example.dailyinsperation.databinding.FragmentSpleshScreenBinding

class SpleshScreenFragment : Fragment() {
    private lateinit var binding: FragmentSpleshScreenBinding
    private val pref : Pref by lazy {
        Pref(requireContext())
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSpleshScreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initInizial()

    }

    private fun initInizial() {
        Handler().postDelayed({

            if (!pref.isOnBoardingShow()) {
                findNavController().navigate(R.id.onBoardingFragment)
            }
             else {
                findNavController().navigate(R.id.navigation_home)
            }
        }, 2000)

    }
}