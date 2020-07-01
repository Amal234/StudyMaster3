package com.example.studymaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.studymaster.databinding.SaturdayBinding
import com.example.studymaster.databinding.SundayBinding

/**
 * A simple [Fragment] subclass.
 */
class sunday_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: SundayBinding = DataBindingUtil.inflate(
            inflater, R.layout.sunday, container, false)
        return binding.root
    }

}
