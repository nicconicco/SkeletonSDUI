package com.nicco.skeletonsdui.sdui.components

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.nicco.skeletonsdui.sdui.validator.Validator
import java.util.*

class Picker: Validator, Component(), DatePickerDialog.OnDateSetListener {
    override fun isValid(): Boolean {
        return true
    }

    override fun getView(context: Context): View {
        val button = Button(context)
        button.text = "Click me"
        val layoutParams =
            ConstraintLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )

        button.layoutParams = layoutParams

        button.setOnClickListener {
            Toast.makeText(context, "Hello you have clicked me", Toast.LENGTH_SHORT).show()
        }

        return button
    }

    fun getDialog(context: Context): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(context, this, year, month, day)
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {

    }
}