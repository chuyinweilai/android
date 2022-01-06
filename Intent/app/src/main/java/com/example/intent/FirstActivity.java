package com.example.intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    // 调用父类的onCreate()方法
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 传入id加载布局,通过R.layout.first_layout得到first_layout.xml布局的id
        setContentView(R.layout.first_layout);

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // FirstActivity.this作为上下文（当前所在的对象）, SecondActivity.class活动目标
                // 即，在FirstActivity这个活动的基础上，打开SecondActivity活动。
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    // 重写onCreateOptionsMenu()方法，引入menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 通过R.menu.menu资源文件来创建菜单，并添加到menu对象中
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // 重写onOptionsItemSelected()方法，定义菜单响应事件
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "Add Menu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "Remove Menu", Toast.LENGTH_SHORT).show();
                break;
            default: break;
        }
        return true;
    }
}