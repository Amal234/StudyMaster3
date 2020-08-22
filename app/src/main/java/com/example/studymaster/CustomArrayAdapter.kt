package com.example.studymaster

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import android.widget.AdapterView.OnItemClickListener
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.monday.*

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

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val rowView = inflater.inflate(R.layout.custom_item_layout, parent, false)

        //All Elements in our customlayout
        val listItemText = rowView.findViewById(R.id.list_item_string) as TextView
        listItemText.text = list[position]

        val TimeItemView = rowView.findViewById(R.id.Time) as TextView
        TimeItemView.text = tlist[position]

        val imageButtonDelete = rowView.findViewById(R.id.image_Delete) as ImageButton

        val imageButtonStart = rowView.findViewById(R.id.image_Start) as ImageButton


        //function to delete subject AND time
        fun removeAll(pos: Any){
            list.remove(pos)
            val posi= tlist.get(position) //WHY????????
            tlist.remove(posi)
            notifyDataSetInvalidated()
        }


        imageButtonDelete.setOnClickListener {
            //Toast.makeText(context, "Delete Clicked.", Toast.LENGTH_SHORT).show()
            val positionToRemove:Any = getItem(position)
            removeAll(positionToRemove)
            notifyDataSetChanged()
    }

        imageButtonStart.setOnClickListener {
            var timeInPos = TimeItemView.text.toString()
            var subjectInPos = listItemText.text.toString()
            //var timeInPosition:Int = tlist.get(position).toInt()
            //Toast.makeText(context, timeInPos, Toast.LENGTH_SHORT).show()
            val intent = Intent(context, Timer_Activity::class.java)
            intent.putExtra("TimeInPosition", timeInPos)
            intent.putExtra("SubjectInPosition", subjectInPos)
            context.startActivity(intent)

            notifyDataSetChanged()
            }



        return rowView

    }


}

