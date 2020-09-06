package com.example.studymaster

import android.R.attr.rating
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.studymaster.databinding.MondayBinding
import kotlinx.android.synthetic.main.monday.*
import timber.log.Timber


const val KEY_ARRAYTIME = "arraylist"
const val KEY_MYARRAYLIST = "arraytime"


class monday_fragment : Fragment() {

    companion object {
        fun newInstance(): monday_fragment {
            return monday_fragment()
        }
    }

    var myarrayList = ArrayList<String>()//Array for user input Subject
    var arrayTime = ArrayList<String>() //Array for user-choosen Time



    override fun onAttach(context: Context){
        super.onAttach(context)
        /*if (context is FragmentEvent){
            listener = context
        } else {
            throw ClassCastException(context.toString() + " must implement FragmentEvent")
        }*/
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: MondayBinding = DataBindingUtil.inflate(
            inflater, R.layout.monday, container, false
        )

        val addButton = binding.addButton
        val subjectList= binding.mylist
        val timeList=binding.mylist

        val adapter = MyCustomAdapter(myarrayList, arrayTime, activity as Context)
        savedInstanceState?.getStringArrayList("KEY_MYARRAYLIST")
        savedInstanceState?.getStringArrayList("KEY_ARRAYTIME")



        addButton.setOnClickListener {


            val subject = editText.text
            val time = TimeSpinner.selectedItem
            myarrayList.add(subject.toString())
            arrayTime.add(time.toString())

            subjectList.adapter = adapter
            //subjectList.invalidate()
            timeList.adapter = adapter

            subject.clear()
     adapter.notifyDataSetChanged()
        }

        //? view
        return binding.root

        }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putStringArrayList(KEY_MYARRAYLIST, myarrayList)
        outState.putStringArrayList(KEY_ARRAYTIME, arrayTime)
        Timber.i("onSaveInstanceState Called")
        super.onSaveInstanceState(outState)
    }


}









