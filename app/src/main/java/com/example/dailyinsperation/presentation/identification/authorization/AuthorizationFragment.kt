package com.example.dailyinsperation.presentation.identification.authorization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.dailyinsperation.R
import com.example.dailyinsperation.databinding.FragmentAuthorizationBinding
import com.google.firebase.auth.FirebaseAuth

class AuthorizationFragment : Fragment() {
    private lateinit var binding: FragmentAuthorizationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAuth()
    }

    private fun initAuth() {
        binding.btnRegister.setOnClickListener {
            findNavController().navigate(R.id.registrationFragment)
        }
        binding.btnSignIn.setOnClickListener {
            if (binding.etUsername.toString().isEmpty() || binding.etPassword.toString()
                    .isEmpty()
            ) {
                Toast.makeText(requireContext(), "поля не должны быть пустыми", Toast.LENGTH_SHORT)
                    .show()
            } else {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding.etUsername.toString(),
                    binding.etPassword.toString()
                ).addOnCompleteListener {
                    if(it.isSuccessful){
                        findNavController().navigate(R.id.navigation_home)
                    }
                }
            }
        }
    }
}