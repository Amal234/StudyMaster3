/*package com.example.studymaster

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListAdapter
import android.widget.TextView


class MyCustomAdapter(list: ArrayList<String>, context: Context) : BaseAdapter(), ListAdapter {


    private val list = ArrayList<String>()
    private val context: Context
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(pos: Int): Any {
        return list[pos]
    }

    override fun getItemId(pos: Int): Long {
        return  0
        //just return 0 if your list items do not have an Id variable.
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var view: View? = convertView
        if (view == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.
        }

        //Handle TextView and display string from your list
        val listItemText = view.findViewById(R.id.list_item_string) as TextView
        listItemText.text = list[position]

        //Handle buttons and add onClickListeners
        val deleteBtn: Button = view?.findViewById(R.id.) as Button
        val addBtn: Button = view?.findViewById(R.id.add_btn) as Button
        deleteBtn.setOnClickListener(object : View.OnClickListener() {
            fun onClick(v: View?) {
                //do something
                list.remove(position) //or some other task
                notifyDataSetChanged()
            }
        })
        addBtn.setOnClickListener(object : View.OnClickListener() {
            fun onClick(v: View?) {
                //do something
                notifyDataSetChanged()
            }
        })
        return view
    }

    init {
        this.list = list
        this.context = context
    }
}
class CustomArrayAdapter {
}


 */