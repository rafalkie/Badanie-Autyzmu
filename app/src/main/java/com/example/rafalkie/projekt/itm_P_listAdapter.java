package com.example.rafalkie.projekt;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rafalkie on 12.06.2017.
 */

public class itm_P_listAdapter extends BaseAdapter {

    private Context mContext;
    private List<itm_P> mList;

    public itm_P_listAdapter(Context mContext, List<itm_P> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext,R.layout.iteam_pytania,null);
        TextView iteam_pyt = (TextView) v.findViewById(R.id.iteam_pyt);
        TextView iteam_tre = (TextView) v.findViewById(R.id.iteam_tre);

//        iteam_pyt.setText(mList.get(position).getId());
        iteam_tre.setText(String.valueOf(mList.get(position).getTresc()));
        iteam_pyt.setText(String.valueOf(mList.get(position).getPytanie()));


        v.setTag(mList.get(position).getId());
        return v;
    }
}
