package com.olayg.shibeonline.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.olayg.shibeonline.R
import com.olayg.shibeonline.adapter.ShibeAdapter
import com.olayg.shibeonline.databinding.ActivityMainBinding
import com.olayg.shibeonline.viewmodel.ShibeViewModel

/**
 * 1) Find a image loading library and use it to load the image in the adapter class
 * 2) Add a button to switch between LinearLayoutManager and GridLayoutManager
 */
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<ShibeViewModel>()
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()

        viewModel.shibes.observe(this) {
            // Here is where your will get the result
            Log.d("MainActivity", "onCreate: $it")
            (binding.rvImages.adapter as ShibeAdapter).updateUrls(it)
        }
    }

    private fun initViews() = with(binding) {
        btnFetch.setOnClickListener {
            val count = binding.etCount.text?.toString()?.toIntOrNull()
            // Use this method to get the images
            viewModel.getImages(count ?: 3)
        }
        rvImages.adapter = ShibeAdapter()
        swSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            (rvImages.layoutManager as GridLayoutManager).spanCount = if (isChecked) 2 else 1
            buttonView.text =
                if (isChecked) getString(R.string.grid) else getString(R.string.linear)
        }
    }
}