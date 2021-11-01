package com.olayg.shibeonline.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.olayg.shibeonline.R
import com.olayg.shibeonline.databinding.ActivityMainBinding
import com.olayg.shibeonline.viewmodel.ShibeViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val viewModel by viewModels<ShibeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Use this method to get the images
        binding.shibeButton.setOnClickListener(this)
//        viewModel.getImages(10)

        viewModel.shibes.observe(this) {
            // Here is where your will get the result
            var urmom = binding.countText.text
            Log.d("MainActivity", "onCreate: $it")
            var doges = it.toString()
            binding.shibeOutput.text = doges
        }
    }

    override fun onClick(v: View?) {
            when(v?.id){
                R.id.shibeButton -> viewModel.getImages(10)
            }
    }
}