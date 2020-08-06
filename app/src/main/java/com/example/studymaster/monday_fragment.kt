package com.example.studymaster

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.hardware.SensorManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.studymaster.databinding.MondayBinding
import kotlinx.android.synthetic.main.monday.*
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class monday_fragment : Fragment() {



    val arrayList = ArrayList<String>()//Creating an empty arraylist.


    @SuppressLint("ServiceCast")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        val binding: MondayBinding = DataBindingUtil.inflate(
            inflater, R.layout.monday, container, false
        )

        val addButton = binding.addButton
        val subjectList = binding.mylist




        addButton.setOnClickListener {
            val subject = editText.text
            arrayList.add(subject.toString())
            var adapter: ArrayAdapter<*>

            adapter = ArrayAdapter(activity as Context, android.R.layout.simple_list_item_1, arrayList)
            subjectList.adapter = adapter

        }

        //Mandatory code to hide the keyboard after typing

        val sensorManager =
            activity!!.getSystemService(Context.SENSOR_SERVICE) as SensorManager

        return binding.root

        }

}





