package com.example.toptab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carapp.R;
import com.example.toptab.Notifyy.NotifyAdapter;

public class Notify extends Activity {
    private Button setback;//返回按钮
    private RecyclerView lRecyclerView;     //列表控件
    private NotifyAdapter lAdapter;                //适配器
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notify);
        setback = findViewById(R.id.setback);
        setback.setOnClickListener(new ClickEvent());
        initView();             //初始化控件
        setAdapter();           //设置适配器

    }
    /**
     * 初始化控件方法
     */
    private void initView(){
        //获取列表控件
        lRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
    }

    /**
     * 设置适配器方法
     */
    private void setAdapter(){
        //设置列表布局管理
        lRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置适配器
        lRecyclerView.setAdapter(lAdapter = new NotifyAdapter(this));
        //设置列表中子项的动画
        lRecyclerView.setItemAnimator(new DefaultItemAnimator());


    }
    class ClickEvent implements View.OnClickListener {
        public void onClick(View v){
            switch (v.getId()){
                case R.id.setback:
                    Notify.this.finish();
                    break;
            }
        }
    }
}
