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


        //get Time-value from CustomArrayAdapter Class
        val intent = intent
        val receivedTime = intent.getStringExtra("TimeInPosition")
        val receivedSubject = intent.getStringExtra("SubjectInPosition")
        binding.TextViewStudySubject.append(receivedSubject)
        binding.textViewCountdown.setText(receivedTime)

    //schwacher code!!
        when (true) {
            receivedTime == "00:30:00" ->  mTimeLeftInMillis= 1800000
            receivedTime == "01:00:00" -> mTimeLeftInMillis= 3600000
            receivedTime == "01:15:00" -> mTimeLeftInMillis= 4500000
            receivedTime == "01:30:00" -> mTimeLeftInMillis= 5400000   // wandelt die stunden um

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
                        val hours = (mTimeLeftInMillis / 1000).toInt() /3600000
                        val minutes = (mTimeLeftInMillis / 1000).toInt() / 60
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