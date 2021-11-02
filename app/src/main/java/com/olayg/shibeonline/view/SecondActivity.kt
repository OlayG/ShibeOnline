package com.olayg.shibeonline.view

import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.olayg.shibeonline.databinding.ActivityScrollBinding


class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScrollBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val dogs: ArrayList<String>? = intent.getStringArrayListExtra("images")
        if (dogs != null) {
            for (index in dogs) {

                val imgURL = index
                val `in` = java.net.URL(imgURL).openStream()
                var image = BitmapFactory.decodeStream(`in`)
                val imageView = ImageView(this)
                imageView.layoutParams = binding.scroller.layoutParams
                imageView.setImageBitmap(image)
                binding.scroller.addView(imageView)

                // String names = getIntent().getStringExtra("Namehere");
            }
        }
    }


}