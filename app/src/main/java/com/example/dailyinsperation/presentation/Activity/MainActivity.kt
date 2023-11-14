package com.example.dailyinsperation.presentation.Activity

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.dailyinsperation.R
import com.example.dailyinsperation.data.local.pref.Pref
import com.example.dailyinsperation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val pref:Pref by lazy {
        Pref(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        if (!pref.isOnBoardingShow()) {
            navController.navigate(R.id.onBoardingFragment)
        }
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_profile,
                R.id.navigation_reels,
                R.id.navigation_interesting
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        supportActionBar?.hide()
        val fragmentWithoutButtonNav = setOf(
            R.id.onBoardingFragment,
        )

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (fragmentWithoutButtonNav.contains(destination.id)) {
                navView.isVisible = false
            } else {
                navView.isVisible = true
            }
        }

    }
}