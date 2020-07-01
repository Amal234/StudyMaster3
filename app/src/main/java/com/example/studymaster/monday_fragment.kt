package com.example.studymaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.studymaster.databinding.MondayBinding
import com.example.studymaster.databinding.SaturdayBinding
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class monday_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: MondayBinding = DataBindingUtil.inflate(
            inflater, R.layout.monday, container, false)
        binding.goToTimer.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_monday_fragment_to_timer_Fragment)
        )
        return binding.root
        }



    }


