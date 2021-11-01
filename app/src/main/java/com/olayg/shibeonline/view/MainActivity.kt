package com.olayg.shibeonline.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.olayg.shibeonline.R
import com.olayg.shibeonline.viewmodel.ShibeViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<ShibeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Use this method to get the images
        viewModel.getImages(10)

        viewModel.shibes.observe(this) {
            // Here is where your will get the result
            Log.d("MainActivity", "onCreate: $it")
        }
    }
}