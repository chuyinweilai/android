package com.example.layout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /*初始化Menu*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*return super.onCreateOptionsMenu(menu);*/
        /*第一个参数，用于指定我们通过哪一个资源文件夹，来创建菜单
        第二个参数，用于指定菜单项将，添加到哪一个Menu对象中
        返回true，表示允许创建的菜单显示出来*/
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /*重写Menu select*/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.item_1:
//                Toast.makeText(this, "You Click Add", Toast.LENGTH_SHORT).show();
                intent = (Intent) new Intent("com.example.layout.ACTION_LINEAR");
                intent.addCategory("com.example.layout.MY_LINEAR");
                startActivity(intent);
                break;
            case R.id.item_2:
//                Toast.makeText(this, "You Click Remove", Toast.LENGTH_SHORT).show();
                intent = (Intent) new Intent("com.example.layout.ACTION_RELATIVE");
                intent.addCategory("com.example.layout.MY_RELATIVE");
                startActivity(intent);
                break;
            case R.id.item_3:
                intent = (Intent) new Intent("com.example.layout.FRAME_LAYOUT");
                intent.addCategory("com.example.layout.MY_FRAME");
                startActivity(intent);
                break;
            case R.id.item_4:
                intent = (Intent) new Intent("com.example.layout.TABLE_LAYOUT");
                intent.addCategory("com.example.layout.MY_TABLE");
                startActivity(intent);
            case R.id.item_5:
                intent = (Intent) new Intent("com.example.layout.GRID_LAYOUT");
                intent.addCategory("com.example.layout.MY_GRID");
                startActivity(intent);
                break;
            default: break;
        }
        return true;
    }
}