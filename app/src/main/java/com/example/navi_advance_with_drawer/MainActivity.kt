package com.example.navi_advance_with_drawer

import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private var currentNavController: LiveData<NavController>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)

        if (savedInstanceState == null) {
            setupNavigationBar()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        setupNavigationBar()
    }

    private fun setupNavigationBar() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)

        val navGraphIds = listOf(R.navigation.game_fragment,R.navigation.app_fragment,
                R.navigation.movie_fragment,R.navigation.book_fragment)

        val controller = bottomNavigationView.setupWithNavControllers(
                navGraphIds = navGraphIds,
                fragmentManager = supportFragmentManager,
                containerId = R.id.nav_container,
                intent = intent
        )

        controller.observe(this, Observer { navController ->
            nav_view.setupWithNavController(navController)
            appBarConfiguration = AppBarConfiguration(navController.graph,drawer_layout)
            setupActionBarWithNavController(navController,appBarConfiguration)
        })
        currentNavController = controller


    }


    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value!!.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
