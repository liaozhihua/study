package com.example.study.design_pattern.mvvm2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.study.R

class MvvmActivity : AppCompatActivity() {

    private var msgText: TextView? = null
    private var clearText: TextView? = null
    private var editView: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm)
//        var binding: ArchitectureBindingBinding = DataBindingUtil.inflate(inflater, R.layout.activity_mvvm, container, false)
        val viewModel = ViewModel(HandleModel())
//        binding.viewmodel = viewModel
        init()
    }

    private fun init() {
        editView = findViewById<EditText>(R.id.edit)
        msgText = findViewById<TextView>(R.id.msgText)
        clearText = findViewById<TextView>(R.id.clearText)
    }
}