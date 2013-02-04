package com.gdctclock.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ToggleButton;

import com.gdctclock.R;
import com.gdctclock.bean.WeekModel;

public class Week_Adapter extends ArrayAdapter<WeekModel>{
	private Context context;
	
	public Week_Adapter(Context context,  List<WeekModel> arraylist) {
		
		super(context, 0, arraylist);
	    this.context=context;
	}
	
	

	
	private class Holder{
		ToggleButton btn;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder holder;
		if (convertView == null) {
			holder = new Holder();
			convertView = LayoutInflater.from(context).inflate(R.layout.adapter_week, null);
			holder.btn = (ToggleButton) convertView.findViewById(R.id.btn);
			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}
		
		WeekModel model = getItem(position);
	
		holder.btn.setTextOff(model.getTitle());
		holder.btn.setTextOn(model.getTitle());
		holder.btn.setChecked(model.getIstrue());
		
		return convertView;
	}


	
	
}
