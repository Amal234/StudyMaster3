package com.example.studymaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.studymaster.databinding.SundayBinding
import com.example.studymaster.databinding.WednesdayBinding

/**
 * A simple [Fragment] subclass.
 */
class wednesday_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: WednesdayBinding = DataBindingUtil.inflate(
            inflater, R.layout.wednesday, container, false)
        return binding.root
        }
    }


