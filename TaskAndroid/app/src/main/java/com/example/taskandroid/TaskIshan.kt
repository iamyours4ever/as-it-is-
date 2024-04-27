package com.example.taskandroid

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class TaskIshan : AppCompatActivity() {
    lateinit var buttonDate: Button
    lateinit var textViewDate: TextView
    private lateinit var autoComplete: AutoCompleteTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)


        buttonDate = findViewById(R.id.tVDateShow)
        textViewDate = findViewById(R.id.btnDatePick)
        autoComplete = findViewById(R.id.autoComplete)


        /*access the items of the list*/
        val languages = resources.getStringArray(R.array.Languages)

        // access the spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, languages)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(
                        this@TaskIshan,
                        getString(R.string.selected_item) + " " +
                                "" + languages[position], Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        // date picker functionality
        buttonDate.setOnClickListener {
            loadCalendar()
        }

    }

    private fun loadCalendar() {
        var c = Calendar.getInstance()
        var year = c.get(Calendar.YEAR)
        var month = c.get(Calendar.MONTH)
        var day = c.get(Calendar.DAY_OF_MONTH)
        var dateDialog = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { datePicker, yy, mm, dd -> textViewDate.text = "$yy/$mm/$dd" },
            year, month,day)

        dateDialog.show()
    }

    //autocomplete
}