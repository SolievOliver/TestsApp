package com.oliverworks.testsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.oliverworks.testsapp.ui.dashboard.SavedFragment
import com.oliverworks.testsapp.ui.home.HomeFragment
import com.oliverworks.testsapp.ui.notifications.SettingsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var navigation: BottomNavigationView
    private lateinit var drawer: Drawer
    private lateinit var header: AccountHeader
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation = findViewById(R.id.nav_view)
        createToolbar()
        createHeader()
        createDrawer()
        supportFragmentManager.beginTransaction()
            .add(R.id.main_body, HomeFragment())
            .commit()
        navigation.setOnNavigationItemSelectedListener {
            var fragment: Fragment? = null
            fragment = when (it.itemId) {
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

    private fun createDrawer() {
        drawer = DrawerBuilder()
            .withActivity(this)
            .withToolbar(toolbar)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            .withAccountHeader(header)
            .addDrawerItems(
                PrimaryDrawerItem().withIdentifier(100)
                    .withIcon(R.drawable.ic_home_black_24dp)
                    .withName("To make some")
                    .withSelectable(false)
            ).build()
    }

    private fun createToolbar() {
        toolbar = findViewById(R.id.main_toolbar)
        setSupportActionBar(toolbar)
    }

    private fun createHeader() {
        header = AccountHeaderBuilder()
            .withActivity(this)
            .withHeaderBackground(R.drawable.header)
            .addProfiles(
                ProfileDrawerItem()
                    .withName("Oliver")
                    .withEmail("solievasd@")
            ).build()
    }
}