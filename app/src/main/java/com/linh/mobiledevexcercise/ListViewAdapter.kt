package com.linh.mobiledevexcercise

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView

class ListViewAdapter(context: Context, private val resource: Int, private val employees: ArrayList<Employee>) : ArrayAdapter<Employee>(context, resource, employees) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(resource, null)

        val employee = getItem(position)

        val avatar = view.findViewById<ImageView>(R.id.image_employee_avatar)
        val employeeCode = view.findViewById<TextView>(R.id.text_employee_code)
        val employeeName = view.findViewById<TextView>(R.id.text_employee_name)
        val checkbox = view.findViewById<CheckBox>(R.id.checkbox)

        if (employee!!.isFemale) {
            avatar.setImageResource(R.drawable.female)
            checkbox.isChecked = true
        } else {
            avatar.setImageResource(R.drawable.male)
            checkbox.isChecked = false
        }

        employeeCode.text = employee.code
        employeeName.text = employee.name

        return view
    }
}