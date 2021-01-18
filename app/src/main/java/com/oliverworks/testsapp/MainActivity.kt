package com.oliverworks.testsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.oliverworks.testsapp.ui.dashboard.SavedFragment
import com.oliverworks.testsapp.ui.home.HomeFragment
import com.oliverworks.testsapp.ui.notifications.SettingsFragment

class MainActivity : AppCompatActivity() {

    lateinit var navigation : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation = findViewById(R.id.nav_view)
        supportFragmentManager.beginTransaction()
            .add(R.id.main_body, HomeFragment())
            .commit()
        navigation.setOnNavigationItemSelectedListener {
            var fragment : Fragment? = null
            fragment = when(it.itemId){
                R.id.navigation_home -> HomeFragment()
                R.id.navigation_dashboard -> SavedFragment()
                else -> SettingsFragment()
            }
            supportFragmentManager.beginTransaction().replace(
                R.id.main_body,
                fragment
            ).commit()
            true
        }
    /*  val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)*/
    }
}