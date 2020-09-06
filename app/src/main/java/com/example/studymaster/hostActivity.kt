package com.example.studymaster


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.example.studymaster.databinding.ActivityHostBinding
import timber.log.Timber


class hostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.container, monday_fragment.newInstance()).commit()
        }

        val binding = DataBindingUtil.setContentView<ActivityHostBinding>(this, R.layout.activity_host)


        val toolbar = (findViewById(R.id.toolbar) as Toolbar?).also {
            setSupportActionBar(it)
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        toolbar?.setTitle("Weekly Planner")


        val fragmentMo = monday_fragment()
            binding.buttonMo.setOnClickListener {
                supportFragmentManager.beginTransaction().replace(R.id.container, fragmentMo).commit()
            }

        val fragmentTu = tuesday_fragment()
        binding.buttonDi.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container, fragmentTu).commit()
        }

        val fragmentMi = wednesday_fragment()
        binding.buttonMi.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container, fragmentMi).commit()
        }

        val fragmentDo = thursday_fragment()
        binding.buttonDo.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container, fragmentDo).commit()
        }

        val fragmentFr = friday_fragment()
        binding.buttonFr.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container, fragmentFr).commit()
        }
        val fragmentSa = saturday_fragment()
        binding.buttonSa.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container, fragmentSa).commit()
        }
        val fragmentSo = sunday_fragment()
        binding.buttonSo.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container, fragmentSo).commit()
        }

        val fragmentStats = Subject_Statistics_Fragement()
        binding.buttonStats.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container, fragmentStats)
                .commit()
        }


        //Mandatory code to hide the keyboard after typing
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)

    }

    //Keyboard for Input
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }


    /*
    override fun onActivityCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            // Get all information from the bundle, set it
            myarrayList = savedInstanceState.getStringArrayList(KEY_MYARRAYLIST) as ArrayList<String>
            arrayTime= savedInstanceState.getStringArrayList(KEY_ARRAYTIME) as ArrayList<String>
            //dessertTimer.secondsCount = savedInstanceState.getInt(KEY_TIMER_SECONDS, 0)
        }

        val subjectList= binding.mylist
        val timeList = binding.mylist
    }
*/
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}