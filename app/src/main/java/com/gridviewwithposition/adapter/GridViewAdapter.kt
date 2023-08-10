package com.gridviewwithposition.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.gridviewwithposition.R
import com.gridviewwithposition.model.GridModel

class GridViewAdapter(
    private val context: Context, list: ArrayList<GridModel>,
    private val resource: Int,
) : ArrayAdapter<GridModel>(context, resource, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView = convertView
        if (listItemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listItemView =
                LayoutInflater.from(context).inflate(resource, parent, false)
        }
        val courseModel: GridModel? = getItem(position)
        val tvCounter = listItemView?.findViewById<TextView>(R.id.textCounter)
        tvCounter?.text = "${courseModel?.num ?: 0}"
        return listItemView!!
    }
}