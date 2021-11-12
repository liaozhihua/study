package com.example.study;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.study.entity.User;
import com.example.study.model.UserModel;

import org.jetbrains.annotations.NotNull;


public class BlankFragment extends Fragment {

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        //传进fragment布局文件创建一个view对象
        View view =inflater.inflate(R.layout.layout_another_right_fragment,container,false);
        return view;
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        ViewModelProvider viewModelProvider = new ViewModelProvider(requireActivity());
        UserModel userModel = viewModelProvider.get(UserModel.class);
//        userModel.mutableLiveData.observeForever();
        userModel.mutableLiveData.observe(BlankFragment.this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                Log.i("BlankFragment.this", "onChanged: "+"age:" + user.age + ":name:" + user.name);
            }
        });
        String aa = "赵xx";
        userModel.mutableLiveData.setValue(new User(30,aa));
    }
}
