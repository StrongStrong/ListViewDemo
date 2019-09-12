package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.listviewdemo.adapters.ListAdapter;
import com.example.listviewdemo.data.ImageData;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListAdapter adapter;
    private List<ImageData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView=findViewById(R.id.listView);
        list=Utils.getData();
        adapter=new ListAdapter(this,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int visiblePosition = listView.getFirstVisiblePosition();
                if (position - visiblePosition >= 0) {
                    //得到要更新的item的view
                    list.set(position,new ImageData("http://www.youmeitu.com/Upload/20190524/1558689622196147.jpg","修改之后的数据"));
                    View v = listView.getChildAt(position - visiblePosition);
                    TextView textView=v.findViewById(R.id.textView);
                    textView.setText(list.get(position).content);
                    ImageView imageView=v.findViewById(R.id.imageView);
                    Glide.with(MainActivity.this).load(list.get(position).imgUrl).into(imageView);

                    
                }
            }
        });

    }
}
