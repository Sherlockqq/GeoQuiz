package com.midina.geoquiz


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainFragment = GameFragment()
        supportFragmentManager.beginTransaction().add(R.id.place_holder, mainFragment)
            .commit()
    }
}


