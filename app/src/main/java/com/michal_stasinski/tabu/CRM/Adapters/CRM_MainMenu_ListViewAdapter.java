package com.michal_stasinski.tabu.CRM.Adapters;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.michal_stasinski.tabu.Menu.Models.OrderComposerItem;
import com.michal_stasinski.tabu.R;
import com.michal_stasinski.tabu.Utils.MathUtils;

import java.util.ArrayList;

/**
 * Created by mstasinski on 20.07.2017.
 */

public class CRM_MainMenu_ListViewAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<OrderComposerItem> arr;

    public CRM_MainMenu_ListViewAdapter(Context context) {

        this.mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.arr = new ArrayList<OrderComposerItem>();
    }

    public void addItem(final OrderComposerItem item) {
        this.arr.add(item);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int position) {
        return arr.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        CRM_MainMenu_ListViewAdapter.ViewHolderItem viewHolder = null;

        int rowType = getItemViewType(position);

        if (convertView == null) {
            view = View.inflate(mContext, R.layout.crm_main_menu_manager_row, null);
            viewHolder = new CRM_MainMenu_ListViewAdapter.ViewHolderItem();
            viewHolder.title = (TextView) view.findViewById(R.id.crm_main_menu_manager_row_title);
            view.setTag(viewHolder);
        } else {
            viewHolder = (CRM_MainMenu_ListViewAdapter.ViewHolderItem) view.getTag();
        }

        if (viewHolder.title != null) {
            viewHolder.title.setText(arr.get(position).getTitle()); //.toUpperCase());
        }

        return view;
    }

    static class ViewHolderItem {
        TextView title;
    }
}
