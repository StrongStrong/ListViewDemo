package com.example.listviewdemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.listviewdemo.R;
import com.example.listviewdemo.data.ImageData;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    private Context context;
    private List<ImageData> list;

    public ListAdapter(Context context, List<ImageData> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.list_item,null);
            holder=new ViewHolder();
            holder.imageView=convertView.findViewById(R.id.imageView);
            holder.textView=convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(list.get(position).content);
        Glide.with(context).load(list.get(position).imgUrl).into(holder.imageView);
        return convertView;
    }



    class ViewHolder{
        ImageView imageView;
        TextView textView;

    }
}
