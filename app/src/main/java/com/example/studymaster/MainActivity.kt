package com.example.studymaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.studymaster.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        //************************* TODO:binding**********************************//

        // to get reference to the button and  and assign it to immutable variable
        val aboutbutton: Button = findViewById(R.id.about_button)
        val imagebutton: ImageButton = findViewById(R.id.start_button)

imagebutton.setOnClickListener{
    Toast.makeText(this, "image button wurde clicked" , Toast.LENGTH_SHORT).show()
}
        // to add an action
        aboutbutton.setOnClickListener {
            // to get a 2 second message that the button
            Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        }
    }

    //**********************************************
}
