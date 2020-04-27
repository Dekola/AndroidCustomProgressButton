package com.example.customprogressbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login_btn.onCustomClickListener {
            login_btn.load(true)
            Handler().postDelayed({
                login_btn.load(false)
            }, 3000)

        }
    }

//    private fun setObservers() {
//        viewModel.loginrequest.observe(this, Observer {resource->
//            login_btn.load(resource is Resource.Loading)
//            when(resource){
//                is Resource.Success -> {
//
//                }
//                is Resource.Error -> {
//
//                }
//            }
//        })
//    }
}
