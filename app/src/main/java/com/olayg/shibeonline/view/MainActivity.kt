package com.olayg.shibeonline.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
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

            // If layoutManager is an instance of LinearLayoutManager
            if (rvImages.layoutManager is GridLayoutManager) {

                // Create new linear layout manager
                rvImages.layoutManager = LinearLayoutManager(it.context)

                // Switch button text
                btnSwitchLayout.text = getString(R.string.grid)

            } else {

                // Create new grid layout manager
                rvImages.layoutManager = GridLayoutManager(it.context, 2)

                // Switch button text
                btnSwitchLayout.text = getString(R.string.linear)

            }

        }

        // Sets RecyclerView adapter
        rvImages.adapter = ShibeAdapter()

    }

}