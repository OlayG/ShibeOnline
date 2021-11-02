package com.olayg.shibeonline.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.olayg.shibeonline.R
import com.olayg.shibeonline.databinding.ActivityMainBinding
import com.olayg.shibeonline.repo.remote.RetrofitInstance.shibeService
import com.olayg.shibeonline.viewmodel.ShibeViewModel
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<ShibeViewModel>()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGo.setOnClickListener(){

            if(binding.countField.text.toString().toInt() < 101){
                getResults()
            }
        }


        //val intent = Intent(Intent.ACTION_DIAL)
        //startActivity(intent)



    }

    fun getResults(){
        // Use this method to get the images
        //shibeService.getImages(10,false,false)
        viewModel.getImages(binding.countField.text.toString().toInt())

        viewModel.shibes.observe(this) {
            // Here is where your will get the result
            //Log.d("MainActivity", "onCreate: $it")
            val intent = Intent(this, SecondActivity::class.java)
            intent.putStringArrayListExtra("images", it as ArrayList<String>?)
            startActivity(intent)
        }
    }
}