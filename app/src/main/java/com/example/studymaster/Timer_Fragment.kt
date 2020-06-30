package com.example.studymaster

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment


/**
 * A simple [Fragment] subclass.
 */
class Timer_Fragment : Fragment() {
data class Timer(val text: String)

    // private TextView countdowntext;
    //private Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       // val bindingUtil = DataBindingUtil.inflate(inflater, R.layout.timer,container,false)
        // return binding.root
       return inflater.inflate(R.layout.timer,container,false)
    }

}
