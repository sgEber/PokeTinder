package com.solano.eber.poketinder2023.ui.view


import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.solano.eber.poketinder2023.R
import com.solano.eber.poketinder2023.databinding.ActivityMainBinding



class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment)

        navView.setupWithNavController(navController)
    }
}
