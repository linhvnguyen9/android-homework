package com.linh.mobiledevexcercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListAdapter
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {
    private lateinit var adapter : ListViewAdapter
    private val employees = arrayListOf(
        Employee("ma1", "Nguyen Van Linh", false),
        Employee("ma2", "Pham Phi Long", false),
        Employee("ma3", "Le Vu Nam", false),
        Employee("ma4", "Nguyen Duc Anh", false),
        Employee("ma5", "Phan Van Nhi", true),
        Employee("ma5", "Nguyen Hong Hanh", true),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
    }

    override fun onStart() {
        super.onStart()

        adapter = ListViewAdapter(this, R.layout.item_employee, employees)

        list_employees.adapter = adapter

        button_submit.setOnClickListener {
            val code = edit_employee_code.text.toString()
            val name = edit_employee_name.text.toString()
            val isFemale = radio_female.isChecked

            val employee = Employee(code, name, isFemale)

            employees.add(employee)
            adapter.notifyDataSetChanged()
        }
    }
}