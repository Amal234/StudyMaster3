package com.example.studymaster

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.studymaster.databinding.FridayBinding
import com.example.studymaster.databinding.SundayBinding
import kotlinx.android.synthetic.main.monday.*
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 */
class friday_fragment : Fragment() {
    val myarrayList = ArrayList<String>()//Array for user input Subject
    val arrayTime = ArrayList<String>() //Array for user-choosen Time

    @SuppressLint("ServiceCast")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FridayBinding = DataBindingUtil.inflate(
            inflater, R.layout.friday, container, false)
        val addButton = binding.addButton
        val subjectList= binding.mylist
        val timeList = binding.mylist
        //val timeSpinner= binding.TimeSpinner

        val adapter = MyCustomAdapter(myarrayList, arrayTime, activity as Context)
        savedInstanceState?.getStringArrayList("KEY_MYARRAYLIST")
        savedInstanceState?.getStringArrayList("KEY_ARRAYTIME")

        addButton.setOnClickListener {
            val subject = editText.text
            val time = TimeSpinner.selectedItem
            myarrayList.add(subject.toString())
            arrayTime.add(time.toString())

            subjectList.adapter = adapter
            timeList.adapter = adapter
            subject.clear()
        }
        return binding.root
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putStringArrayList(KEY_MYARRAYLIST, myarrayList)
        outState.putStringArrayList(KEY_ARRAYTIME, arrayTime)
        Timber.i("onSaveInstanceState Called")
        super.onSaveInstanceState(outState)
    }

}
