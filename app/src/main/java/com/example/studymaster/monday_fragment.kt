package com.example.studymaster

import android.R.attr.rating
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.studymaster.databinding.MondayBinding
import kotlinx.android.synthetic.main.monday.*


/**
 * A simple [Fragment] subclass.
 */
class monday_fragment : Fragment() {

    val myarrayList = ArrayList<String>()//Array for user input Subject
    val arrayTime = ArrayList<String>() //Array for user-choosen Time


    @SuppressLint("ServiceCast")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        val binding: MondayBinding = DataBindingUtil.inflate(
            inflater, R.layout.monday, container, false
        )


        val addButton = binding.addButton
        val subjectList= binding.mylist
        val timeList = binding.mylist


        val adapter = MyCustomAdapter(myarrayList, arrayTime, activity as Context)



        addButton.setOnClickListener {
            val subject = editText.text
            val time = TimeSpinner.selectedItem
            myarrayList.add(subject.toString())
            arrayTime.add(time.toString())

            subjectList.adapter = adapter
            subjectList.invalidate()
            timeList.adapter = adapter
            timeList.invalidate()
            subject.clear()

        }




        return binding.root

        }


}





