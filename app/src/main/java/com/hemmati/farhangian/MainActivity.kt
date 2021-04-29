package com.hemmati.farhangian

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupAppConfiguration()
    }

    private fun setupAppConfiguration() {
        val navHostFragment  = supportFragmentManager.findFragmentById(
            R.id.nav_host_fragment
        ) as NavHostFragment
        val appConfiguration = AppBarConfiguration(navHostFragment.navController.graph)
        toolbar.setupWithNavController(navHostFragment.navController, appConfiguration)
    }

    override fun onBackPressed() {
        val navController = findNavController(R.id.nav_host_fragment)
        if (navController.backStack.size > 1) {
            navController.navigateUp()
            navController.popBackStack()
        } else
            super.onBackPressed()
    }
}