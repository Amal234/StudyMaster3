package com.example.studymaster


import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import com.example.studymaster.databinding.ActivityHostBinding
import timber.log.Timber


class   hostActivity : AppCompatActivity()  {

    private lateinit var binding: ActivityHostBinding

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    // Extension function to replace fragment
    fun AppCompatActivity.replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.NavHostFragment,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    /** Lifecycle Methods **/
    override fun onStart() {
        super.onStart()
        Timber.i("onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume Called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause Called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy Called")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("onRestart Called")
    }


}