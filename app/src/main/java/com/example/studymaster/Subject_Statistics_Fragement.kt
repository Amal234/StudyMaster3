package com.example.studymaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_host.*

/**
 * A simple [Fragment] subclass.
 */
class Subject_Statistics_Fragement : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        (activity as hostActivity).supportActionBar?.title = getString(R.string.statistics_title)

        return inflater.inflate(R.layout.subject_statisctics,container,false)
    }



}
