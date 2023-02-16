package com.example.redbluefragment_menuswapfragmentapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var containerView: View
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        containerView = findViewById(R.id.fragment_container)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            // The id can be used to identify which menu item was tapped,
            // and take appropriate action. This function needs to return
            // true, if the menu item should then appear selected,
            // false otherwise.
            when (menuItem.itemId) {
                R.id.show_red -> {
                    showFragment("RED")
                    true
                }
                R.id.show_blue -> {
                    showFragment("BLUE")
                    true
                }
                R.id.show_green -> {
                    showFragment("GREEN")
                    true
                }
                R.id.show_orange -> {
                    showFragment("ORANGE")
                    true
                }
                R.id.show_purple -> {
                    showFragment("PURPLE")
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun showFragment(tag: String) {
        // if the fragment requested is not on the screen,
        if (supportFragmentManager.findFragmentByTag(tag) == null) {
            when (tag) {
                "RED" -> {
                    // replace the current fragment with the red fragment
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, RedFragment.newInstance(), "RED")
                        .commit()

                    /*
                    // Alternative - need the Android KTX library, add to build.gradle for the module
                    // https://developer.android.com/kotlin/ktx#fragment
                    // Simplify code to the following, harder to forget to call .commit
                    supportFragmentManager.commit {
                        // beginTransaction()  // not needed
                        replace(R.id.fragment_container, RedFragment.newInstance(), "RED")
                    }
                     */

                }
                "BLUE" -> {
                    // Otherwise, replace the current fragment with the blue fragment
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, BlueFragment.newInstance(), "BLUE")
                        .commit()
                }
                "GREEN" -> {
                    // Otherwise, replace the current fragment with the green fragment
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, GreenFragment.newInstance(), "GREEN")
                        .commit()
                }
                "ORANGE" -> {
                    // Otherwise, replace the current fragment with the orange fragment
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, OrangeFragment.newInstance(), "ORANGE")
                        .commit()
                }
                "PURPLE" -> {
                    // Otherwise, replace the current fragment with the purple fragment
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, PurpleFragment.newInstance(), "PURPLE")
                        .commit()
                }
            }
        }
    }
}