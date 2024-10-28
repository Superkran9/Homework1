package com.example.homework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyActivity : AppCompatActivity(){

    lateinit var recyclerView: RecyclerView
    lateinit var fab: FloatingActionButton

    private val adapter = MyAdapter()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        fab=findViewById(R.id.fab)

        recyclerView.adapter = adapter

        fab.setOnClickListener{
            adapter.addItems(adapter.itemCount + 1)
        }

        if (savedInstanceState != null){
            val positions = savedInstanceState.getIntegerArrayList("positions")
            if (positions != null) {
                adapter.setItems(positions)
            }
        } else {
            adapter.setItems(listOf())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val positions = adapter.getItemPositions()
        outState.putIntegerArrayList("positions", positions)
    }
}