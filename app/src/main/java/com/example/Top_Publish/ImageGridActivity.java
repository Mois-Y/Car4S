package com.example.Top_Publish;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.carapp.MainActivity;
import com.example.carapp.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


/**
 * 显示一个相册里的所有图片（GridView）
 * @author summer
 *
 */
public class ImageGridActivity extends Activity
{
    public static final String EXTRA_IMAGE_LIST = "imagelist";

    List<ImageItem> dataList;

    GridView gridView;

    ImageGridAdapter adapter;

    AlbumHelper helper;

    Button bt;

    Handler mHandler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            switch (msg.what)
            {
                case 0:
                    Toast.makeText(ImageGridActivity.this, "最多选择9张图片", Toast.LENGTH_LONG).show();
                    break;

                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);
        helper = AlbumHelper.getHelper();
        helper.init(getApplicationContext());
        dataList = (List<ImageItem>)getIntent().getSerializableExtra(EXTRA_IMAGE_LIST);
        initView();
        bt = (Button)findViewById(R.id.bt);
        bt.setOnClickListener(new OnClickListener()
        {

            public void onClick(View v)
            {
                ArrayList<String> list = new ArrayList<String>();
                Collection<String> c = adapter.map.values();
                Iterator<String> it = c.iterator();
                for (; it.hasNext();)
                {
                    list.add(it.next());
                }

                if (Bimp.act_bool)
                {
                    Intent intent = new Intent(ImageGridActivity.this, MainActivity.class);
                    startActivity(intent);
                    Bimp.act_bool = false;
                }
                for (int i = 0; i < list.size(); i++ )
                {
//                    if (Bimp.drr.size() < 9)
//                    {
                    //添加图片到数据集合
                        Bimp.drr.add(list.get(i));
//                    }
                }
                finish();
            }

        });
    }

    /**
     * 初始化
     */
    private void initView()
    {
        gridView = (GridView)findViewById(R.id.gridview);
        gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        adapter = new ImageGridAdapter(ImageGridActivity.this, dataList, mHandler);
        gridView.setAdapter(adapter);
        adapter.setTextCallback(new ImageGridAdapter.TextCallback()
        {
            public void onListen(int count)
            {
                bt.setText("完成" + "(" + count + ")");
            }
        });

        gridView.setOnItemClickListener(new OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                adapter.notifyDataSetChanged();
            }

        });

    }
}
