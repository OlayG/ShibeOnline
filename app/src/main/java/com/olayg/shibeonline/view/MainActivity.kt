package com.olayg.shibeonline.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.olayg.shibeonline.R
import com.olayg.shibeonline.adapter.ShibeAdapter
import com.olayg.shibeonline.databinding.ActivityMainBinding
import com.olayg.shibeonline.viewmodel.ShibeViewModel

class MainActivity : AppCompatActivity() {

    /**
     * ViewModel for shibe API
     */
    private val viewModel by viewModels<ShibeViewModel>()

    /**
     * Layout binding
     */
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()

        // Observe shibes data
        viewModel.shibes.observe(this) {

            // Update shibes with new data
            (binding.rvImages.adapter as ShibeAdapter).updateUrls(it)

        }

    }

    /**
     * Initialize views and listeners
     */
    private fun initViews() = with(binding) {

        // Listener for count input
        btnFetch.setOnClickListener {

            val count = binding.etCount.text?.toString()?.toIntOrNull()

            viewModel.getImages(count ?: 1)

        }

        btnSwitchLayout.setOnClickListener {

            // Cast current layout manager to LayoutManager
            val manager = (rvImages.layoutManager as RecyclerView.LayoutManager)::class.java

            // If layoutManager is an instance of LinearLayoutManager
            if (manager == LinearLayoutManager::class.java) {

                // Create new grid layout manager
                rvImages.layoutManager = GridLayoutManager(it.context, 2)

                // Switch button text
                btnSwitchLayout.text = getString(R.string.linear)

            } else {

                // Create new linear layout manager
                rvImages.layoutManager = LinearLayoutManager(it.context)

                // Switch button text
                btnSwitchLayout.text = getString(R.string.grid)

            }

        }

        // Sets RecyclerView adapter
        rvImages.adapter = ShibeAdapter()

    }

}