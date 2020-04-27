package com.example.customprogressbutton

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.layout_custom_button.view.*

class CustomButton : ConstraintLayout {

    private var buttonText: String? = null

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        setCustomAttribute(attrs)
    }

    private fun setCustomAttribute(attrs: AttributeSet?) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.CustomButton)
        buttonText = a.getString(R.styleable.CustomButton_buttonText)
        button.text = buttonText

        a.recycle()
    }

    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.layout_custom_button, this)
    }

    fun onCustomClickListener(listener: ()->Unit){
        button.setOnClickListener { listener() }
    }

    fun load(load:Boolean){
        button.text = if (load) "" else buttonText
        button.isClickable = !load

        val color = if (load) R.color.faded else R.color.colorPrimary
        button.setBackgroundColor(resources.getColor(color))

        progress.visibility = if (load) View.VISIBLE else View.GONE
    }
}