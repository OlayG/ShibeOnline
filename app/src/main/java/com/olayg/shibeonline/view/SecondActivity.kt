package com.olayg.shibeonline.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.olayg.shibeonline.R
import com.olayg.shibeonline.databinding.ActivityScrollBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScrollBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dogs: ArrayList<String>? = intent.getStringArrayListExtra("images")
        binding.scroller.text = dogs.toString()

       // String names = getIntent().getStringExtra("Namehere");
    }


}