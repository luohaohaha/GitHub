package com.gdctclock;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends BaseActivity {


	private Context   myContext;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myContext=this;
    
    }
    
    
	@Override
	protected void onResume() {
		super.onResume();
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		((TextView)findViewById(R.id.tvDate)).setText(df.format(curDate));
	}
    
    

    
}
