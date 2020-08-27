package com.example.studymaster

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.studymaster.databinding.MondayBinding
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.custom_item_layout.*
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
        //val timeSpinner= binding.TimeSpinner

        val adapter = MyCustomAdapter(myarrayList, arrayTime, activity as Context)



        //adapter for subject
        //val adapter: ArrayAdapter<*> = ArrayAdapter(activity as Context, android.R.layout.simple_list_item_1, arrayList)

       //
        //val adapter_time= ArrayAdapter.createFromResource (activity as Context, R.array.subjectTimeList, android.R.layout.simple_spinner_item)


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





