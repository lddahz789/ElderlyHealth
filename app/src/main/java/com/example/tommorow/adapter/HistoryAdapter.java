package com.example.tommorow.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tommorow.R;
import com.example.tommorow.entity.FoodModel;

import java.util.List;

/**
 * 查看早中晚饭 添加食物的历史记录  注意 记录是每天凌晨清空
 */

public class HistoryAdapter extends BaseAdapter {
    private List<FoodModel> foodModelList;
    private Context context;
    private int type;

    public HistoryAdapter(List<FoodModel> foodModelList, Context context, int type) {
        this.foodModelList = foodModelList;
        this.context = context;
        this.type = type;
    }

    @Override
    public int getCount() {
        return foodModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return foodModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.history_item, null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.amount = (TextView) convertView.findViewById(R.id.amount);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(foodModelList.get(position).getFoodName());
        if (type == 1) {
            viewHolder.amount.setText(context.getResources().getString(R.string.amount) + ": " + foodModelList.get(position).getAmount() + "g");
        } else {
            viewHolder.amount.setVisibility(View.GONE);
        }
        return convertView;
    }

    class ViewHolder {
        TextView name;
        TextView amount;
    }
}
