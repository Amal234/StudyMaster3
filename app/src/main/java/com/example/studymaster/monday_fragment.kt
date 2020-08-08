package com.example.studymaster

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.hardware.SensorManager
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
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


            /* val v =  inflater.inflate(R.layout.monday, container, false)
            // Extension function to replace fragment
            fun AppCompatActivity.replaceFragment(fragment: Fragment){
                val fragmentManager = supportFragmentManager
                val transaction = fragmentManager.beginTransaction()
                transaction.replace(R.id.NavHostFragment,fragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
            binding.mylist.setOnClickListener {
                val context = activity as AppCompatActivity
                context.replaceFragment(Timer_Fragment())

            }
           binding.mylist.setOnItemClickListener{
                    parent, view, position, id -> Navigation.createNavigateOnClickListener(R.id.action_monday_fragment_to_timer_Fragment)

                val myIntent = Intent( activity as Context, Timer_Fragment::class.java)
                startActivity(myIntent)

           }*/
    mylist.setOnItemClickListener{
    parent, view, position, id ->

    Toast.makeText(activity as Context, "blabla:" , Toast.LENGTH_SHORT).show()


}
        }

        //Mandatory code to hide the keyboard after typing

        val sensorManager =
            activity!!.getSystemService(Context.SENSOR_SERVICE) as SensorManager

        return binding.root

        }

}





