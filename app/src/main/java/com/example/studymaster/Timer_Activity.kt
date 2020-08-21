package com.example.studymaster

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.studymaster.databinding.TimerBinding


class Timer_Activity : AppCompatActivity() {

private lateinit var binding: TimerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
val binding = DataBindingUtil.setContentView<TimerBinding>(this, R.layout.timer)
    }


}
