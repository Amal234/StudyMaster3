package com.example.studymaster

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleObserver
import com.example.studymaster.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity()  {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)


        binding.startButton.setOnClickListener {
            val intent = Intent(this, hostActivity::class.java)
            // start your next activity
            startActivity(intent)
        }

        binding.aboutButton.setOnClickListener {
            val intent = Intent(this, About_Activity::class.java)
            // start your next activity
            startActivity(intent)
        }

        // to get reference to the button and  and assign it to immutable variable

        // to add an action
        //binding.aboutButton.setOnClickListener

        //Mandatory code to hide the keyboard after typing
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken,0)



    }



    //**********************************************
}
