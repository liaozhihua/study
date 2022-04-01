package com.example.study.design_pattern.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.study.R;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class ContorllerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contorller);
        ReferenceQueue<Object> referenceQueuee = new ReferenceQueue<>();
        Object phantomObject = new Object();
        PhantomReference phantomReference = new PhantomReference(phantomObject, referenceQueuee);
        phantomObject = null;
        System.out.println("phantomObject:" + phantomObject);//null
        System.out.println("phantomReference" + referenceQueuee.poll());//null
        System.gc();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void updateUI(String s) {
        mTextView.setText(text);
    }
}