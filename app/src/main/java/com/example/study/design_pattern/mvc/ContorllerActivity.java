package com.example.study.design_pattern.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.study.R;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class ContorllerActivity extends AppCompatActivity implements IView {

    private TextView msgText;
    private TextView clearText;
    private  ControlModel controlModel = new ControlModel(this);
    private Controller controller;
    private EditText editView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contorller);
        initView();
    }

    private void initView() {
        controller = new Controller(controlModel);
        editView = findViewById(R.id.edit);
        msgText = findViewById(R.id.msgText);
        clearText = findViewById(R.id.clearText);
        editView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                controller.handleData(s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        clearText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.clearData();

            }
        });
    }


    @Override
    public void setMsgTextView(String msg) {
        msgText.setText(msg);
    }

    @Override
    public void clearData() {
        editView.setText("");
    }
}