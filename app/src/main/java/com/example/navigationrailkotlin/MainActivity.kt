package com.example.navigationrailkotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.navigationrailkotlin.databinding.ActivityMainBinding
import com.example.navigationrailkotlin.fragments.CoursesFragment
import com.example.navigationrailkotlin.fragments.HomeFragment
import com.example.navigationrailkotlin.fragments.StopwatchFragment
import com.example.navigationrailkotlin.fragments.TimerFragment
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var badgeDrawable: BadgeDrawable
    private var isTablet = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportFragmentManager.beginTransaction().replace(binding.frame.id, HomeFragment()).commit()

        isTablet = binding.navigationRail.isVisible

        if (isTablet)
        {
            badgeDrawable = binding.navigationRail.getOrCreateBadge(R.id.homes)
            badgeDrawable.isVisible = true
            badgeDrawable.number = 90

            binding.navigationRail.setOnItemSelectedListener { item ->
                when(item.itemId) {
                    R.id.homes -> {
                        supportFragmentManager.beginTransaction().replace(binding.frame.id, HomeFragment()).commit()
                        Toast.makeText(applicationContext, "Home Fragment Open", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.courses -> {
                        supportFragmentManager.beginTransaction().replace(binding.frame.id, CoursesFragment()).commit()
                        Toast.makeText(applicationContext, "Courses Fragment Open", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.timer -> {
                        supportFragmentManager.beginTransaction().replace(binding.frame.id, TimerFragment()).commit()
                        Toast.makeText(applicationContext, "Timer Fragment Open", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.stopwatch -> {
                        supportFragmentManager.beginTransaction().replace(binding.frame.id, StopwatchFragment()).commit()
                        Toast.makeText(applicationContext, "Stopwatch Fragment Open", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
        }else{
            binding.bottomNavigation.setOnItemSelectedListener {  item ->
                when(item.itemId) {
                    R.id.homes -> {
                        supportFragmentManager.beginTransaction().replace(binding.frame.id, HomeFragment()).commit()
                        Toast.makeText(applicationContext, "Home Fragment Open", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.courses -> {
                        supportFragmentManager.beginTransaction().replace(binding.frame.id, CoursesFragment()).commit()
                        Toast.makeText(applicationContext, "Courses Fragment Open", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.timer -> {
                        supportFragmentManager.beginTransaction().replace(binding.frame.id, TimerFragment()).commit()
                        Toast.makeText(applicationContext, "Timer Fragment Open", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.stopwatch -> {
                        supportFragmentManager.beginTransaction().replace(binding.frame.id, StopwatchFragment()).commit()
                        Toast.makeText(applicationContext, "Stopwatch Fragment Open", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
        }

    }

}