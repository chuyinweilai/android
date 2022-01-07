package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class ThirdActivity extends AppCompatActivity {

    private static String TAG = "Mirai";

    // 在活动第一次被创建的时候调用。在此处进行初始化操作，如：加载布局、绑定事件等
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);
    }

    // 在活动由不可见变为可见时调用
    @Override
    protected void onStart() {
        Log.e(TAG, "on start");
        super.onStart();
    }

    // 在活动准备与用户交互时调用，此时的活动一定位置于返回栈的栈顶，并且处于运行状态
    @Override
    protected void onResume() {
        Log.e(TAG, "on resume");
        super.onResume();
    }

    // 在系统准备去启动或者恢复另一个活动时调用。通常在该生命周期释放掉消耗CPU的资源，并保存关键数据，切执行速度要快。
    @Override
    protected void onPause() {
        super.onPause();
    }

    // 在活动完全不可见时调用,
    // 做释放资源的操作
    @Override
    protected void onStop() {
        super.onStop();
    }

    // 活动被销毁前调用
    // 是你最后去清除那些可能导致内存泄漏的地方
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    // 活动由停止变为运行状态之前调用
    @Override
    protected void onRestart() {
        super.onRestart();
    }
}