package com.example.studymaster

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.studymaster.databinding.TimerBinding
import com.example.studymaster.MyCustomAdapter


import java.util.*


class Timer_Activity : AppCompatActivity() {

    private val START_TIME_IN_MILLIS: Long = 36000000


    //ToDO timestring to Millisekunden
    //TODO BackButton

    private lateinit var binding: TimerBinding

    var mTextViewCountDown: TextView? = null
    var mButtonStartPause: Button? = null
    var mButtonReset: Button? = null
    var mCountDownTimer: CountDownTimer? = null
    var mTimerRunning = false
    var mTimeLeftInMillis = START_TIME_IN_MILLIS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<TimerBinding>(this, R.layout.timer)


        //get Time-value from CustomArrayAdapter Class
        val intent = intent
        val receivedTime = intent.getStringExtra("TimeInPosition")
        val receivedSubject = intent.getStringExtra("SubjectInPosition")


        mTextViewCountDown = findViewById(R.id.text_view_countdown)
        mButtonStartPause = findViewById(R.id.button_start_pause)
        mButtonReset = findViewById(R.id.button_reset)
        mButtonStartPause?.setOnClickListener(View.OnClickListener {

            Toast.makeText(this, "Subject: "+ receivedSubject + ", Time" +  receivedTime , Toast.LENGTH_SHORT).show()

            if (mTimerRunning) {
                pauseTimer()
            } else {
                startTimer()
            }
        })


        mButtonReset?.setOnClickListener(View.OnClickListener { resetTimer() })
        updateCountDownText()
    }


    private fun startTimer() {
        mCountDownTimer = object : CountDownTimer(mTimeLeftInMillis, 100000) {
            override fun onTick(millisUntilFinished: Long) {
                mTimeLeftInMillis = millisUntilFinished
                updateCountDownText()
            }

            override fun onFinish() {
                mTimerRunning = false
                mButtonStartPause!!.text = "Start"
                mButtonStartPause!!.visibility = View.INVISIBLE
                mButtonReset!!.visibility = View.VISIBLE
            }
        }.start()
        mTimerRunning = true
        mButtonStartPause!!.text = "pause"
        mButtonReset!!.visibility = View.INVISIBLE

    }

    private fun pauseTimer() {
        mCountDownTimer!!.cancel()
        mTimerRunning = false
        mButtonStartPause!!.text = "Start"
        mButtonReset!!.visibility = View.VISIBLE
    }

    private fun resetTimer() {
        mTimeLeftInMillis =
            START_TIME_IN_MILLIS
        updateCountDownText()
        mButtonReset!!.visibility = View.INVISIBLE
        mButtonStartPause!!.visibility = View.VISIBLE
    }

    private fun updateCountDownText() {
        val hours = (mTimeLeftInMillis / 1000).toInt() /3600000
        val minutes = (mTimeLeftInMillis / 1000).toInt() % 60


        val timeLeftFormatted =
            String.format(Locale.getDefault(), "%02d:%02d", hours, minutes)
        mTextViewCountDown!!.text = timeLeftFormatted
    }

}