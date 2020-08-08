package com.example.studymaster

import android.os.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.timer.*
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class Timer_Fragment : Fragment() {

//data class Timer(val text: String)


    // private TextView countdowntext;
    //private Button
    private val handler = Handler()
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Update TextView every second
        handler.post(object : Runnable {
            override fun run() {
                // Keep the postDelayed before the updateTime(), so when the event ends, the handler will stop too.
                handler.postDelayed(this, 1000)
                updateTime()
            }
        })

       // val bindingUtil = DataBindingUtil.inflate(inflater, R.layout.timer,container,false)
        // return binding.root
       return inflater.inflate(R.layout.timer,container,false)
    }
    fun updateTime() {
        // Set Current Date
        val currentDate = Calendar.getInstance()
        // Find how many milliseconds until the event
        val eventDate = Calendar.getInstance()
        eventDate[Calendar.MINUTE] = 0
        eventDate[Calendar.SECOND] = 0
        eventDate.timeZone = TimeZone.getTimeZone("GMT")
        //val diff = eventDate.timeInMillis - currentDate.timeInMillis
        val diff = currentDate.timeInMillis- eventDate.timeInMillis
        // Change the milliseconds to , hours, minutes and seconds
        val hours = diff / (1000 * 60 * 60) % 24
        val minutes = diff / (1000 * 60) % 60
        val seconds = (diff / 1000) % 60
        // Display Countdown
        countdown_text.text = " ${minutes}m ${seconds}s"
        // Show different text when the event has passed
        endEvent(currentDate, eventDate)


    }
    private fun endEvent(currentdate: Calendar, eventdate: Calendar) {
        if (currentdate.time >= eventdate.time) {
            //  countdown_text.text = "Happy New Year!"
            //Stop Handler
            handler.removeMessages(0)
        }
    }
}
