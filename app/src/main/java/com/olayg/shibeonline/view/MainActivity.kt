package com.olayg.shibeonline.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.olayg.shibeonline.databinding.ActivityMainBinding
import com.olayg.shibeonline.viewmodel.ShibeViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<ShibeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // Use this method to get the images
        viewModel.getImages(100)

        viewModel.shibes.observe(this) {

            binding.textView.text = it.joinToString("\n\n")

        }

    }
}