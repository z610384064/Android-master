package com.hjq.demo.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hjq.demo.R;
import com.hjq.demo.bean.PhoneDto;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private List<PhoneDto> list;
    public ListViewAdapter(){}
    public ListViewAdapter(List<PhoneDto> list ,Context context){
        this.list=list;
        this.context=context;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder holderView=null;
        if (convertView==null){
            convertView=View.inflate(context, R.layout.item,null);
            holderView=new ViewHolder();
            holderView.name= (TextView) convertView.findViewById(R.id.name);
            holderView.phone= (TextView) convertView.findViewById(R.id.phone);
            convertView.setTag(holderView);
        }else {
            holderView= (ViewHolder) convertView.getTag();
        }
        holderView.name.setText(list.get(i).getName());
        holderView.phone.setText(list.get(i).getTelPhone());
        return convertView;
    }
    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public Object  getItem(int i) {
        return list.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }

class ViewHolder {
    private TextView name;
    private TextView phone;
}
}
