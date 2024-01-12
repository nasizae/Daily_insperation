package com.example.dailyinsperation.presentation.identification.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.dailyinsperation.R
import com.example.dailyinsperation.data.model.Users
import com.example.dailyinsperation.databinding.FragmentRegistrationBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RegistrationFragment : Fragment() {
    private lateinit var binding: FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRegisterAuth()
    }

    private fun initRegisterAuth() {
        binding.btnSign.setOnClickListener {
            findNavController().navigate(R.id.authorizationFragment)
        }
        binding.btnRegister.setOnClickListener {
                        binding.apply {
                         val myData = FirebaseDatabase.getInstance().getReference(USER_KAY)
                            var data = Users(
                                myData.key,
                                etUsername.toString(),
                                etPassword.toString(),
                                etEmail.toString(),
                                etConfirmPassword.toString()
                            )
                            myData.push().setValue(data)
                        }
                    }
                }
    companion object {
        val USER_KAY = "Users"
    }
}