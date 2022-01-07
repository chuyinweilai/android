package com.example.intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private static String TAG = "Mirai";

    private static String packageName = "com.example.intent";

    // 调用父类的onCreate()方法，他会在活动第一次被创建的时候调用。
    // 在此处进行初始化操作，如：加载布局、绑定事件等
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "on create");
        super.onCreate(savedInstanceState);
        // 传入id加载布局,通过R.layout.first_layout得到first_layout.xml布局的id
        setContentView(R.layout.first_layout);

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /* Intent 启动活动、传递参数 */
                //显式调用intent
                explicitIntent();
                //隐式调用intent
                //implicitIntent();
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


    // 显式调用intent
    public void explicitIntent(){
        String data = "Hello Miku";
        //FirstActivity.this作为上下文（当前所在的对象）, SecondActivity.class活动目标
        //即，在FirstActivity这个活动的基础上，打开SecondActivity活动。
        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
        // 传递参数，key,value
        intent.putExtra("extra_data", data);
        //无返回值的方法
        //startActivity(intent);
        //期望的到返回值的方法,返回后触发onActiviResult()方法
        //第一个参数为Intent对象
        //第二个参数为请求码，用于之后的回调中判断数据的来源。只要是唯一值即可
        startActivityForResult(intent, 1);
    }

    // 隐式调用intent
    public void implicitIntent() {
        // 调用页面
        // Intent intent = new Intent(packageName+".ACTION_START");
        // intent.addCategory(packageName+".MY_CATEGORY");

        // 调用网站
        // Intent intent = new Intent(Intent.ACTION_VIEW);
        // intent.setData(Uri.parse("https://www.baidu.com"));
        // tel调用拨打手机号
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:10086"));

        startActivity(intent);
    }

    // Intent返回触发
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnData = data.getStringExtra("data_return");
                    Log.d("Mirai returnData", returnData);
                }
                break;
            default:
                break;
        }

    }
}