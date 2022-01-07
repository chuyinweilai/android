package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //构建Intent用于数据传递
                Intent intent = new Intent();
                intent.putExtra("data_return", "Hello Mirai");
                //第一个参数用于返回处理状态
                //第二个参数返回带有数据的Intent
                setResult(RESULT_OK, intent);
                // 销毁当前活动
                finish();
            }
        });

    }

    // 重写返回事件，包括销毁和返回按钮
    @Override
    public void onBackPressed() {
        //s*uper.onBackPressed();
        // 获取启动SecondActivity的Intent对象
        Intent intent = getIntent();
        //使用getStringExtra()方法获取传递的参数
        //Init：getIntExtra(),
        //String：getStringExtra(),
        //Boolean：getBooleanExtra(),
        String data = intent.getStringExtra("extra_data");
        Log.d("Mirai logd", data);

        intent.putExtra("data_return", "Hello Mirai");
        setResult(RESULT_OK, intent);
        finish();
    }
}