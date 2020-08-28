package com.example.studymaster

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.example.studymaster.databinding.TimerBinding
import kotlinx.android.synthetic.main.timer.*

import java.util.*


//ToDO: minuten + sekunden only


class Timer_Activity : AppCompatActivity() {

  //  private val START_TIME_IN_MILLIS: Long = 36000000
    private lateinit var binding: TimerBinding
    var mTimerRunning = false

    var mTextViewCountDown: TextView? = null

    var mCountDownTimer: CountDownTimer? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<TimerBinding>(this, R.layout.timer)



        mTextViewCountDown = findViewById(R.id.text_view_countdown)
        var mButtonStart = binding.buttonStart
        var mButtonPause = binding.buttonPause
        var mTimeLeftInMillis:Long = 0


        val toolbar = findViewById(R.id.toolbar) as Toolbar?
        setSupportActionBar(toolbar)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        toolbar?.setTitle("YOUR TIMER")

        //get Time-value from CustomArrayAdapter Class
        val intent = intent
        val receivedTime = intent.getStringExtra("TimeInPosition")
        val receivedSubject = intent.getStringExtra("SubjectInPosition")

        //append time with 'seconds' inside the timer
        val receivedTime_formatted = receivedTime + ":00"

        binding.TextViewStudySubject.append(receivedSubject)
        binding.textViewCountdown.setText(receivedTime_formatted)

    //schwacher code!!
        when (true) {
            receivedTime_formatted == "00:30:00" -> mTimeLeftInMillis = 1800000
            receivedTime_formatted == "01:00:00" -> mTimeLeftInMillis = 3600000
            receivedTime_formatted == "01:15:00" -> mTimeLeftInMillis = 4500000
            receivedTime_formatted == "01:30:00" -> mTimeLeftInMillis = 5400000
            receivedTime_formatted == "01:45:00" -> mTimeLeftInMillis = 6300000
            receivedTime_formatted == "02:00:00" -> mTimeLeftInMillis = 7200000
            receivedTime_formatted == "02:15:00" -> mTimeLeftInMillis = 8100000
            receivedTime_formatted == "02:30:00" -> mTimeLeftInMillis = 9000000
            receivedTime_formatted == "02:45:00" -> mTimeLeftInMillis = 9900000
            receivedTime_formatted == "03:00:00" -> mTimeLeftInMillis = 10800000
            receivedTime_formatted == "03:15:00" -> mTimeLeftInMillis = 11700000
            receivedTime_formatted == "03:30:00" -> mTimeLeftInMillis = 12600000
            receivedTime_formatted == "03:45:00" -> mTimeLeftInMillis = 13500000
            receivedTime_formatted == "04:00:00" -> mTimeLeftInMillis = 14400000
            receivedTime_formatted == "04:15:00" -> mTimeLeftInMillis = 15300000
            receivedTime_formatted == "04:30:00" -> mTimeLeftInMillis = 16200000
            receivedTime_formatted == "04:45:00" -> mTimeLeftInMillis = 17100000
            receivedTime_formatted == "05:00:00" -> mTimeLeftInMillis = 18000000


         // receivedTime == "01"

        }

        /*if (receivedTime == "00:30:00") {
            mTimeLeftInMillis= 1800000
        } else if (receivedTime == "01:00:00") {
            mTimeLeftInMillis = 3600000
        }*/


        fun startTimer() {
            mCountDownTimer = object : CountDownTimer(mTimeLeftInMillis, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    mTimeLeftInMillis = millisUntilFinished

                    fun updateCountDownText() {

                        val hours = (mTimeLeftInMillis / 1000).toInt() /3600
                        val minutes = (mTimeLeftInMillis / 1000).toInt() %3600 / 60
                        val seconds = (mTimeLeftInMillis/1000).toInt() % 60


                        val timeLeftFormatted =
                            String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds)

                        mTextViewCountDown!!.setText(timeLeftFormatted)

                    }
                    updateCountDownText()
                }

                override fun onFinish() {
                    mTimerRunning = false
                }

            }.start()

            mTimerRunning = true
        }
        fun pauseTimer() {
            mCountDownTimer!!.cancel()
            mTimerRunning = false


        }

        mButtonStart.setOnClickListener(View.OnClickListener {
            startTimer()

                })
        mButtonPause.setOnClickListener(View.OnClickListener {
            pauseTimer()

        })

    }
}