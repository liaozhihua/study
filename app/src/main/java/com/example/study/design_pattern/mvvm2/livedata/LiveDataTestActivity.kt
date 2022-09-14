package com.example.study.design_pattern.mvvm2.livedata

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.example.study.R

class LiveDataTestActivity : AppCompatActivity() {

    private var mLiveData: MutableLiveData<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_test)
        //liveData基本使用
        mLiveData = MutableLiveData<String>()
        mLiveData!!.observe(this) {
                s -> Log.i(TAG, "onChanged: $s")
        }

        Log.i(TAG, "onCreate: ")
        //activity是非活跃状态，不会回调onChanged。变为活跃时，value被onStart中的value覆盖
        mLiveData!!.value = "onCreate"
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart: ")
        //活跃状态，会回调onChanged。并且value会覆盖onCreate、onStop中设置的value
        mLiveData!!.value = "onStart"
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: ")
        mLiveData!!.value = "onResume" //活跃状态，回调onChanged
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause: ")
        mLiveData!!.value = "onPause" //活跃状态，回调onChanged
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop: ")
        //非活跃状态，不会回调onChanged。后面变为活跃时，value被onStart中的value覆盖
        mLiveData!!.value = "onStop"
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: ")
        //非活跃状态，且此时Observer已被移除，不会回调onChanged
        mLiveData!!.value = "onDestroy"
    }
}