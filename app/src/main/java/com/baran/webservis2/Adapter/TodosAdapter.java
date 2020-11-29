package com.baran.webservis2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.baran.webservis2.Models.TodosModel;
import com.baran.webservis2.R;

import java.util.List;

public class TodosAdapter extends BaseAdapter {
    List<TodosModel> list;
    Context context;

    public TodosAdapter(List<TodosModel> list, Context context) {
        this.list = list;
        this.context = context;
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
        convertView = LayoutInflater.from(context).inflate(R.layout.layout, parent, false);

        TextView userIdText = convertView.findViewById(R.id.userId);
        TextView idText = convertView.findViewById(R.id.id);
        TextView titleText = convertView.findViewById(R.id.title);
        CheckBox completeCheckBox = convertView.findViewById(R.id.completed);

        userIdText.setText(userIdText.getText() + " " + list.get(position).getUserId());
        idText.setText(idText.getText() + " " + list.get(position).getId() + "");
        titleText.setText(titleText.getText() + " " + list.get(position).getTitle());

        Boolean deger = list.get(position).getCompleted();
        if (deger) {
            completeCheckBox.setChecked(true);
        } else {
            completeCheckBox.setChecked(false);
        }

        return convertView;
    }
}
