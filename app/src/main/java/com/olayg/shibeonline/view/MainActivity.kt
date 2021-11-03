package com.olayg.shibeonline.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.olayg.shibeonline.adapter.ShibeAdapter
import com.olayg.shibeonline.databinding.ActivityMainBinding
import com.olayg.shibeonline.viewmodel.ShibeViewModel

/**
 * TODO
 * Add a button to switch between LinearLayoutManager and GridLayoutManager
 */
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

            if (rvImages.layoutManager!!::class.java == LinearLayoutManager::class.java) {

                val gridLayoutManager = GridLayoutManager(it.context, 2)

                gridLayoutManager.spanSizeLookup

                rvImages.layoutManager = gridLayoutManager

                btnSwitchLayout.text = "Linear"

            } else {

                rvImages.layoutManager = LinearLayoutManager(it.context)

                btnSwitchLayout.text = "Grid"

            }

        }

        // Sets RecyclerView adapter
        rvImages.adapter = ShibeAdapter()

    }

}