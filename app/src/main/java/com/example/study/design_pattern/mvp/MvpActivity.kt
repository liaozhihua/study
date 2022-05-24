package com.example.study.design_pattern.mvp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.study.R

class MvpActivity : AppCompatActivity(),IView {

    private var msgText: TextView? = null
    private var clearText: TextView? = null
    private var editView: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)
        initView()
    }

    private fun initView() {
        val presenter = Presenter(this)
        editView = findViewById<EditText>(R.id.edit)
        msgText = findViewById<TextView>(R.id.msgText)
        clearText = findViewById<TextView>(R.id.clearText)
        editView!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // 传递 文字修改 事件给 Presenter
                presenter.handleData(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        clearText!!.setOnClickListener {
            // 传递按钮点击事件给 Presenter
            presenter.clearData()
        }
    }

    override fun clearTextData() {
        editView!!.setText("")
    }

    override fun setMsgTextView(str: String?) {
        msgText!!.text = str
    }
}