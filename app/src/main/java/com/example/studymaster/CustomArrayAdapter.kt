package com.example.studymaster

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.ListAdapter
import android.widget.TextView
import org.w3c.dom.Text

class MyCustomAdapter (private val list: ArrayList<String>, private val tlist: ArrayList<String>, private val context: Context) : BaseAdapter(), ListAdapter {


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

    //getter für die liste
    fun getList(): ArrayList<String> {
        return list
    }



    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {


        class ViewHolder{
            lateinit var list_item_string:TextView
            lateinit var Time:TextView
            lateinit var image_Delete:ImageButton
            lateinit var image_Start:ImageButton
        }

        val view:View
        val holder:ViewHolder

        if(convertView ==null){
           view = inflater.inflate(R.layout.custom_item_layout, parent,false)

            holder =ViewHolder()
            holder.list_item_string = view.findViewById(R.id.list_item_string) as TextView
            holder.Time = view.findViewById(R.id.Time) as TextView
            holder.image_Delete = view.findViewById(R.id.image_Delete) as ImageButton
            holder.image_Start = view.findViewById(R.id.image_Start) as ImageButton

            view.tag= holder
        } else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val listItemText = holder.list_item_string
        listItemText.text = list[position]

        val TimeItemView =  holder.Time
        TimeItemView.text = tlist[position]

        val imageButtonDelete = holder.image_Delete

        val imageButtonStart = holder.image_Start


        //function to delete subject AND time
        fun removeAll(pos: Any) {
            list.remove(pos)
            val posi = tlist.get(position) //WHY????????
            tlist.remove(posi)
            notifyDataSetInvalidated()
        }


        imageButtonDelete.setOnClickListener {
            //Toast.makeText(context, "Delete Clicked.", Toast.LENGTH_SHORT).show()
            val positionToRemove: Any = getItem(position)
            removeAll(positionToRemove)
            notifyDataSetChanged()
        }

        imageButtonStart.setOnClickListener {
            val timeInPos = TimeItemView.text.toString()
            val subjectInPos = listItemText.text.toString()
            //var timeInPosition:Int = tlist.get(position).toInt()
            //Toast.makeText(context, timeInPos, Toast.LENGTH_SHORT).show()
            val intent = Intent(context, Timer_Activity::class.java)
            intent.putExtra("TimeInPosition", timeInPos)
            intent.putExtra("SubjectInPosition", subjectInPos)
            context.startActivity(intent)

            notifyDataSetChanged()
        }
        return view

    }




    }



