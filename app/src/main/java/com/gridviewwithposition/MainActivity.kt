package com.gridviewwithposition

import android.os.Bundle
import android.view.MotionEvent
import android.widget.GridView
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gridviewwithposition.adapter.GridViewAdapter
import com.gridviewwithposition.model.GridModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var xCoOrdinate = 0f
        var yCoOrdinate = 0f
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listData = ArrayList<GridModel>()
        for (i in 1..24){
            listData.add(GridModel(i))
        }

        val adapter = GridViewAdapter(this, listData, R.layout.grid_view_layout)
        findViewById<GridView>(R.id.gridView).apply {
            setAdapter(adapter)
        }

        val imageView: ImageView = findViewById(R.id.iv_move)
        imageView.setOnTouchListener { v, event ->
            when (event?.actionMasked) {
                MotionEvent.ACTION_DOWN -> {
                    xCoOrdinate = v?.x!! - event.rawX
                    yCoOrdinate = v?.y!! - event.rawY
                    Toast.makeText(applicationContext, "${event.x}, ${event.y}", Toast.LENGTH_SHORT).show()
                }

                MotionEvent.ACTION_MOVE ->
                    v?.animate()?.x(event.rawX + xCoOrdinate)?.y(event.rawY + yCoOrdinate)
                        ?.setDuration(0)?.start()

            }
            true
        }

    }
}