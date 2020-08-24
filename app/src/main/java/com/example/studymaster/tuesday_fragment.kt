package com.example.studymaster

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.studymaster.databinding.TuesdayBinding
import kotlinx.android.synthetic.main.monday.*


/**
 * A simple [Fragment] subclass.
 */
class tuesday_fragment : Fragment() {

    val myarrayList = ArrayList<String>()//Array for user input Subject
    val arrayTime = ArrayList<String>() //Array for user-choosen Time


    @SuppressLint("ServiceCast")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        val binding: TuesdayBinding = DataBindingUtil.inflate(
            inflater, R.layout.tuesday, container, false
        )

        val addButton = binding.addButton
        val subjectList= binding.mylist
        val timeList = binding.mylist
        //val timeSpinner= binding.TimeSpinner

        val adapter = MyCustomAdapter(myarrayList, arrayTime, activity as Context)


        addButton.setOnClickListener {
            val subject = editText.text
            val time = TimeSpinner.selectedItem
            myarrayList.add(subject.toString())
            arrayTime.add(time.toString())

            subjectList.adapter = adapter
            timeList.adapter = adapter
        }




        return binding.root
    }
}




