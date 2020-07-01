package com.example.studymaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.studymaster.databinding.SundayBinding
import com.example.studymaster.databinding.ThursdayBinding

/**
 * A simple [Fragment] subclass.
 */
class thursday_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ThursdayBinding = DataBindingUtil.inflate(
            inflater, R.layout.thursday, container, false)
        return binding.root
    }

}
