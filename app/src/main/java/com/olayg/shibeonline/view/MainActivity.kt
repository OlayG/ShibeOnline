package com.olayg.shibeonline.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import com.olayg.shibeonline.R
import com.olayg.shibeonline.databinding.ActivityMainBinding
import com.olayg.shibeonline.viewmodel.ShibeViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<ShibeViewModel>()
    private val b by lazy { ActivityMainBinding.inflate(layoutInflater)}
    private var n: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        b.btnSubmit.setOnClickListener{
            n = b.editText1.text.toString().toInt()
            viewModel.getImages(n)
        }
//        // Use this method to get the images
//        viewModel.getImages(10)

        viewModel.shibes.observe(this) {
            // Here is where your will get the result
            Log.d("MainActivity", "onCreate: $it")
            val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, it)
            b.listView1.adapter = arrayAdapter
        }
    }
}