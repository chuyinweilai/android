package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class BlankFragment2 extends Fragment {
    private View root;
    private TextView tv;
    private Button btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /*
        生命周期：布局加载时调用
        LayoutInflater inflater：作用类似于findViewById（），用来找res/layout/下的xml布局文件
        ViewGroup container：表示Fragment所在容器
        Bundle savedInstanceState：保存当前的状态，在活动的生命周期中，只要离开了可见阶段，活动很可能就会被进程终止，这种机制能保存当时的状态
    */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(root == null){
            /*LayoutInflater.inflate()方法，在给fragment添加布局文件，或者在RecyclerView的Adapter中为item添加布局时，都会用到*/
            /*inflate()这个方法需要最多三个参数：resource:具体要添加的那个布局文件，root:布局的根参数，以及attachToRoot*/
            root = inflater.inflate(R.layout.fragment_blank1, container, false);
        }

        tv = root.findViewById(R.id.tv);
        btn = root.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("you cliick btn");
            }
        });
        return root;

    }
}