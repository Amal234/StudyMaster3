package com.example.studymaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.studymaster.databinding.FragmentWeekdaysBinding
import com.example.studymaster.databinding.SaturdayBinding

/**
 * A simple [Fragment] subclass.
 */
class saturday_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: SaturdayBinding = DataBindingUtil.inflate(
            inflater, R.layout.saturday, container, false)
        return binding.root
        }
    }


