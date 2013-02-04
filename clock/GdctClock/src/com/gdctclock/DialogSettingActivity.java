package com.gdctclock;

import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ToggleButton;


import com.gdctclock.service.TurnService;

public class DialogSettingActivity extends Activity {

	public static final String SERVICE_NAME = "com.gdctclock.service.TurnService";
	private Context   myContext;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogsetting);
        myContext=this;
        
        
        ((ImageButton)findViewById(R.id.btnback)).setOnClickListener(new OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			finish();
    		}
    	});
        
    
        ToggleButton serviceSwitch = (ToggleButton) findViewById(R.id.btnturn);
		serviceSwitch.setChecked(isServiceRunning (SERVICE_NAME));
		serviceSwitch.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if(isChecked == true){
					startService(new Intent(myContext, TurnService.class));
					Toast.makeText(myContext, "·­×ª¹Ø±ÕÄÖÖÓ ¿ªÆô", Toast.LENGTH_SHORT).show();
				}else{
					stopService(new Intent(myContext, TurnService.class));
					Log.d("TESTCLOCK", "serviceRun ? = " + isServiceRunning ( SERVICE_NAME));
					Toast.makeText(myContext, "·­×ª¹Ø±ÕÄÖÖÓ ¹Ø±Õ", Toast.LENGTH_SHORT).show();
				}
			}
		});
    }
    
    
    private boolean isServiceRunning(String serviceName) {
		boolean isRunning = false;
		ActivityManager activityManager = (ActivityManager) myContext.getSystemService(ACTIVITY_SERVICE);

		List<ActivityManager.RunningServiceInfo> serviceList = activityManager.getRunningServices(Integer.MAX_VALUE);
		if(! (serviceList.size()>0)){
			return false;
		}
		for(int i = 0 ; i < serviceList.size() ; i++){
			if(serviceList.get(i).service.getClassName().equals(SERVICE_NAME)){
				isRunning = true;
				break;
			}
		}
		return isRunning;
		
	}
    
    

    
}
