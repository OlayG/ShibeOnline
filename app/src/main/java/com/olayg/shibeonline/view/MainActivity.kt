package com.olayg.shibeonline.view

import ItemAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.olayg.shibeonline.viewmodel.ShibeViewModel
import com.olayg.shibeonline.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity()  {

    private val viewModel by viewModels<ShibeViewModel>()
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Use this method to get the images
        viewModel.getImages(10)

        viewModel.shibes.observe(this) {
            // Here is where your will get the result
            Log.d("MainActivity", "onCreate: $it")
            val recyclerView = binding.mobileList
            recyclerView.adapter = ItemAdapter(this, it)
        }
    }
}