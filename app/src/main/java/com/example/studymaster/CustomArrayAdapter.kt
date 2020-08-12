package com.example.studymaster

import android.annotation.SuppressLint
import android.content.Context
import android.system.Os.remove
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.studymaster.monday_fragment
import javax.security.auth.Subject


class MyCustomAdapter (private val list: ArrayList<String>, private val tlist: ArrayList<String>, context: Context) : BaseAdapter(), ListAdapter {



    private val inflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(pos: Int): Any {
        return list[pos]
    }

    override fun getItemId(pos: Int): Long {
        return 0
        //just return 0 if your list items do not have an Id variable.
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val rowView = inflater.inflate(R.layout.custom_item_layout, parent, false)

        //All Elements in our customlayout
        val listItemText =
            rowView.findViewById(R.id.list_item_string) as TextView
            listItemText.text = list[position]


        val TimeItemView = rowView.findViewById(R.id.Time) as TextView
        TimeItemView.text = tlist[position]

        val imageButtonColour = rowView.findViewById(R.id.image_Colour) as ImageButton
        val imageButtonDelete = rowView.findViewById(R.id.image_Delete) as ImageButton
        val imageButtonStart = rowView.findViewById(R.id.image_Start) as ImageButton


        /*addButton.setOnClickListener {
            val subject = editText.text
            arrayList.add(subject.toString())

            subjectList.adapter = adapter
            timeSpinner.adapter = adapter_time


            //Methods? (for populate and/or do something) of the elements above
            imageButtonDelete.setOnClickListener {
                //do something

                listItemText.remove()
                notifyDataSetChanged()
            */



            return rowView

        }
}
