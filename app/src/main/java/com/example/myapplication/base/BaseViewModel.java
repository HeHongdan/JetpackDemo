package com.example.myapplication.base;


import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.enums.LoadState;

/**
 * ViewModel的基类
 */
public abstract class BaseViewModel extends ViewModel implements DefaultLifecycleObserver {

    /**
     * 加载状态
     */
    public MutableLiveData<LoadState> loadState = new MutableLiveData<>();

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {

    }

    /**
     * 重新加载数据。没有网络，点击重试时回调
     */
    public void reloadData() {

    }
}
