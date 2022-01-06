package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// implements View.OnClickListener
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button changeBtn;
    private Button replaceBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeBtn = findViewById(R.id.btn1);
        changeBtn.setOnClickListener(this);

        replaceBtn = findViewById(R.id.btn2);
        replaceBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn1:
                replaceFragment(new BlankFragment1());
                break;
            case R.id.btn2:
                replaceFragment(new ItemFragment());
        }
    }


    /*
        动态添加Fragment：
        1. 创建一个待处理的<Fragment/>.
        2. 获取FragmentManager（Fragment管理类），一般通过getSupportFragmentManager()获取；
        3. 开启一个事务transaction,一般通过调用fragmentManger.beginTransaction()获取;
        4. 使用transaction，添加各种事件；
        5. 提交事务commit()，进入执行流程。
     */
    // Fragment是存在管理栈，所有的替换、移除、添加都是针对该管理栈操作。
    private void replaceFragment(Fragment fragment){
        // 获取fragment管理类
        FragmentManager fm = getSupportFragmentManager();

        // 获取Fragment替换方法
        FragmentTransaction ft = fm.beginTransaction();

        // 将fragment替换到frLayout中的事件
        ft.replace(R.id.frLayout, fragment);

        // 当您移除或替换一个片段并向返回栈添加事务时(如上面的replace操作)
        // 系统会停止（而非销毁）移除的片段。如果用户执行回退操作进行片段恢复，该片段将重新启动
        ft.addToBackStack(null);
        // 提交事件,以便于后续执行
        ft.commit();
    }
}