package com.demosqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BaiHocAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<BaiHoc> dsBaiHoc;

    public BaiHocAdapter(Context context, int layout, ArrayList<BaiHoc> dsBaiHoc) {
        this.context = context;
        this.layout = layout;
        this.dsBaiHoc = dsBaiHoc;
    }


    @Override
    public int getCount() {
        return dsBaiHoc.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolder{
        TextView textView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null)
        {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.textView = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);

        }
        else
            holder = (ViewHolder) convertView.getTag();
        BaiHoc baiHoc = dsBaiHoc.get(position);
        holder.textView.setText(baiHoc.getTen());
        return convertView;
    }
}
