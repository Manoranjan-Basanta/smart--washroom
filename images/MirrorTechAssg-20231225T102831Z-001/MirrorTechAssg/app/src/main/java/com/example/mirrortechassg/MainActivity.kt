package com.example.mirrortechassg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mirrortechassg.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        replaceFragment(BrainFragment())

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->

            when(menuItem.itemId){
                R.id.brain -> replaceFragment(BrainFragment())
                R.id.heart -> replaceFragment(HeartFragment())
                R.id.lungs -> replaceFragment(LungFragment())
                else -> {
                    // Handle other cases if needed
                }
            }

            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

}