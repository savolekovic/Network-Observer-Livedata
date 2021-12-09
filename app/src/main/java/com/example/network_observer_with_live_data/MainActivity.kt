package com.example.network_observer_with_live_data

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.network_observer_with_live_data.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Network observer
    private lateinit var connectionLiveData: ConnectionLiveData

    //Data Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //Initialize network observer
        connectionLiveData = ConnectionLiveData(this)
        connectionLiveData.observe(this, { isNetworkAvailable ->
            Log.d(TAG, "isNetworkAvailable: $isNetworkAvailable")
            //updateUI
            if(isNetworkAvailable){
                binding.image.setImageResource(R.drawable.ic_online)
                binding.text.text = getString(R.string.online)
            }else{
                binding.image.setImageResource(R.drawable.ic_offline)
                binding.text.text = getString(R.string.offline)
            }
        })

    }
}